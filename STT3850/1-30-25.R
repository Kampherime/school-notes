set.seed(25)

horse_kick_death = rpois(10000, 0.61)

dpois(0:10, 0.61)

mean = mean(horse_kick_death)
var = var(horse_kick_death)

mean
var


x<-0:10
y<- dpois(0:10,0.61)
plot(x,y,type= "o",main= "PMF Poisson", xlab= "Number of Events",
     ylab= "Probability")

ppois(5, 0.61)
ppois(5, 0.61, lower=FALSE)

x<-0:10
y<-ppois(0:10,0.61)
plot(x,y,type= "o",main= "CDF Poisson", xlab= "Number of Events",
     ylab= "Cumulative Probability")

abs <- rpois(30, 2)
abs
mean(abs)
var(abs)
dpois(0:10, 2)
x<-0:10
y<-dpois(0:10, 2)

plot(x,y, type="o",main="PMF Poisson", xlab="Number of absences", ylab="Probability")

y<-ppois(0:10, 2)

plot(x,y, type="o",main="CDF Poisson", xlab="Number of absences", ylab="Probability")

