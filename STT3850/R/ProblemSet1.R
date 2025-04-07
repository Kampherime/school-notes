install.packages("collapsibleTree")
library(collapsibleTree)
install.packages("truncnorm")
library(truncnorm)
two_dice<-expand.grid(dice1=1:4, dice2=1:4)
two_dice<-data.frame(two_dice)
two_dice
collapsibleTree(two_dice, c("dice1","dice2"), tooltip = F, fill = "dice2",fillByLevel =TRUE, collapsed=FALSE)

# The probability of rolling two even dice is 4/16 = 0.25. This is because for each dice,
# there is a 1/2 chance of rolling an even die (or 2/4 options), so 2/4*2/4 = 4/16 = 0.25.


# 15% of students getting the flu means a 0.15 probability
flu_probabilities <- dbinom(x = c(0:5), size = 5, prob = 0.15)
data.frame(x = c(0:5),flu_probabilities)
plot(0:5, flu_probabilities,xlab="Number of Sicky students", type = "l")

# According to the output:
# 1 0      0.4437053125
# 2 1      0.3915046875
# 3 2      0.1381781250
# 4 3      0.0243843750
# 5 4      0.0021515625
# 6 5      0.0000759375
# The probability of all 5 students getting the flu is 0.0000759375.

placement_scores<-round(rtruncnorm(10000, a=45, b=95 , mean=65, sd=15))
boxplot(placement_scores, main="Boxplot of Placement scores", ylab="Placement scores")
boxplot.stats(placement_scores)$out
1-pnorm(75,65,15)

# The probability of any given student passing is 0.2524925.
# There are no outliers. (numeric(0)).