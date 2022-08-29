package entity.animal.herbivores;

import island.Region;
import lombok.Getter;
import lombok.Setter;
import entity.animal.Animal;

@Getter
@Setter
public class Deer extends Animal {
    private double satiety;

    public Deer() {
    }

    public Deer(Region region) {
        super(region);
    }
}