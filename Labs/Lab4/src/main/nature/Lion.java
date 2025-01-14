package nature;

public class Lion extends Feline
{
    public Lion(String name)
    {
        super(name);
    }

    public void makeNoise()
    {
        System.out.println("roar ...");
    }

    public void eat()
    {
        System.out.println("rip with teeth ...");
        setHungerLevel(this.hungerLevel - 2);
    }
}

