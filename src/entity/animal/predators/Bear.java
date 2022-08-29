package entity.animal.predators;

import entity.animal.Animal;
import island.Region;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bear extends Animal {
    private double satiety;

    public Bear() {
    }

    public Bear(Region region) {
        super(region);
    }
}