package entity;

import entity.animal.Animal;
import entity.plant.ParentPlant;
import island.Region;

import java.util.HashMap;

public class Entity {

    public void toReproduce(Region region) {
        HashMap<String, Animal> animalMap = new HashMap<>();
        for (Entity entity : region.getEntityList()) {
            if (entity instanceof Animal) {
                animalMap.put(entity.getClass().getSimpleName(), (Animal) entity);
            }
        }
        for (Animal animal : animalMap.values()) {
            animal.reproduce(region);
        }
    }

    public void toMove(Region region) {
        region.getEntityList().stream()
                .filter(entity -> entity instanceof Animal)
                .forEach(animal -> ((Animal) animal).move(region));
    }

    public void toEat(Region region) {
        region.getEntityList().stream()
                .filter(entity -> entity instanceof Animal)
                .forEach(animal -> ((Animal) animal).eat(region));
    }

    public void toFeelHungryOrDie(Region region) {
        region.getEntityList().stream()
                .filter(entity -> entity instanceof Animal)
                .forEach(animal -> ((Animal) animal).feelHungryOrDie(region));
    }

    public void toSpread(Region region) {
        region.getEntityList().stream()
                .filter(entity -> entity instanceof ParentPlant)
                .forEach(plant -> ((ParentPlant) plant).spread(region));
    }
}
