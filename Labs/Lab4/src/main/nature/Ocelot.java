package nature;

public class Ocelot extends Feline
{
    public Ocelot(String name)
    {
        super(name);
    }

    public void eat()
    {
        System.out.println("pick ...");
        setHungerLevel(this.hungerLevel - 3);
    }
}
