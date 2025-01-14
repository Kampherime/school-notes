package storage;

public class DoubleArraySeq implements Cloneable 
{
    public final static int DEFAULT_CAPACITY = 10;
    private double[] data; 
    private int manyItems;
    private int currentIndex;

    public DoubleArraySeq(int initialCapacity) 
    {
        this.data = new double[initialCapacity];
        this.manyItems = 0;
        this.currentIndex = 0;
    }
    
    public DoubleArraySeq() 
    {
        this(DEFAULT_CAPACITY);
    }

    public int size()
    {
        return this.manyItems;
    }

    public int getCapacity() 
    {
        return this.data.length;
    }

    public String toString()
    {
        if (manyItems == 0) {
            return "<>";
        }
        String return_string = "<";
        for (int i = 0; i < manyItems - 1; i++) {
            if (currentIndex == i) {
                return_string += String.format("[%.1f], ", data[i]); 
            }
            else{
                return_string += String.format("%.1f, ", data[i]);
            }
        }
        if (currentIndex == manyItems - 1) {
            return_string += String.format("[%.1f]>", data[manyItems - 1]);
        }
        else {
            return_string += String.format("%.1f>", data[manyItems - 1]);
        }
        return return_string;
    }

    public boolean isCurrent() 
    {
        if (currentIndex == manyItems)
        {
            return false;
        }
        return true;
    }

    public double getCurrent()
    {
        if (currentIndex == manyItems)
        {
            throw new IllegalStateException("No current index.");
        }
        else 
        {
            double return_value = data[currentIndex];    
            return return_value;
        }
    }

    public void advance() 
    {
        if (currentIndex == manyItems)
        {
            throw new IllegalStateException("No current index here.");
        }
        else if (currentIndex == data.length - 1)
        {
            currentIndex = manyItems;
        }
        else 
        {
            currentIndex++;
        }
    }

    public void start() 
    {
        currentIndex = 0;
    }

    public void removeCurrent() 
    {
        if (currentIndex == manyItems)
        {
            throw new IllegalStateException("No current element");
        }
        for (int i = currentIndex; i < data.length - 1; i++)
        {
            data[i] = data[i+1];
        }
        data[data.length - 1] = 0;
        manyItems--;

    }
    
    public void ensureCapacity(int minimumCapacity) 
    {
        if (data.length > minimumCapacity) 
        {
            return;
        }
        double[] newData = new double[minimumCapacity];
        for (int i = 0; i < manyItems; i++)
        {
            newData[i] = data[i];                
        }
        data = newData; //garbage collector ftw
    }

    public void addAfter(double element) 
    {
        ensureCapacity(manyItems + 1);
        if (currentIndex == manyItems) 
        {
            data[manyItems] = element;
            manyItems++;
            
        }
        else 
        {
            for (int i = manyItems; i > currentIndex; i--)
            {
                if (manyItems - 1 != i) {
                    data[i] = data[i-1];
                }
                else {
                    data[manyItems+1] = data[i];
                    data[i] = data[i-1];
                }
            }
            manyItems++;
            currentIndex++; 
            data[currentIndex] = element;
        }
    }
    public void addBefore(double element) 
    {
        ensureCapacity(manyItems + 2);
        if (manyItems == currentIndex) {
            for (int i = manyItems - 1; i > 0; i--) {
                data[i] = data[i-1];
            }
            data[0] = element;
            currentIndex = 0;
        }
        else {    
            for (int i = manyItems; i > currentIndex; i--)
            {
                if (manyItems - 1 != i) {
                    data[i] = data[i-1];
                }
                else {
                    data[manyItems+1] = data[i];
                    data[i] = data[i-1];
                }
            }
            data[currentIndex] = element;

        }
        manyItems++;
    }
    public void addAll(DoubleArraySeq addend) 
    {
        ensureCapacity(addend.manyItems + manyItems + 1);
        for (int i = 0; i < addend.manyItems; i++) 
        {
            data[manyItems] = addend.data[i];
            manyItems++;
        }
    }
    public void trimToSize() 
    {
        double[] newData = new double[manyItems];
        for (int i = 0; i < manyItems; i++) 
        {
            newData[i] = data[i];
        }
    }
    
    public boolean equals(Object other) 
    {
        if (!(other instanceof DoubleArraySeq)) {return false;}
        DoubleArraySeq seq = (DoubleArraySeq) other;
        if (seq.manyItems != this.manyItems) {return false;}
        if (this.currentIndex != seq.currentIndex) {return false;}
        for (int i = 0; i < manyItems; i++) 
        {
            if (data[i] != seq.data[i])
            {
                return false;
            }
        }
        return true;
    }
    
    public DoubleArraySeq clone() 
    {
        DoubleArraySeq returnSeq = new DoubleArraySeq();
        returnSeq.currentIndex = currentIndex;
        returnSeq.data = data.clone();
        returnSeq.manyItems = manyItems;
        return returnSeq;
    }

    public static DoubleArraySeq concatenation(DoubleArraySeq s1, DoubleArraySeq s2) 
    {
        DoubleArraySeq returnSeq = new DoubleArraySeq();
        returnSeq.manyItems = s1.manyItems + s2.manyItems;
        returnSeq.currentIndex = returnSeq.manyItems;
        returnSeq.data = new double[returnSeq.manyItems];
        returnSeq.addAll(s1);
        returnSeq.addAll(s2);
        return returnSeq;
    }
}
