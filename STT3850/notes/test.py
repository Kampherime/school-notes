def main():
    arr1 = [1,2,3,4,5,6,7,8,9]
    arr2 = [2,4,6,8,10,12,14,16,18]
    silly_array = sorted([*arr1, *arr2])
    print(silly_array)
    print(len(silly_array))
    print((silly_array[8] + silly_array[9])/2)
    med1 = arr1[4]
    med2 = arr2[4]




    # this problem seems dubiously possible 
    # i mean i know it is but it seems a little impossible 

""" i think like
find median of both lists
those are bounds for the true median
remove everything outside of those bounds and repeat until you only have 1-2 numbers left
i think that's o(log(m+n)^2) though 
"""
    
    

main()
