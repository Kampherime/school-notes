

GettysburgData <- read.table("~/Downloads/GettysburgData.txt",header=TRUE,sep="\t",fill = TRUE)
head(GettysburgData, 10)

nrow(GettysburgData)

set.seed(25)
sampled_Wordlist <- GettysburgData [sample(nrow(GettysburgData),size =25 , replace = FALSE), ]
head(sampled_Wordlist)
count<-table(sampled_Wordlist$ThreeOrLessLetters)
count[2]/nrow(sampled_Wordlist)
