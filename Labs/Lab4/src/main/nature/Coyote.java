package nature;

public class Coyote extends Canine
{
    public Coyote(String name)
    {
        super(name);
    }

    public void eat()
    {
        System.out.println("gnaws ...");
        setHungerLevel(this.hungerLevel - 2);
    }
    
    @Override
    public void makeNoise()
    {
        System.out.println("howl ...");
    }
}
