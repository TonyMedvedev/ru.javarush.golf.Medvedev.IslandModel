package ru.javarush.golf.Medvedev.IslandModel;

import ru.javarush.golf.Medvedev.IslandModel.entity.animal.predators.Wolf;
import ru.javarush.golf.Medvedev.IslandModel.island.Island;
import ru.javarush.golf.Medvedev.IslandModel.island.Region;

import java.util.Scanner;

public class Runner {

    static Scanner scanner = new Scanner(System.in);
    public volatile static int test = 0;   ////// DELETE


    public static void main(String[] args) {
//      запрос размеров острова
        System.out.println("""
                Hello! Welcome to island simulator!
                In first, let's create our island.
                Enter the width and length for new island:""");

        System.out.print("-Width: ");
        int width = validation();
        System.out.print("-Length: ");
        int length = validation();

        Island island = new Island(width, length);

//        island.getRegions().forEach(Region::printStatistic);
        island.bringAnimalToLive();
//        island.getRegions().forEach(Region::printStatistic);

//        double satiety = new Wolf().getSatiety();

    }

    private static int validation() {
        while (true) {
            int nextInt = scanner.nextInt();
            if (nextInt > 0) {
                return nextInt;
            } else {
                System.out.println("Number mast be positive. Please, try again.");
            }
        }
    }
}