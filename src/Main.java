/**
 * Computing square root of a number using False Position method
 * sqrt(A) is equivalent to solving f(x) = x^2 - A = 0
 * False Position method:
 * 1. Choose initial interval [X0, X1] such that f(X0) * f(X1) < 0
 * 2  Checking if f(X0) * f(X1) < 0, if not, then choose another interval
 * 2. Compute X2 = X1 - f(X1) * (X1 - X0) / (f(X1) - f(X0))
 * 3. If f(X2) * f(X1) < 0, then X0 = X2, else X1 = X2
 * 4. Repeat step 2-3 until stop condition * :
 * 1. f(x) < epsilon
 * 2. |x - x_prev| / |x| < epsilon
 * 3. iteration > max_iteration
 */

/*
 * @Author: Phuwadon Decharam
 * @Created Date: 2565-05-01 16:58:00
 *@Last Modified by: Phuwadon Decharam
 *@Last Modified time: 2565-05-01 16:58:00
 * */

import java.util.Scanner;
import java.lang.Math;

public class Main {

    // A is a number that we want to find square root
    static float A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Find square root of: ");
        A = sc.nextFloat();
        System.out.println("Initial interval [X0, X1]: ");
        System.out.printf("X0 = ");
        float X0 = sc.nextFloat();
        System.out.printf("X1 = ");
        float X1 = sc.nextFloat();
        float epsilon = 1 * (float) Math.pow(10, -7);
        System.out.println("epsilon = " + epsilon);
        System.out.printf("Max iteration = ");
        int max_iteration = sc.nextInt();
        FindSqrtUsingFalsePosition(X0, X1, epsilon, max_iteration);
    }

    public static float f(float x) {
        return (float) Math.pow(x, 2) - A;
    }

    public static void FindSqrtUsingFalsePosition(float X0, float X1, float epsilon, int max_iteration) {

        float X2 = 0;
        float x_prev = 0;
        if (f(X0) * f(X1) < 0) {
            for (int k = 1; k <= max_iteration; k++) {
                X2 = X1 - f(X1) * (X1 - X0) / (f(X1) - f(X0));
                System.out.println("Iteration " + k + ":" + " X0 = " + X0 + ", X1 = " + X1 + ", X2 = " + X2);
                if (Math.abs(X2 - x_prev) / Math.abs(X2) < epsilon) {
                    System.out.printf("Stop condition 2: |x - x_prev| / |x| < epsilon\n");
                    System.out.println("x = " + X2);
                    break;
                }
                if (Math.abs(f(X2)) < epsilon) {
                    System.out.println("Stop condition 1: f(x) < epsilon");
                    System.out.println("x = " + X2);
                    break;
                }
                if (k == max_iteration) {
                    System.out.printf("Stop condition 3: iteration > max_iteration\n");
                    System.out.println("x = " + X2);
                    break;
                }

                if (f(X2) * f(X1) < 0) {
                    X0 = X2;
                } else {
                    X1 = X2;
                }

                x_prev = X2;  // Keep previous value of X2 for checking stop condition 2
            }
        } else {
            // f(X0) * f(X1) >= 0
            System.out.println("Initial interval [X0, X1] is not valid");
        }
    }
}

