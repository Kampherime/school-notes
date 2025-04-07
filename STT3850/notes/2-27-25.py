import numpy as np
import matplotlib.pyplot as plt
from scipy.stats import chi2
# Define the x values for the plot
x = np.linspace(0, 20, 500)
# Define the degrees of freedom to plot
degrees_of_freedom = [1, 3, 5, 7]
# Create the plot
plt.figure(figsize=(10, 6))
# Plot each chi-square density curve
for df in degrees_of_freedom:
    plt.plot(x, chi2.pdf(x, df), label=f'df = {df}')
# Add labels and title
plt.xlabel('x')
plt.ylabel('Density')
plt.title('Chi-Square Density Curves')
# Add legend
plt.legend()
# Show the plot
plt.grid(True)
plt.show()
