package entity.plant;

import configuration.Characteristic;
import entity.Entity;
import entity.EntityCreator;
import island.Region;

public class ParentPlant extends Entity {
    private Region region;

    public ParentPlant() {
    }

    public ParentPlant(Region region) {
        this.region = region;
    }

    public void spread(Region region) {
        int countEntityOnRegion = region.getCountEntityOnRegion(this.getClass());
        int maxCountEntity = Characteristic.MAX_COUNT_ENTITY.get(this.getClass().getSimpleName());
        int successOfReproduce = Characteristic.SUCCESS_OF_REPRODUCE.get(this.getClass().getSimpleName());
        int countChild = ((countEntityOnRegion / 2) * successOfReproduce) / 100;
        int countEntity = countEntityOnRegion + countChild;

        int countNewEntity = countEntity <= maxCountEntity ? countChild : maxCountEntity - countEntity;
        for (int i = 0; i < countNewEntity; i++) {
            region.addEntity(EntityCreator.getNewEntity(this.getClass().getSimpleName()));
        }
    }
}
