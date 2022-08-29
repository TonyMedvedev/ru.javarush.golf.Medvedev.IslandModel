package entity.animal;

import configuration.Characteristic;
import entity.Direction;
import entity.Entity;
import entity.EntityCreator;
import island.Island;
import island.Region;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Animal extends Entity {

    private HashMap<String, Double> maxSatietyList = Characteristic.MAX_SATIETY;
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
        Entity victim = searchVictim(region, this);
        int chanceBeEating = Characteristic.CHANCE_OF_GETTING_FOOD
                .get(this.getClass().getSimpleName())
                .get(victim.getClass().getSimpleName());
        int randomChance = random.nextInt(100);
        if (randomChance < chanceBeEating) {
            double currentSatiety = AnimalSatiety.get(this);
            double maxSatiety = Characteristic.MAX_SATIETY.get(this.getClass().getSimpleName());
            double weightVictim = Characteristic.WEIGHT.get(victim.getClass().getSimpleName());
            double deltaSatiety = weightVictim / 10;
            double newSatiety = Math.min(currentSatiety + deltaSatiety, maxSatiety);
            AnimalSatiety.set(this, newSatiety);
            region.deleteEntity(victim);
        }
    }


    public void feelHungryOrDie(Region region) {
        double currentSatiety = AnimalSatiety.get(this);
        double maxSatiety = Characteristic.MAX_SATIETY.get(this.getClass().getSimpleName());
        double hungerRatio = maxSatiety / 10;
        double newSatiety = currentSatiety - hungerRatio;
        if (maxSatiety != 0) {
            if (newSatiety > 0) {
                AnimalSatiety.set(this, newSatiety);
            } else {
                region.deleteEntity(this);
            }
        } else {
            double chanceToStarve = 0.7;
            double randomChance = random.nextDouble(1.0);
            if (randomChance < chanceToStarve) {
                region.deleteEntity(this);
            }
        }
    }

    public Entity searchVictim(Region region, Animal hunter) {

        HashMap<String, Integer> mapVictimAndChanceBeEating =
                Characteristic.CHANCE_OF_GETTING_FOOD.get(hunter.getClass().getSimpleName());
        List<String> victims = new ArrayList<>();

        for (String key : mapVictimAndChanceBeEating.keySet()) {
            if (mapVictimAndChanceBeEating.get(key) != 0) {
                victims.add(key);
            }
        }
        String victimType = victims.get(random.nextInt(victims.size()));

        List<Entity> entities = region.getEntityList().stream()
                .filter(entity -> victimType.equals(entity.getClass().getSimpleName()))
                .toList();
        Entity victim = entities.get(random.nextInt(entities.size()));
        return victim;
    }
}
