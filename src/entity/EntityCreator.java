package entity;

import entity.animal.herbivores.*;
import entity.animal.predators.*;
import entity.plant.supposedPlant.Plant;

public class EntityCreator {

    public static Entity getNewEntity(String type){
        return switch (type) {

            //Predators
            case "Wolf" -> new Wolf();
            case "Anaconda" -> new Anaconda();
            case "Bear" -> new Bear();
            case "Fox" -> new Fox();
            case "Eagle" -> new Eagle();

            //Herbivores
            case "Horse" -> new Horse();
            case "Deer" -> new Deer();
            case "Rabbit" -> new Rabbit();
            case "Mouse" -> new Mouse();
            case "Goat" -> new Goat();
            case "Sheep" -> new Sheep();
            case "Boar" -> new Boar();
            case "Buffalo" -> new Buffalo();
            case "Duck" -> new Duck();
            case "Caterpillar" -> new Caterpillar();

            //Plants
            case "Plant" -> new Plant();

            default -> throw new RuntimeException();
        };
    }
}
