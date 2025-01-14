package nature;

public class Wolf extends Canine
{
    public Wolf(String name)
    {
        super(name);
    }
    
    public void makeNoise()
    {
        System.out.println("growl ...");
    }

    public void eat()
    {
        System.out.println("rip with teeth ...");
        setHungerLevel(this.hungerLevel - 2);
    }
}
