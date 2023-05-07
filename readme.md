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

1. Choose initial estimate $x_0$ and $x_1$ that bracket the root. such that $f(x_0) * f(x_1) < 0$.
2. Check if $f(x_0) * f(x_1) < 0$. If not, then choose another interval
3. Compute $x_2$ as $x$ intercept of the tangent(secant) line passing thethrough $x_0$ and $x_1$

    $x_{i+1} = x_{i} - f(x_{i})\left(\frac{x_{i}-x_{i-1}}{f(x_{i})-f(x_{i-1})}  \right)$

3. Check the if $[x_1, x_2]$ bracket the root $f(x_1)f(x_2) < 0$
    - if YES continue to the next interation, $x_{i-1} = x_{1}, x_{i} = x_{2}$
    - if No, $x_{i-1} = x_{0}, x_{i} = x_{2}$

5. Repeat step 3-4  until a stop condition is met:
   - $f(x) < epsilon$
   - $|\frac{x - x_{prev}}{x}| < epsilon$
   - iteration > max_iteration
