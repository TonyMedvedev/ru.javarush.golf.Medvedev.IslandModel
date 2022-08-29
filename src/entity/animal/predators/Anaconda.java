package entity.animal.predators;

import entity.animal.Animal;
import island.Region;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Anaconda extends Animal {
    private double satiety;

    public Anaconda() {
    }

    public Anaconda(Region region) {
        super(region);
    }
}