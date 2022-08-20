package island;

import configuration.Characteristic;
import entity.Entity;
import entity.EntityCreator;
import entity.animal.herbivores.*;
import entity.animal.predators.*;
import entity.plant.supposedPlant.Plant;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Region implements Runnable {

    private final Lock lock = new ReentrantLock(true);
    private final Coordinate coordinate;
    private final Island island;
    private final HashMap<String, Integer> maxCountEntity = Characteristic.MAX_COUNT_ENTITY;
    private final HashMap<String, String> icon = Characteristic.ICON;

    private volatile List<Entity> entities = new ArrayList<>();
    private Random random = new Random();


    public Region(Coordinate coordinate, Island island) {
        this.coordinate = coordinate;
        this.island = island;
        generateEntities();
    }

    public Island getIsland(){
        return island;
    }

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

    public synchronized List<Entity> getEntityList() {
        return entities;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public void run() {
        Entity entity = new Entity();
//        entity.toEat(this);
        entity.toReproduce(this);       //WORKED
        entity.toMove(this);            //WORKED
//        entity.toFeelHungryOrDie(this);
        entity.toSpread(this);      //WORKED
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