women_weight <- c(38.9, 61.2, 73.3, 21.8, 63.4, 64.6, 48.4,
                  48.8, 48.5)
men_weight <- c(67.8, 60, 63.4, 76, 89.4, 73.3, 67.3, 61.3,
                62.4)
# Create a data frame
my_data <- data.frame(
  group = rep(c("Women", "Men"), each = 9),
  weight = c(women_weight, men_weight)
)

res.ftest <- var.test(weight ~ group, data = my_data)
res.ftest

res <- t.test(weight ~ group, data = my_data, var.equal = TRUE)
res