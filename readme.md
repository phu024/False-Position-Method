# Computing square root of a number using False Position method

This is a Java program that uses the False Position method to find the square root of a non-negative number. The False Position method is a numerical method that finds the root of a function by bracketing the root between two points and then iteratively reducing the size of the bracketed interval. In this program, we are solving the equation $x^{2} - A = 0.$ to find the square root of A.

## Getting Started

### Prerequisites

To run this program, you will need:

- Java Development Kit (JDK) 8 or higher installed on your machine
- A Java IDE or a text editor to write and run the program

## Usage

To run the program, compile the `Main.java` file and run the `Main` class.

```
javac Main.java
java Main
```

The program will prompt the user to enter the number to find the square root of, the initial interval [X0, X1], the epsilon value, and the maximum number of iterations. The program will then compute the square root of the number using the false position method and print out the result.

<!-- ## How to Use

1. Run the program.
2. Enter the number you want to find the square root of.
3. Enter the initial interval [X0, X1] that brackets the root of the function. Make sure that f(X0) * f(X1) < 0, where f(x) = x^2 - A.
4. Enter the maximum number of iterations you want the program to perform.
5. The program will output the results of each iteration until it finds the root of the function. -->

## Algorithm

The false position method(Reqular Falsi) works as follows:

1. Choose initial estimate $x_0$ and $x_1$ that bracket the root. Such that $f(x_0) * f(x_1) < 0$.
2. Check if $f(x_0) * f(x_1) < 0$. If not, then choose another interval
3. Compute $x_2$ as $x$ intercept of the tangent(secant) line passing thethrough $x_0$ and $x_1$

    $x_{i+1} = x_{i} - f(x_{i})\left(\frac{x_{i}-x_{i-1}}{f(x_{i})-f(x_{i-1})}  \right)$

4. Check the if $[x_1, x_2]$ bracket the root $f(x_1)f(x_2) < 0$
    - if YES continue to the next interation, $x_{i-1} = x_{1}, x_{i} = x_{2}$
    - if No, $x_{i-1} = x_{0}, x_{i} = x_{2}$

5. Repeat step 3-4  until a stop condition is met:
   - $f(x) < epsilon$
   - $|\frac{x - x_{prev}}{x}| < epsilon$
   - iteration > max_iteration

In this program, we are using the above algorithm to solve the equation $x^{2} - A = 0.$ to find the square root of A.

## Example

Here is an example of how to use the program:

```

Find square root of: 25
Initial interval [X0, X1]: 
X0 = 0
X1 = 10
epsilon = 1.0E-7
Max iteration = 100
Iteration 1: X0 = 0.0, X1 = 10.0, X2 = 2.5
Iteration 2: X0 = 2.5, X1 = 10.0, X2 = 4.0
Iteration 3: X0 = 4.0, X1 = 10.0, X2 = 4.642857
Iteration 4: X0 = 4.642857, X1 = 10.0, X2 = 4.878049
Iteration 5: X0 = 4.878049, X1 = 10.0, X2 = 4.9590163
Iteration 6: X0 = 4.9590163, X1 = 10.0, X2 = 4.9863014
Iteration 7: X0 = 4.9863014, X1 = 10.0, X2 = 4.995429
Iteration 8: X0 = 4.995429, X1 = 10.0, X2 = 4.9984756
Iteration 9: X0 = 4.9984756, X1 = 10.0, X2 = 4.999492
Iteration 10: X0 = 4.999492, X1 = 10.0, X2 = 4.9998307
Iteration 11: X0 = 4.9998307, X1 = 10.0, X2 = 4.9999437
Iteration 12: X0 = 4.9999437, X1 = 10.0, X2 = 4.9999814
Iteration 13: X0 = 4.9999814, X1 = 10.0, X2 = 4.9999933
Iteration 14: X0 = 4.9999933, X1 = 10.0, X2 = 4.999998
Iteration 15: X0 = 4.999998, X1 = 10.0, X2 = 4.999999
Iteration 16: X0 = 4.999999, X1 = 10.0, X2 = 4.9999995
Stop condition 2 : |x - x_prev| / |x| < epsilon
Found square root of 25.0 = 4.9999995

```
## Authors

* **Phuwadon Decharam** 

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## Acknowledgments

* This program is based on the False Position method described in "Numerical Methods for Engineers" by Steven C. Chapra and Raymond P. Canale.
