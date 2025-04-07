MOE<-1.96*sqrt((0.5^2)/20)
SDERR<-MOE/1.96
SDERR6<-sqrt((0.6*0.4)/30)
MOE6<-SDERR*2.05
SDERR7<-sqrt((0.7*0.3)/40)
MOE7<-SDERR7*2.17
SDERR8<-sqrt((0.8*0.2)/50)
MOE8<-SDERR8*2.33
SDERR9<-sqrt((0.9*0.1)/60)
MOE9<-SDERR9*2.576

data <- c(10, 12, 8, 15, 9)
# Calculate sample standard deviation
sample_sd <- sd(data)
# Calculate sample size
sample_size <- length(data)
# Calculate standard error
SE <- sample_sd / sqrt(sample_size)
# Set confidence level (e.g., 95%)
alpha <- 0.05
# Find critical value (assuming normal distribution)
critical_value <- qnorm(1 - alpha/2)
# Calculate margin of error
margin_of_error <- critical_value * SE
print(margin_of_error)

10+12+8+15+9
54/5
(0.8^2)+(1.2^2)+(2.8^2)+(4.2^2)+(1.8^2)
sqrt(30.8/4)
1.96*sqrt(30.8/4)/sqrt(5)
1.96*1.2409
13-11.5
14-11.5
8-11.5
25-11.5
3-11.5
6-11.5
x_xbar<- c(1.5,2.5,-3.5,13.5,-8.5,-5.5)
1.5^2
2.5^2
(-3.5)^2
13.5^2
8.5^2
(5.5^2)
2.58*sqrt(305.5/5)/sqrt(6)
sqrt(6)

x_xbar<-c(13,14,8,25,3,6)
# Calculate sample standard deviation
sample_sd <- sd(x_xbar)
# Calculate sample size
sample_size <- length(x_xbar)
# Calculate standard error
SE <- sample_sd / sqrt(sample_size)
# Set confidence level (e.g., 95%)
alpha <- 0.01
# Find critical value (assuming normal distribution)
critical_value <- qnorm(1 - alpha/2)
# Calculate margin of error
margin_of_error <- critical_value * SE
print(margin_of_error)

# Generate a vector of 100 values between -6 and 6
x <- seq(-6, 6, length = 100)
# Degrees of freedom
df = c(1,4,10,1000)
colour = c("yellow", "orange", "green", "red","black")
# Plot a normal distribution
plot(x, dnorm(x), type = "l", lty = 2, xlab = "t-value", ylab =
       "Density",
     main = "Comparison of t-distributions", col = "black")
# Add the t-distributions to the plot
for (i in 1:4){
  lines(x, dt(x, df[i]), col = colour[i])
}
# Add a legend
legend("topright", c("df = 1", "df = 4", "df = 10", "df = 1000", "normal"), col = colour, title = "t-distributions", lty = c(1,1,1,1,2))

