#install.packages("truncnorm")

library(truncnorm)
ages <- round(rtruncnorm(50, 4, 17, 9, 3))
ages

summary(ages)

var(ages)
sd(ages)
install.packages("DescTools")
library(DescTools)
ages_mode <- Mode(ages)
ages_mode

head(airquality)
hist(airquality$Temp,
main="Maximum daily temperature at La Guardia Airport",
xlab="Temperature in degrees Fahrenheit",
xlim=c(50,100),
col="blue",
freq=FALSE
)
