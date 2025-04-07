import pandas as pd
GettysburgData = pd.read_excel(r"/home/katherine/Downloads/GettysburgData.xlsx")
print(GettysburgData[:6])

sample_word = GettysburgData ['Word'].sample(n=20)
print(sample_word)
