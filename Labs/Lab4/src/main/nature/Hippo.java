package nature;

public class Hippo extends Animal
{
    public Hippo(String name)
    {
        super(name);
    }

    public void eat()
    {
        System.out.println("slurp ...");
        setHungerLevel(this.hungerLevel - 1);
    }

    public void makeNoise()
    {
        System.out.println("blub ...");
    }
}
