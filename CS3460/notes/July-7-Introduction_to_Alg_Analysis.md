# 7-7-25

### Introduction: Algorithms and Data Structures
- Algorithms take _finite_ amounts of time. 
    - For this class, their definitions are:
        - Algorithm: A step-by-step prodecure for performing some task in a finite amount of time.
        - Data Structure: A systematic way of organizing and accessing data.
- Algorithm design -> Data structure -> Implementation.
    - You'll literally NEVER guess which step ___data structures___ is about :)
        - You'll also never guess which step ___algorithm design and analysis___ is about. 
- Scalability is the capacity of a system to handle an increasing workload or input size. 
- We focus on running time but space complexity is also a factor of consideration.
- The same program with the same length input can take different times. 
    - The hardware environment (clock rate, mem size, disk etc.) and the software environment (operating system, programming language, etc) both effect speed.

### Algorithmic Analysis Models:

- RAM (Random Access Machine) Model:
    - Primitive Operations: Basic operations that take identical time irrespective to any programming language or input size. 
        - Assigning, indexing, comparing, returning/calling methods, arithmetic, etc.
    - A computational model where a CPU accesses memory cells in constant time. 
    - Best case, worst case, and average case analysis are all considered. 

## 7-8-25

### More on Algorithmic Analysis Models:
- We can do algorithm analysis "precisely" by counting the individual primitive operations in any algorithm.
    - We can do this with recursion as well using "recurrence equations" (get it like recursion x) )
        - Recurrence equations have closed-forms. They're nearly identical in form to the iterative algorithms most of the time.

- Asymptotic Analysis:
    - We have 3 different symbols for asymptotic runtime analysis. $\Theta(n)$, $\Omega(n)$, and $O(n)$.
        - "We say that $g(n)$ is an _asymptotically tight bound_ for $f(n)$".
        - $\Theta(g(n))$ is sort of defined using the Squeeze theorem with 3 different constants $c_1$, $c_2$, and $n_0$ such that $0 \leq c_1g(n) \leq f(n) \leq c_2g(n) \forall n \geq n_0$
            - We use a limit with the squeeze theorem-esq implementation to define $\Theta(n)$. If we have the limit of (as n tends towards infinity) of $\frac{f(n)}{g(n)} = c$ then we have that $f(n) = \Theta(n)$.
        - $O(n)$ is what you're familiar with. It is defined as an _asymptotically upper bound_ for $f(n)$.
            - If we have the limit (as n tends towards infinity) of $\frac{f(n)}{g(n)} \neq \infty \implies f(n) = O(g(n))$
        - $\Omega(g(n))$ is the _asymptotically lower bound_ for $f(n)$.
            - Same limit except $\lim \neq 0$
