set.seed(53)
n <- 100
N<-200
p <- 0.5

sample <- rbinom(1, n, p) # x ~ N(np, npq)

hist(sample, breaks = 20, main = "Distribution of samples", xlab = "Number of successes")

# Central limit theorem. Let x be number of successes. As x -> inf
# x ~ B(n, p)
# x ~ N(np, npq) (the success plot of a binomial looks more and more nomal as x -> inf)

n <- 10
p <- 0.5
num_samples <- 1000
sample_means <- rep(NA, num_samples)
for (i in 1:num_samples) {
	sample <- rbinom(n, size = n, prob = p) # Generate a binomial
	sample
	sample_means[i] <- mean(sample) # Calculate sample mean
}
# Plot the distribution of sample means
hist(sample_means, breaks = 20, main = "Distribution of Sample
Means", xlab = "Sample Mean"
