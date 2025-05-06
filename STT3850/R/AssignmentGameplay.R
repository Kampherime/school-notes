#we're going to simulate two datasets, under a non-matched-pairs situation.
#the first dataset will be blood pressures in a group that did not take a drug.
#the second, third, and fourth datasets will be blood pressures after a drug is taken.
#it will be simulating a clinical trial to see if any of the drugs reduce blood pressure.
#we will be measuring systolic blood pressure only
library("ggpubr")
library("lmtest")
library("car")

control_group <- rnorm(100, 115, 10)

medicine_group_1 <- rnorm(100, 100, 15)

medicine_group_2 <- rnorm(100, 110, 20)

medicine_group_3 <- rnorm(100, 105, 17)

label_vector <- c(rep(0, 100), rep(1, 100), rep(2, 100), rep(3, 100))

final_vector <- c(control_group, medicine_group_1, medicine_group_2, medicine_group_3)

dataframe <- data.frame(medicine_type = label_vector, sys_bp = final_vector)

boxplot(dataframe$sys_bp ~ dataframe$medicine_type)


# We can do an ANOVA here because we have more than three groups.
class(medicine_group_1)

shapiro.test(control_group)

shapiro.test(medicine_group_1)
shapiro.test(medicine_group_2)
shapiro.test(medicine_group_3)

bptest(control_group)


head(dataframe)

anova_results <- aov(sys_bp ~ factor(medicine_type), data = dataframe)

summary(anova_results)

table(dataframe$medicine_type)

TukeyHSD(anova_results, conf.level=0.95)

kruskal.test(dataframe$medicine_type ~ dataframe$sys_bp)
In