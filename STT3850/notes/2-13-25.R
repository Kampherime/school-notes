#! /usr/bin/R
set.seed(25)
times <- rexp(1000,1/30)

head(times)
mean(times)

times <- rexp(1000,1/15)
head(times)


times <- rexp(1000,1/6)
head(times)

waiting_time <- rexp(1000,1/30)

# If you get an exponential distribution, plotting it gives an exponential graph.
# If you plot the means, you get an approximately normal graph (Central Limit Theorem)
# x ~ N(1/l, (1/l)/n) -> n is the sample size, l -> lambda

rate_parameter <- 1/20

sample_size <- 30
sample_count <- 1000

sample_means <- rep(NA, sample_count)

# Generate samples and calculate means

set.seed(25)

for (i in 1:sample_count) {
	sample <- rexp(50,rate_parameter) # Generate an exponential sample
	sample_means[i] <- mean(sample)# Calculate sample mean
}

hist(sample_means, breaks = 20, main = "Distribution of Sample Means", xlab = "Sample Mean")
