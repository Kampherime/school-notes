# y = -4.10 + 10.09x1 + 0.09x2 + e
# e = N(0,3), x1=N(2,1), x2=N(0,4)
set.seed(100)

trials<-100
x1<-rnorm(trials,2,1)
x2<-rnorm(trials,0,2)
e<-rnorm(trials,0,sqrt(3))

y<--4.10+10.09*x1+0.09*x2+e
summary(y)
