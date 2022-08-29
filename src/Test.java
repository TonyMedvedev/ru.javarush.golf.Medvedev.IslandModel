import configuration.Characteristic;
import island.Island;
import island.Region;

import java.util.List;
import java.util.Random;

public class Test {
    public static Random random = new Random();

    public static void main(String[] args) {
        Island island = new Island(2, 1);

        List<Region> regions = island.getRegions();
        for (Region region : regions) {
            System.out.println(region.getEntityList().size());
        }
//        island.getRegions().forEach(Region::printStatistic);

        island.bringAnimalToLive();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (Region region : regions) {
            System.out.println(region.getEntityList().size());
        }
//        island.getRegions().forEach(Region::printStatistic);
    }
}
