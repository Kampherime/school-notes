cat("hell0 :)")


visitors <- rpois(100, 15)


mean(visitors)
var(visitors)

dpois(0:10, 15)


y <- dpois(0:30, 15)
x <- 0:30

plot(x,y,type= "o",main= "PMF Poisson", xlab= "Number of Events",
     ylab= "Probability")

ppois(20, 15)
ppois(20, 15, lower=FALSE)


Temperature_Fah<-
  c(57.6,61.5,53.4,59.4,65.3,71.8,66.9,77.2,74.1,64.6,72.7,63.0)
Ice_Cream_Sales_Dollars<-
  c(215,325,185,332,406,522,412,614,544,421,445,408)
TempSale<-data.frame(Temperature_Fah,Ice_Cream_Sales_Dollars)
TempSale

hist(Temperature_Fah, main = "Plot of temperatures", xlab = "Temperatures in F")
hist(Ice_Cream_Sales_Dollars, main = "Plot of ice cream sales", xlab = "Gross count of sales")

plot(x = Temperature_Fah, y = Ice_Cream_Sales_Dollars, main = "Scatterplot of Ice Cream Sales vs Temperatures in F", 
     xlab = "Temperatures in F", ylab = "Gross ice cream sales")


