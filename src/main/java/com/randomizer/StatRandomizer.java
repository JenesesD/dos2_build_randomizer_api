package com.randomizer;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StatRandomizer {

    boolean isUndead(Random rand) {
        return rand.nextInt(100) <= 50;
    }

    String raffleTalent(List<String> talents, Random rand) {
        return talents.get(rand.nextInt(talents.size()));
    }

    // TODO: Ask a mentor about this method, found on stackoverflow
    <T extends Enum<?>> T randomEnum(Class<T> cls, Random rand) {
        int x = rand.nextInt(cls.getEnumConstants().length);
        return cls.getEnumConstants()[x];
    }

    List<String> raffleStats(List<String> stats, Random rand, int amount) {
        List<String> items = new ArrayList<>();
        while (items.size() != amount) {
            String temp = stats.get(rand.nextInt(stats.size()));
            if (!items.contains(temp)){
                items.add(temp);
            }
        }
        return items;
    }
}
