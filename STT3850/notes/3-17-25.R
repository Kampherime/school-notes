Contintable=matrix(c(50,125,90,45,75,175,30,10),ncol=2)
colnames(Contintable)=c("Snacks","No Snacks")
rownames(Contintable)=c("Action","Comedy","Family",
                        "Horror")
Contintable
# install.packages("gplots")
library("gplots")
#convert the data as a table
dt <- as.table(as.matrix(Contintable))
#Graph
balloonplot(t(dt), main ="Purchase", xlab ="", ylab="", label = FALSE, show.margins = FALSE)

chisq<-chisq.test(Contintable)
chisq

chisq$expected

women_weight <- c(38.9, 61.2, 73.3, 21.8, 63.4, 64.6, 48.4,
                  48.8, 48.5)
men_weight <- c(67.8, 60, 63.4, 76, 89.4, 73.3, 67.3, 61.3,
                62.4)
# Create a data frame
my_data <- data.frame(women_weight,men_weight)
# Import library for bootstrap methods
library(boot)
# Import library for plotting
library(ggplot2)
diff.fun <- function(my_data, idx)
{
  df <- my_data[idx, ]
  # Find the mean difference for the weights
  # for men and women
  c(mean(df[, 1])- mean(df[, 2]))
}
# Setting the seed for
# reproducability of results
set.seed(25)
# Calling the boot function with the dataset
# our function and no. of rounds
bootstrap <- boot(my_data, diff.fun, R = 1000)
# Display the result of boot function
bootstrap
# Plot the bootstrap sampling
# distribution using ggplot
plot(bootstrap)
# Function to find the
# bootstrap Confidence Intervals
boot.ci(boot.out = bootstrap,
        type = c("norm", "basic",
                 "perc", "bca"))