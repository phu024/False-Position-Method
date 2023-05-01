# Computing square root of a number using False Position method

Computing $\sqrt{A}$ is equivalent to solving $x^{2} - A = 0.$ The nimner $\sqrt{A}$ , thus, may computed by applying the *False Position method* 

## False Position method (Reqular Falsi)

1. Choose initial estimate $x_0$ and $x_1$ that bracket the root
2. Compute $x_2$ as $x$ intercept of the tangent(secant) line passing thethrough $x_0$ and $x_1$

    $x_{i+1} = x_{i} - f(x_{i})\left(\frac{x_{i}-x_{i-1}}{f(x_{i})-f(x_{i-1})}  \right)$

3. Check the if $[x_1, x_2]$ bracket the root $f(x_1)f(x_2) < 0$
    - if YES continue to the next interation, $x_{i-1} = x_{1}, x_{i} = x_{2}$
    - if No, $x_{i-1} = x_{0}, x_{i} = x_{2}$

4. Repeat step 2-3 until stop condition * :
   - $f(x) < epsilon$
   - $|\frac{x - x_{prev}}{x}| < epsilon$
   - iteration > max_iteration
