data = c(25.34, 22.12, 21.29, 19.95, 20.33, 16.26, 22.44, 24.75, 18.04, 24.12, 19.56, 35.79, 19.88, 17.46, 22.91)
shapiro.test(data)
qqnorm(data)
qqline(data)
t.test(data, mu = 20, alternative = "greater")
g1 = c(100, 100, 95, 90, 95, 98, 100, 100)
g2 = c(95, 78, 68, 95, 98, 79, 98, 86, 78, 89, 89, 94)

length(g1)
mean(g1)
sd(g1)

length(g2)
mean(g2)
sd(g2)

max_length <- max(length(g1), length(g2))

length(g1) <- max_length                      
length(g2) <- max_length

gender_data = cbind(g1, g2)

boxplot(gender_data, beside=T)

shapiro.test(g1)
shapiro.test(g2)

var.test(g1, g2)

t.test(g1, g2, equal=FALSE)

tree_data <- read.table("tree_data.txt", header=TRUE, sep="\t", fill=TRUE)

head(tree_data)

model <- lm(volume ~ height + girth, data = tree_data)
summary(model)

#Use a residual plot to test the linearity and homoskedasticity (equal variance) assumptions.
plot(model, which=1)

#Use a normal probability plot to test the normality assumption.
plot(model, which=2)

#Testing the normality assumption using a histogram
hist(residuals(model))

#Shapiro-Wilk test for normality
shapiro.test(residuals(model))

#Use the variance inflated factor to test for multicollinearity. 
library(usdm)
vif(model)

