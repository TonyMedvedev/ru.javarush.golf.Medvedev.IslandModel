package entity.animal.predators;

import entity.animal.Animal;
import island.Region;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Eagle extends Animal {
    private double satiety;

    public Eagle() {
    }

    public Eagle(Region region) {
        super(region);
    }
}