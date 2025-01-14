package nature;

public class HouseCat extends Feline implements Pet
{
    public HouseCat(String name)
    {
        super(name);
    }

    public void eat()
    {
        System.out.println("crunch crunch ...");
        setHungerLevel(this.hungerLevel - 3);
    }

    public void play()
    {
        System.out.println("frolic ...");
    }

    public void beFriendly()
    {
        System.out.println("purr ...");
    }
}
