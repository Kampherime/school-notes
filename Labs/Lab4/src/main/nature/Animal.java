package nature;

public abstract class Animal 
{
    protected String name;
    protected int hungerLevel;
    
    public Animal(String name) 
    {
        this.name = name;
    }

    public int getHungerLevel()
    {
        return this.hungerLevel;
    }
    
    public String getName()
    {
        return this.name;
    }

    public void setHungerLevel(int hungerLevel) 
    {
        if (hungerLevel > 10) 
        {
            this.hungerLevel = 10;
        }
        else if (hungerLevel < 0) 
        {
            this.hungerLevel = 0;  
        }
        else 
        {
            this.hungerLevel = hungerLevel;
        }
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public void sleep() 
    {
        System.out.println("sleeping ...");
        this.hungerLevel = 10;
    }

    public void roam()
    {
        System.out.println("moving around ...");
        // may not work
        setHungerLevel(this.hungerLevel + 1);
    }

    public abstract void eat();

    public abstract void makeNoise();
}
