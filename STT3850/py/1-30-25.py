import numpy as np
np.random.seed(25)
# Set the rate parameter (lambda) of the Poisson process
lambda_rate = 0.61
# Set the number of events to generate
num_events = 100
# Generate random numbers from a Poisson distribution
horse_kick_death = np.random.poisson(lambda_rate, num_events)
# Print the events
print(horse_kick_death)

np.mean(horse_kick_death)

print(np.round(np.var(horse_kick_death),decimals=2))

from scipy.stats import poisson
num_deaths =range(0,10)
for x in num_deaths:
    #Calculate the PMF for x, given lambda = 2
    pmf = poisson.pmf(x, mu=0.61)
    pmf = f'{pmf:.15f}'
    print(pmf)


# Create the line plot
import numpy as np
import matplotlib.pyplot as plt
from scipy.stats import poisson
# Set the parameters of the Poisson distribution
mu = 0.61
# Generate x values
x = np.arange(0, 10)
# Calculate the PMF
pmf = poisson.pmf(x, mu)
print(pmf)
# Plot the PMF
plt.plot(x, pmf)
plt.xlabel('Number of Deaths')
plt.ylabel('Probability')
plt.title('Poisson PMF (mu = {})'.format(mu))
plt.show()

#less than or equal 5 deaths
from scipy.stats import poisson
# Define the mean (lambda) of the Poisson distribution
mu = 0.61
# Calculate the CDF for a given value of x
x = 5
cdf = poisson.cdf(x, mu)
print(cdf)
#more than 5 deaths
More_than_5 = 1-cdf
More_than_5 =f'{More_than_5:.15f}'
print(More_than_5)

from scipy.stats import poisson
num_deaths =range(0,11)
for x in num_deaths:
    #Calculate the PMF for x, given lambda = 2
    cdf = poisson.cdf(x, mu=0.61)
    cdf = f'{cdf:.15f}'
    print(cdf)

