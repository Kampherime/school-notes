#Obtaining Data
CropData <-read.table("cropData.txt",header =TRUE,sep="\t", fill = TRUE)
head(CropData, 10)

#Fitting the oneway model
one.way <- aov(yield ~ fertilizer, data = CropData)
summary(one.way)

#Table of fertilizer data
table(CropData$fertilizer)

vec <- c(28, 29, 35, 37, 32, 26, 37, 39, 22, 29, 36, 38)
shapiro.test(vec)

qqnorm(vec)
qqline(vec)

t.test(vec, mu = 28, alternative = "two.sided")

#Obtaining Data
CropData <-read.table("cropData.txt",header =TRUE,sep="\t", fill = TRUE)
head(CropData, 10)

#Fitting the oneway model
one.way <- aov(yield ~ factor(fertilizer), data = CropData)
summary(one.way)

#Table of fertilizer data
table(CropData$fertilizer)

#Tukey HSD test to see which groups as statistically significantly different. 
TukeyHSD(one.way, conf.level=.95)
