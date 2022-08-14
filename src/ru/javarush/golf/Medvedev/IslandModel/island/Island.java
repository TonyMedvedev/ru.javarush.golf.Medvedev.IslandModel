package ru.javarush.golf.Medvedev.IslandModel.island;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Island {



    private List<Region> regions = new ArrayList<>();
    private Coordinate maxCoordinates;


    public Island(int width, int length) {
        maxCoordinates = new Coordinate(width, length);
        generateRegions();
    }


    public List<Region> getRegions() {
        return regions;
    }

    private void generateRegions() {
        for (int i = 0; i < maxCoordinates.getIslandWidth(); i++) {
            for (int j = 0; j < maxCoordinates.getIslandLenght(); j++) {
                regions.add(new Region(new Coordinate(i, j)));
            }
        }
    }

    public void bringAnimalToLive() {

        int CORE_POOL_SIZE = 20;
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(CORE_POOL_SIZE);
        for (Region region : regions) {
            fixedThreadPool.submit(region);
        }
        fixedThreadPool.shutdown();

//        try {
//            if (fixedThreadPool.awaitTermination(Integer.MAX_VALUE, TimeUnit.DAYS)) {
//                game.showStatistics();
//            }
//        } catch (InterruptedException e) {
//            //
//            System.out.println("The game is finished");
//        }
    }

}