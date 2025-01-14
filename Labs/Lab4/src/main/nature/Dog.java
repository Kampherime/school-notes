package nature;

public class Dog extends Canine implements Pet
{
    public Dog(String name)
    {
        super(name);
    }

    public void eat()
    {
        System.out.println("slop ...");
        setHungerLevel(this.hungerLevel - 3);
    }

    public void makeNoise()
    {
        System.out.println("bark ...");
    }

    public void play()
    {
        System.out.println("runs ...");
    }

    public void beFriendly()
    {
        System.out.println("nuzzles ...");
    }
}
