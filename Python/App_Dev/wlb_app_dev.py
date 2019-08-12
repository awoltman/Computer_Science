f=0
s=0
good=0
total =0

def select():
    print('F for Fail: ' + f)
    print('S for Software Fail: ' + s)
    print('G for Good: ' + good)
    print('D for Done')
    g = input('Enter what you would like to do:')

    if(g == 'F' or g == 'f'):
        f+=1
        total+=1
        select()
    elif(g == 'S' or g == 's'):
        s+=1
        total+=1
        select()
    elif(g == 'G' or g == 'g'):
        good+=1
        total+=1
        select()
    elif(g == 'D' or g == 'd'):
        file1 = open("results.txt","a")
        file1.writelines("Total Failed: "+f,"Total Software Failed: "+f,"Total Good: "+f, "Total Samples"+ total)
        file1.close()

select()