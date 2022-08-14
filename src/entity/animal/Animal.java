package entity.animal;

import configuration.YAMLData;
import entity.Entity;
import entity.EntityCreator;
import island.Region;

public class Animal extends Entity {

    public Region region;

    public Animal() {
    }

    public Animal(Region region) {
        this.region = region;
    }

    public void reproduce(Region region) {
        toReproduce(region);
    }

    public void chooseDirection(Region region) {
        toChooseDirection(region);
    }

    public void eat(Region region) {
        toEat(region);
    }


    private void toReproduce(Region region) {
//        If count of entities < max count of entities create new entity
        if (region.getCountEntityOnRegion(this.getClass()) < YAMLData.MAX_COUNT_ENTITY.get(this.getClass().getSimpleName())) {
            region.addEntity(EntityCreator.getNewEntity(this.getClass().getSimpleName()));
        }
        System.out.println("To reproduce");
    }

    private void toChooseDirection(Region region) {
        System.out.println("To choose direction");
    }

    private void toEat(Region region) {
        System.out.println(this.getClass().getSimpleName() + " to eat.");

    }
}
