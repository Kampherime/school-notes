package nature;

public abstract class Feline extends Animal
{
    public Feline(String name)
    {
        super(name);
    }

    @Override
    public void roam() 
    {
        System.out.println("felines like to roam alone ...");
        setHungerLevel(this.hungerLevel + 1);
    }

    @Override
    public void sleep()
    {
        System.out.println("taking a cat nap ...");
        setHungerLevel(10);
    }

    public void makeNoise()
    {
        System.out.println("meow ...");
    }
}
