import statistics
def calculate_margin_of_error(sample):
    sample_std = statistics.stdev(sample) # Calculate sample standard deviation
    sample_size = len(sample)
    z_score = 2.05
    margin_of_error = z_score * (sample_std / (sample_size **0.5))
    return margin_of_error
# Example usage:
sample_data = [10, 12, 8, 15, 9]
margin = calculate_margin_of_error(sample_data)
print("Margin of Error:", margin)

