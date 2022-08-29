package entity.animal.herbivores;

import island.Region;
import lombok.Getter;
import lombok.Setter;
import entity.animal.Animal;

@Getter
@Setter
public class Duck extends Animal {
    private double satiety;

    public Duck() {
    }

    public Duck(Region region) {
        super(region);
    }
}