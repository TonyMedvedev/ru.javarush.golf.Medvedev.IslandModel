package entity.animal.herbivores;

import island.Region;
import lombok.Getter;
import lombok.Setter;
import entity.animal.Animal;

@Getter
@Setter
public class Caterpillar extends Animal {
    private double satiety;

    public Caterpillar() {
    }

    public Caterpillar(Region region) {
        super(region);
    }
}