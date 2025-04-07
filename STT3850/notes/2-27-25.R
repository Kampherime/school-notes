install.packages("ggplot2")
library(ggplot2)
# Create a data frame with x values and different degrees of freedom
x <- seq(0, 20, by = 0.1)
df_data <- data.frame(
  x = rep(x, 3),
  df = c(rep(5, length(x)), rep(10, length(x)), rep(20,
                                                    length(x)))
)
# Calculate the density for each degree of freedom
df_data$y <- dchisq(df_data$x, df = df_data$df)
# Plot the curves with color differentiation
ggplot(df_data, aes(x = x, y = y, color = factor(df))) + geom_line() + labs(title = "Chi-Square Distributions with Different Degrees of Freedom", x = "Chi-Square Statistic", y = "Density", color = "Degrees of Freedom")
3

# Null hypothesis: If mu stands for average height of adult males in a population, Ho: mu = 175cm, Ha: mu > 175cm.

x  <- c(3, 7, 11, 0, 7, 0, 4, 5, 6, 2)
# make the qqplot
qqnorm(x)
qqline(x)

t.test(x, mu = 3, alternative = "greater")

x <- c(4,8,11,9,6,9,3,8,9,10)
