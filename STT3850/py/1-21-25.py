import numpy as np
from scipy.stats import truncnorm
import matplotlib.pyplot as plt
from scipy import stats as st
import pandas as pd

np.random.seed(42)
# Define the parameters
lower_bound = 4
upper_bound = 17
mean = 9
std_dev = 3
# Calculate the a and b parameters for truncnorm
a = (lower_bound - mean) / std_dev
b = (upper_bound - mean) / std_dev
# Generate random samples
ages = np.round(truncnorm.rvs(a, b, loc=mean, scale=std_dev,
size=50))
print(ages)
print("Minimum:", np.round(np.min(ages),decimals=1))
print("1st Qu:", np.round(np.percentile(ages,25),decimals=1))
print("Median:", np.round(np.median(ages),decimals=1))
print("Mean:", np.round(np.mean(ages),decimals=1))
print("3rd Qu:", np.round(np.percentile(ages,75),decimals=1))
print("Maximum:", np.round(np.max(ages),decimals=1))
print(st.mode(ages))

# Create the boxplot
plt.boxplot(ages)
plt.title("Boxplot of Ages")
plt.xlabel("Group")
plt.ylabel("Age")
#plt.show()

data = pd.read_excel(r"/home/katie/Downloads/airqualityData.xlsx");
data = data["Temp"]

print(data[:6])

plt.hist(data, bins=9)
# Add labels and title
plt.xlabel('Temperature in degrees Fahrenheit')
plt.ylabel('Density')
plt.title('Maximum daily Temperature at La Guardia Airport')
# Show the plot
plt.show()
