package island;

import configuration.YAMLData;
import entity.Entity;
import entity.EntityCreator;
import entity.animal.herbivores.*;
import entity.animal.predators.*;
import entity.plant.Plant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Region implements Runnable {

    private final Lock lock = new ReentrantLock(true);
    private final Coordinate coordinate;
    private final HashMap<String, Integer> maxCountEntity = YAMLData.MAX_COUNT_ENTITY;
    private final HashMap<String, String> icon = YAMLData.ICON;

    private volatile List<Entity> entities = new ArrayList<>();
    private Random random = new Random();


    public Region(Coordinate coordinate) {
        this.coordinate = coordinate;
        generateEntities();
    }


//    public Lock getLock() {
//        return lock;
//    }

    public int getCountEntityOnRegion(Class<? extends Entity> clazz) {
        return entities.stream()
                .filter(animal -> clazz.equals(animal.getClass()))
                .toList()
                .size();
    }

    public synchronized void addEntity(Entity entity) {
        entities.add(entity);
    }

    public synchronized void deleteEntity(Entity entity) {
        entities.remove(entity);
    }

    public synchronized List<Entity> getEntityList(Entity entity) {
        return entities;
    }

    @Override
    public void run() {

    }

    public void printStatistic() {
        System.out.printf("На локации %d-%d:\n", coordinate.getIslandWidth(), coordinate.getIslandLenght());

        //Predators
        toPrint(Wolf.class);
        toPrint(Anaconda.class);
        toPrint(Bear.class);
        toPrint(Fox.class);
        toPrint(Eagle.class);

        //Herbivores
        toPrint(Horse.class);
        toPrint(Deer.class);
        toPrint(Rabbit.class);
        toPrint(Mouse.class);
        toPrint(Goat.class);
        toPrint(Sheep.class);
        toPrint(Boar.class);
        toPrint(Buffalo.class);
        toPrint(Duck.class);
        toPrint(Caterpillar.class);

        //Plants
        toPrint(Plant.class);
    }

    private void toPrint(Class<? extends Entity> clazz) {
        System.out.println(icon.get(clazz.getSimpleName()) + " " + getCountEntityOnRegion(clazz) + " шт.");
    }

    private void generateEntities() {
        for (String key : icon.keySet()) {
            for (int i = 0; i < random.nextInt(maxCountEntity.get(key)); i++) {
                addEntity(EntityCreator.getNewEntity(key));
            }
        }
    }

}