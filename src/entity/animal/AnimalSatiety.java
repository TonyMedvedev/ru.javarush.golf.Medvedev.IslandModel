package entity.animal;

import entity.animal.herbivores.*;
import entity.animal.predators.*;

public class AnimalSatiety {
    public static double get(Animal animal) {

        double satiety = 0;

        if (animal instanceof Wolf) {
            satiety = ((Wolf) animal).getSatiety();
        } else if (animal instanceof Anaconda) {
            satiety = ((Anaconda) animal).getSatiety();
        } else if (animal instanceof Bear) {
            satiety = ((Bear) animal).getSatiety();
        } else if (animal instanceof Fox) {
            satiety = ((Fox) animal).getSatiety();
        } else if (animal instanceof Eagle) {
            satiety = ((Eagle) animal).getSatiety();
        } else if (animal instanceof Horse) {
            satiety = ((Horse) animal).getSatiety();
        } else if (animal instanceof Deer) {
            satiety = ((Deer) animal).getSatiety();
        } else if (animal instanceof Rabbit) {
            satiety = ((Rabbit) animal).getSatiety();
        } else if (animal instanceof Mouse) {
            satiety = ((Mouse) animal).getSatiety();
        } else if (animal instanceof Goat) {
            satiety = ((Goat) animal).getSatiety();
        } else if (animal instanceof Sheep) {
            satiety = ((Sheep) animal).getSatiety();
        } else if (animal instanceof Boar) {
            satiety = ((Boar) animal).getSatiety();
        } else if (animal instanceof Buffalo) {
            satiety = ((Buffalo) animal).getSatiety();
        } else if (animal instanceof Duck) {
            satiety = ((Duck) animal).getSatiety();
        } else if (animal instanceof Caterpillar) {
            satiety = ((Caterpillar) animal).getSatiety();
        }

        return satiety;
    }
    public static void set(Animal animal, double satiety) {

        if (animal instanceof Wolf) {
            ((Wolf) animal).setSatiety(satiety);
        } else if (animal instanceof Anaconda) {
            ((Anaconda) animal).setSatiety(satiety);
        } else if (animal instanceof Bear) {
            ((Bear) animal).setSatiety(satiety);
        } else if (animal instanceof Fox) {
            ((Fox) animal).setSatiety(satiety);
        } else if (animal instanceof Eagle) {
            ((Eagle) animal).setSatiety(satiety);
        } else if (animal instanceof Horse) {
            ((Horse) animal).setSatiety(satiety);
        } else if (animal instanceof Deer) {
            ((Deer) animal).setSatiety(satiety);
        } else if (animal instanceof Rabbit) {
            ((Rabbit) animal).setSatiety(satiety);
        } else if (animal instanceof Mouse) {
            ((Mouse) animal).setSatiety(satiety);
        } else if (animal instanceof Goat) {
            ((Goat) animal).setSatiety(satiety);
        } else if (animal instanceof Sheep) {
            ((Sheep) animal).setSatiety(satiety);
        } else if (animal instanceof Boar) {
            ((Boar) animal).setSatiety(satiety);
        } else if (animal instanceof Buffalo) {
            ((Buffalo) animal).setSatiety(satiety);
        } else if (animal instanceof Duck) {
            ((Duck) animal).setSatiety(satiety);
        } else if (animal instanceof Caterpillar) {
            ((Caterpillar) animal).setSatiety(satiety);
        }
    }
}
