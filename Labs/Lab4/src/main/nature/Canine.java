package nature;

public abstract class Canine extends Animal
{
    public Canine(String name)
    {
        super(name);
    }
   
    @Override
    public void roam()
    {
        System.out.println("like canines roam in packs ...");
        setHungerLevel(this.hungerLevel + 1);
    }
}
