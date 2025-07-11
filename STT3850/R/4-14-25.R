#install.packages("tidyverse")

library(tidyverse)
library(readxl)
library(forcats)
library(dplyr)


Data_to_clean<- read_excel("Data_Cleaning.xlsx")
Data_to_clean

# Summarizing the variables with count
Data_to_clean %>% count(Gender)
Data_to_clean %>% count(Age)
Data_to_clean %>% count(Status)

#Removing rows with NA
Data_to_clean %>%
  na.omit()

#Remove rows with NA in specific colums
Data_to_clean %>%
  filter(!is.na(Status))

#Removing rows with impossible age values
Data_to_clean %>%
  filter(Age < 900)

#Removing duplicates
Data_to_clean %>%
  distinct()

#Renaming levels
Data_to_clean$Gender <- fct_recode(Data_to_clean$Gender, "female" = "Female", "female" ="femail")

# View the result
print(Data_to_clean)

DataCleaned<-(Data_to_clean %>%
                filter(Age < 900))

DataCleaned

