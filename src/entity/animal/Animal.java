package entity.animal;

import configuration.Characteristic;
import entity.Direction;
import entity.Entity;
import entity.EntityCreator;
import island.Island;
import island.Region;

import java.util.Random;

public class Animal extends Entity {

    private Region region;
    private Random random = new Random();

    public Animal() {
    }

    public Animal(Region region) {
        this.region = region;
    }

    public void reproduce(Region region) {
        int countEntityOnRegion = region.getCountEntityOnRegion(this.getClass());
        int maxCountEntity = Characteristic.MAX_COUNT_ENTITY.get(this.getClass().getSimpleName());
        int successOfReproduce = Characteristic.SUCCESS_OF_REPRODUCE.get(this.getClass().getSimpleName());
        int countChild = ((countEntityOnRegion / 2) * successOfReproduce) / 100;
        int countEntity = countEntityOnRegion + countChild;

        int countNewEntity = countEntity <= maxCountEntity ? countChild : maxCountEntity - countEntity;
        for (int i = 0; i < countNewEntity; i++) {
            region.addEntity(EntityCreator.getNewEntity(this.getClass().getSimpleName()));
        }
    }

    public void move(Region region) {
        Island island = region.getIsland();
        Direction direction = Direction.values()[random.nextInt(Direction.values().length)];
        int maxCountSteps = Characteristic.MAX_COUNT_STEP.get(this.getClass().getSimpleName());
        int countSteps = random.nextInt(maxCountSteps);
        Region newRegion = island.getRegion(region, direction, countSteps);
        if (!region.equals(newRegion)) {
            newRegion.addEntity(this);
            region.deleteEntity(this);
        }
    }

    public void eat(Region region) {
//        toEat(region);
    }

    public void feelHungryOrDie(Region region) {

    }
}
