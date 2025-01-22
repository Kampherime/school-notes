from math import sqrt

import numpy as np

np.random.seed(100)

x1 = np.random.normal(2, 1, 100)
x2 = np.random.normal(0, 2, 100)
e = np.random.normal(0, sqrt(3), 100) # error statistic

y = -4.10 + 10.09*x1 + 0.09*x2 + e

#min, percentile, median, mean, percentile, max stats
