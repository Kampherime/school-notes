import numpy as np
from scipy.stats import truncnorm
import matplotlib.pyplot as plt

x1 = np.random.normal(3, 5, 250)
x2 = np.random.normal(2, 6, 250)
e = np.random.normal(0, 2, 250)

y = 3.25 + 1.34*x1 + 0.8*x2 + e
print(f"First 15 values: {y[:15]}")

print("Minimum:", np.round(np.min(y),decimals=4))
print("1st Qu:", np.round(np.percentile(y,25),decimals=4))
print("Median:", np.round(np.median(y),decimals=4))
print("Mean:", np.round(np.mean(y),decimals=4))
print("3rd Qu:", np.round(np.percentile(y,75),decimals=4))
print("Maximum:", np.round(np.max(y),decimals=4))

upper_bound = 49
lower_bound = 15
mean = 29
sd = 2.5
a = (lower_bound - mean) / sd
b = (upper_bound- mean) / sd

ages = np.round(truncnorm.rvs(a, b, loc=mean, scale=sd, size=1000000))

plt.boxplot(ages)

plt.title("Boxplot of ages")

plt.xlabel("Group")
plt.ylabel("Ages")

plt.show()
