# We begin by moving backwards
# Time series analysis:
#   A statistical technique used for analyzing data over a period of time to identify trends. The relevant code is below. 

births <- scan("http://robjhyndman.com/tsdldata/data/nybirths.dat")
birthstimeseries <- ts(births, frequency=12, start=c(1946,1))
birthstimeseries

#Plotting the timeseries
plot.ts(birthstimeseries)

#The kings time series
kings <- scan("http://robjhyndman.com/tsdldata/misc/kings.dat",skip=3)
kingstimeseries <- ts(kings)
plot.ts(kingstimeseries)

#Smoothing the kings data, it is non-seasonal and the fluctuation are roughly the same size hence could be described by a additive model

#Smoothing using a moving average of 3
install.packages("TTR")
library("TTR")
kingstimeseriesSMA3 <- SMA(kingstimeseries,n=3)
plot.ts(kingstimeseriesSMA3)

#Smoothing order 8
kingstimeseriesSMA8 <- SMA(kingstimeseries,n=8)
plot.ts(kingstimeseriesSMA8)

#To estimate the trend, seasonal and irregular components of this time series, we type:
birthstimeseriescomponents <- decompose(birthstimeseries)

#Outputing the individual components
birthstimeseriescomponents$seasonal
birthstimeseriescomponents$trend
birthstimeseriescomponents$random

#Plotting the components
plot(birthstimeseriescomponents)

#Seasonal adjustment
birthstimeseriescomponents <- decompose(birthstimeseries)
birthstimeseriesseasonallyadjusted <- birthstimeseries - birthstimeseriescomponents$seasonal

#Ploting the adjusted time series
plot(birthstimeseriesseasonallyadjusted)

#Rainfall data
rain <- scan("http://robjhyndman.com/tsdldata/hurst/precip1.dat",skip=1)
#Read 100 items
rainseries <- ts(rain,start=c(1813))
rainseries
#plot
plot.ts(rainseries)

#Simple Exponential Smoothing
rainseriesforecasts <- HoltWinters(rainseries, beta=FALSE, gamma=FALSE)
rainseriesforecasts

#The forcasted time series
rainseriesforecasts$fitted

#Plot
plot(rainseriesforecasts)

#Sum of square error to estimate accuracy of the forecast. 
rainseriesforecasts$SSE

#Simple Exponential Smoothing using the initial value of the time series
HoltWinters(rainseries, beta=FALSE, gamma=FALSE, l.start=23.56)

#Forcasting for time periods outside of the time series
install.packages("forecast")
library("forecast")

rainseriesforecasts2 <- forecast(rainseriesforecasts, h=8)
rainseriesforecasts2

#Plotting prediction for the forecast
plot(rainseriesforecasts2)

#Correlogram to test for auto-correlation
acf(rainseriesforecasts2$residuals, na.action = na.pass, lag.max=20)

#Box test to test for auto-correlation
Box.test(rainseriesforecasts2$residuals, lag=20, type="Ljung-Box")

# Example analyses
#Three principal components have been generated which correspond to the number of variables
#in the data set. Each component explains a proportion of the total variance in the data set. The
#first component explains 38.4% of the variance in the data set and the second component
#explains 32.7% of the variance. This means the first two components explain 71% of the variance
#and can accurately represent the data.
# ----------- holt winters ----------------
#Alpha is 0.024 which is close to 0, the forecast is based on recent and less recent observations. It
#appears that it is based more on recent observations. The closer it is to 0 the less it is based on
#recent observations.
# ----------- box ljung ------------------
#The p-value is greater than alpha equal 0.05 therefore fail to reject the null hypothesis at this level
#of significance and conclude that the simple exponential smoothing forecast cannot be improved
#by another forecasting technique.

#------------------------------------------------------------------------------------------------------------------------------------------------------ 

#Principal compoment analysis
#   A statistical method that involves extracting the maximum possible variance into different components and acting recursively. 
#   Relevant code is below. 

# Load libraries and data (replace with your data)
library(stats)
library(MASS)
# Example data
set.seed(123)
my_data <- data.frame(x1 = rnorm(100), x2 = rnorm(100), x3 = rnorm(100), outcome = rnorm(100))

# 1. PCA
pca_result <- prcomp(my_data[, 1:3], scale = TRUE, center = TRUE) # Don't include outcome in PCA

# 2. Analyze PCA results
summary(pca_result)

#Display the loading with respect to the independent varialbes
pca_result


# 3. Select components (e.g., first two)
pca_data <- data.frame(pca_result$x)
selected_components <- pca_data[, 1:2]
head(selected_components)

#Scree plot
install.packages("factoextra")
library(factoextra)
fviz_eig(pca_result, addlabels = TRUE)

#Biplot to display the relationship between the PC and independent variables. 
fviz_pca_var(pca_result, col.var = "black")

# 4. Prepare data for MLR
regression_data <- data.frame(my_data$outcome, selected_components) # Combine outcome and PCs

# 5. Perform MLR
regression_model <- lm(my_data$outcome ~ PC1 + PC2, data = regression_data)
summary(regression_model)

#Assignment of for PCA
data("iris")
str(iris)
head(iris)

#Finding the PCA
pc <- prcomp(iris[,-5],
             center = TRUE,
            scale. = TRUE)
summary(pc)
pc

#Scree plot
fviz_eig(pc, addlabels = TRUE)

#Biplot
fviz_pca_var(pc, col.var = "black")

#------------------------------------------------------------------------------------------------------------------------------------------------------
# ANOVA
#   ANOVA is a statistical test that is used to compare the means of 2+ groups by analyzing variance. 
#   There exist both one and two way ANOVA. One way is used for one independent variable, and two way is used for two :)
#   Interpreting typically involves looking at the P and F values. Low P value means that the variable has a high effect on the dependent variable. 
#   Relevant code is below 

options(scipen = 999)
#Obtaining Data
CropData <-read.table("cropData.txt",header =TRUE,sep="\t", fill = TRUE)
head(CropData, 10)

boxplot(CropData$yield ~ CropData$fertilizer)

#Fitting the oneway model
one.way <- aov(yield ~ factor(fertilizer), data = CropData)
summary(one.way)

#Table of fertilizer data
table(CropData$fertilizer)

#Tukey HSD test to see which groups as statistically significantly different. 
TukeyHSD(one.way, conf.level=.95)

#With blocking
one.wayBlocking <- aov(yield ~ block + factor(fertilizer), data = CropData)
summary(one.wayBlocking)

# Two way now

# Perform the two-way ANOVA
fit <- aov(yield ~ factor(fertilizer)*factor(density), data = CropData)

# Summarize the ANOVA results
summary(fit)

fit1 <- aov(yield ~ factor(fertilizer) + factor(density), data = CropData)

# Summarize the ANOVA results
summary(fit1)

# Post-hoc test (Tukey's HSD)

  TukeyHSD(fit1, conf.level=.95)

#------------------------------------------------------------------------------------------------------------------------------------------------------
# Mann-Whitney U
# A test used to compare two samples or groups. It asks if the two samples are likely to derive from the same population.
# Assumptions: Continuous, not-normal (use a unpaired student's t test otherwise), similar in shape, independent samples, and sufficient sample size (5+ observations per group)
# Null hyp: the two pops are equal. Alt: they are not :3

#Mann-Whitney U Test
x<-c(540,670,1000,960,1200,4650,4200)
y<-c(5000,4200,1300,900,7400,4500,7500)
wilcox.test(x, y, alternative = "two.sided", exact = TRUE)

# Kruskal-Wallis
# Used to compare 3+ groups of sample data with no assumptions about the underlying dataset.
# mfw code
#Installing the packages
#install.packages("ggpubr")
library("ggpubr")
library(openxlsx)

#Importing data
PlantGrowth<-PlantGrowth

write.xlsx(PlantGrowth, 'C:/Users/fordeia/DataAnalysisI/PlantGrowth.xlsx')
head(PlantGrowth)

#Displaying group levels
levels(PlantGrowth$group)

#Reording levels
PlantGrowth$group <- ordered(PlantGrowth$group,levels = c("ctrl", "trt1", "trt2"))

#Loading the dplyr 
library(dplyr)

#Computing the summary statistics
group_by(PlantGrowth, group) %>%
  summarise(
    count = n(),
    mean = mean(weight, na.rm = TRUE),
    sd = sd(weight, na.rm = TRUE),
    median = median(weight, na.rm = TRUE),
    IQR = IQR(weight, na.rm = TRUE)
  )

#Visualizing the data
#Boxplots
ggboxplot(PlantGrowth, x = "group", y = "weight",
          color = "group", palette = c("#00AFBB", "#E7B800", "#FC4E07"),
          order = c("ctrl", "trt1", "trt2"),
          ylab = "Weight", xlab = "Treatment")

#Add error bars
ggline(PlantGrowth, x = "group", y = "weight",
       add = c("mean_se", "jitter"),
       order = c("ctrl", "trt1", "trt2"),
       ylab = "Weight", xlab = "Treatment")

#Kruskal-Wallis Test to compare means
kruskal.test(weight ~ group, data = PlantGrowth)

#Pairwise comparison
pairwise.wilcox.test(PlantGrowth$weight, PlantGrowth$group,
                 p.adjust.method = "BH")

# OK I JUST FOUND THIS ITS LITERALLY CALLED FINAL EXAM . R OK HERE U GO
#Question 1 ==============================
#Q-Q Plot
# read in the data
x <- c(data1,data2, ...)
# make the qqplot
qqnorm(x)
qqline(x)

#One sample t-test
t.test(x, mu = 3, alternative = "greater")

#Question 2 ==============================
#Contingency table
Contintable=matrix(c(data1, data2, ...),ncol=3) 
 colnames(Contintable)=c("favor","indifferent","opposed") 
 rownames(Contintable)=c("Party A","Party B")
 Contintable

# Balloon plot
library("gplots") 
#convert the data as a table 
dt <- as.table(as.matrix(Contintable)) 
#Graph 
balloonplot(t(dt), main ="Purchase", xlab ="", ylab="", label = FALSE, show.margins = FALSE) 

#Chi-squared test for independence
chisq<-chisq.test(Contintable) 
chisq

#Obtaining the expected value from a Chi-squared test of independence
chisq$expected

#Question 3 ==============================
#Down loading the mtcars dataset
data("mtcars")
head(mtcars)

#The principal component analysis
library(stats)
pca_result <- prcomp(mtcars[, -1], scale = TRUE, center = TRUE) # Don't include outcome in PCA
summary(pca_result)

#Display the loading with respect to the independent varialbes
pca_result

#Scree plot
install.packages("factoextra")
library(factoextra)
fviz_eig(pca_result, addlabels = TRUE)

#Biplot to display the relationship between the PC and independent variables. 
fviz_pca_var(pca_result, col.var = "black")

#Extracting components that explains 95% of the variability
explained_variance <- pca_result$sdev^2 / sum(pca_result$sdev^2)
cumulative_variance <- cumsum(explained_variance)
n_components <- which(cumulative_variance >= 0.95)[1] # Keep until 95% explained variance
X_pca <- as.data.frame(pca_result$x[, 1:n_components])
head(X_pca)

# Prepare data for MLR
regression_data <- data.frame(mtcars$mpg, X_pca) # Combine outcome and PCs

# Perform MLR with PC
regression_model <- lm(mtcars$mpg ~PC1 + PC2 + PC3 + PC4 + PC5 + PC6, data = regression_data)
summary(regression_model)

#Question 4 ===========================================
#Rainfall data
rain <- scan("http://robjhyndman.com/tsdldata/hurst/precip1.dat",skip=1)
#Read 100 items
rainseries <- ts(rain,start=c(1813))
rainseries

#plot
plot.ts(rainseries)

#Simple Exponential Smoothing
rainseriesforecasts <- HoltWinters(rainseries, beta=FALSE, gamma=FALSE)
rainseriesforecasts

#The forcasted time series for simple exponential smoothing
head(rainseriesforecasts$fitted)

#Plot for the simple exponential smoothing
plot(rainseriesforecasts)

#Sum of square error to estimate accuracy of the forecast. 
rainseriesforecasts$SSE

#Forcasting for time periods outside of the time series
install.packages("forecast")
library("forecast")

rainseriesforecasts2 <- forecast(rainseriesforecasts, h=8)
rainseriesforecasts2

#Plotting prediction for the forecast
plot(rainseriesforecasts2)

#Correlogram to test for auto-correlation
acf(rainseriesforecasts2$residuals, na.action = na.pass, lag.max=20)

#Box test to test for auto-correlation
Box.test(rainseriesforecasts2$residuals, lag=20, type="Ljung-Box")


#------------------------------------------------------------------------------------------------------------------------------------------------------

# Now we're going over the relevant data
# A one sample t-test is used to compare a known mean to a hypothetical mean. Assumed that the dataset is normal
# Banger analysis 
#The p-values is greater than alpha equal 0.05 so fail to reject the null hypothesis and conclude
#that there is no evidence that the mean number of memes known by the professor is greater
#than 3.

# F test for equal variances
# Shapiro-Wilk test for normality

# Chi squared test for independence: Determines if two categorical variables are related
# Ho states that there is no relationship or association between the two variables being tested
# Assumptions: expected values greater than 5 and the variables are categorical 

#Coders 
#Recreating the contingency table in R:

Contintable=matrix(c(50,125,90,45,75,175,30,10),ncol=2) 
colnames(Contintable)=c("Snacks","No Snacks") 
rownames(Contintable)=c("Action","Comedy","Family", "Horror")
print(Contintable)

#Visualizing the data with a balloonplot
install.packages("gplots")
library("gplots") 
#convert the data as a table 
dt <- as.table(as.matrix(Contintable)) 
#Graph 
balloonplot(t(dt), main ="Purchase", xlab ="", ylab="", label = FALSE, show.margins = FALSE) 

#Chi-square test
chisq<-chisq.test(Contintable) 
chisq

#Expected values 
chisq$expected


