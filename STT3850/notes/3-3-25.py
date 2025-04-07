from scipy import stats
import numpy as np
# Sample data for two groups
women_weight = np.array([38.9, 61.2, 73.3, 21.8, 63.4, 64.6,
48.4, 48.8, 48.5])
men_weight = np.array([67.8, 60, 63.4, 76, 89.4, 73.3, 67.3,
61.3, 62.4])
# Perform the two-sample t-test
t_statistic, p_value = stats.ttest_ind(women_weight, men_weight)
print("T-statistic:", t_statistic)
print("P-value:", p_value)
