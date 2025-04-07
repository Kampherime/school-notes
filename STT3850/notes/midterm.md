# Notes for things you don't know

- Shapiro Wikes for normality, Ho is that it IS normal.
- For a Q-Q test, if the points adhere to the line, that means it is normal.
- Rainbow test for linearity (Ho -> linear)

Assumptions of linear regression: 
- Linear relationship, no multicolinearity, homoscedasticity, normally distributed error terms, and no autocorrelations
    - For multicolinearity, do a ind. of ind. variable test. Look for all values being less than 5.
    - For homoscedasticity, graph it
    - For linearity, rainbow test
    - Can also use breusch-pagan test for homoscedasticityb
    

ANOVA:
Used to determine whether things are independent (there are differences between them)
    - we used anova for the crop data, to determine whether the fertilizers were more or less effective than another. 

One sample T Test: 
- Used for comparing a mean to a known value

Two sample T test:
- Can be paired or unpaired
    - Paired is when the samples are dependent
    - Unpaired is when they are independent
    - They both test for related means.
    - Welch's T-Test for unequal variance

Z vs T test:
- Z test for large sample, known pop SD
- T test for small samples, unknown pop SD

Assumptions:
- T Test
    - Independent samples, normally distributed, equal variances
- Chi sq GOF
    - All expected values are greater than 5
    - Ho: No significant difference between sample and expected values
    - Ha: There is a significant difference
- Chi sq Ind.
    - Determines whether two categorical variables are related
    - Ho: There is no relationship
    - Ha: there is :)
    - Same assumption as GOF

Tilde ~ is dep -> ind in lm 
