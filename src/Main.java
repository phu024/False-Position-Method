/**
 * @Author: Phuwadon Decharam
 * @Created Date: 2023-05-01 16:58:00
 * @Last Modified by: Phuwadon Decharam
 * @Last Modified time: 2023-05-01 17:00:00
 */

import java.util.Scanner;

public class Main {

    /**
     * A is the number to find square root
     */
    static float A;

    public static void main(String[] args) {
        float X0, X1, epsilon;
        int max_iteration;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Find square root of: ");
            A = sc.nextFloat();
            while (A < 0) {
                System.out.print("Please enter a non-negative number: ");
                A = sc.nextFloat();
            }
            System.out.println("Initial interval [X0, X1]: ");
            System.out.printf("X0 = ");
            X0 = sc.nextFloat();
            while (X0 < 0) {
                System.out.print("Please enter a non-negative number: ");
                X0 = sc.nextFloat();
            }
            System.out.printf("X1 = ");
            X1 = sc.nextFloat();
            while (X1 < 0) {
                System.out.print("Please enter a non-negative number: ");
                X1 = sc.nextFloat();
            }
            epsilon = (float) Math.pow(10, -7);
            System.out.println("epsilon = " + epsilon);
            System.out.printf("Max iteration = ");
            max_iteration = sc.nextInt();
            while (max_iteration <= 0) {
                System.out.print("Please enter a positive integer: ");
                max_iteration = sc.nextInt();
            }
        }

        compute_square_root_using_false_position(X0, X1, epsilon, max_iteration);
    }

    /**
     * Computes f(x) = x^2 - A
     */
    public static float f(float x) {
        return (float) Math.pow(x, 2) - A;
    }

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
    public static void compute_square_root_using_false_position(float X0, float X1, float epsilon, int max_iteration) {
        if (f(X0) * f(X1) < 0) {
            float X2 = 0;
            float x_prev = 0;
            for (int iteration = 1; ; iteration++) {
                X2 = X1 - f(X1) * (X1 - X0) / (f(X1) - f(X0));
                System.out.println("Iteration " + iteration + ": X0 = " + X0 + ", X1 = " + X1 + ", X2 = " + X2);
                if (f(X2) * f(X1) < 0) {
                    X0 = X2;
                } else {
                    X1 = X2;
                }
                if (Math.abs(f(X2)) < epsilon) {
                    System.out.println("Stop condition 1 : f(x) < epsilon");
                    System.out.println("Found square root of " + A + " = " + X2);
                    break;
                }
                if (Math.abs(X2 - x_prev) / Math.abs(X2) < epsilon) {
                    System.out.println("Stop condition 2 : |x - x_prev| / |x| < epsilon");
                    System.out.println("Found square root of " + A + " = " + X2);
                    break;
                }
                if (iteration == max_iteration) {
                    System.out.println("Stop condition 3 : iteration > max_iteration");
                    System.out.println("Found square root of " + A + " = " + X2);
                    break;
                }
                x_prev = X2;
            }
        } else {
            System.out.println("Initial interval [X0, X1] is not valid");
        }
    }
}

