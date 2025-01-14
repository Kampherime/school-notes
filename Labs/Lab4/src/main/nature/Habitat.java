package nature;

import java.util.ArrayList;

public class Habitat
{
    private String name;
    private double latitude;
    private double longitude;
    private ArrayList<Animal> animals;

    public Habitat(String name, double lat, double lon)
    {
        this.name = name;
        this.latitude = lat;
        this.longitude = lon;
        animals = new ArrayList<>();
    }

    public double getLongitude()
    {
        return this.longitude;
    }

    public double getLatitude()
    {
        return this.latitude;
    }

    public String getName()
    {
        return this.name;
    }
    public void setLongitude(double lon)
    {
        this.longitude = lon;
    }

    public void setLatitude(double lat)
    {
        this.latitude = lat;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getNumOfAnimals()
    {
        return animals.size();
    }

    public void addAnimal(Animal animal)
    {
        animals.add(animal);
    }

    public void testAnimals()
    {
        System.out.println(this.name);
        System.out.println(this.latitude);
        System.out.println(this.longitude);
        System.out.println(getNumOfAnimals());
        for (Animal animal : animals) 
        {
            animal.sleep();
            animal.makeNoise();
            animal.eat();
            animal.roam();
            if (animal instanceof Pet) 
            {
                Pet pet = (Pet) animal;
                pet.play();
                pet.beFriendly();
            }
        }
    }
}
