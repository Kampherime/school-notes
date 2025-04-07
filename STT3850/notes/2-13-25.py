import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
np.random.seed(42)
# Generate random samples from exponential distribution
scale = 20 # Scale parameter (mean = 1/scale)
size = 1000000 # Number of samples
population = np.random.exponential(scale, size)
# Set the number of samples and sample size
num_samples = 100
sample_size = 50
# Generate sample means
sample_means = []
for _ in range(num_samples):
    sample = np.random.choice(population, sample_size,
    replace=False)
    sample_means.append(np.mean(sample))
# Plot the distribution of the population and the sample means
fig, axes = plt.subplots(1, 1, figsize=(8, 4))
sns.histplot(sample_means, ax=axes, kde=True)
axes.set_title('Distribution of Sample Means')
axes.set_xlabel('Sample Mean')
axes.set_ylabel('Frequency')
plt.show()
