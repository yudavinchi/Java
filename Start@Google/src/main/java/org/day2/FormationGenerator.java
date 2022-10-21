package org.day2;

import org.day2.Position;

import java.util.HashMap;
import java.util.Random;

public class FormationGenerator {
    private HashMap<Position, Integer> formationMap;

    public FormationGenerator() {

        Random rnd = new Random();
        int slotsLeft = 4;
        int slots;

        formationMap = new HashMap<>();

        formationMap.put(Position.GOAL_KEEPER, 1);

        slots = rnd.nextInt(slotsLeft + 1);
        slotsLeft -= slots;

        formationMap.put(Position.ATTACKER, slots + 2);

        slots = rnd.nextInt(slotsLeft + 1);
        slotsLeft -= slots;

        formationMap.put(Position.MIDFIELDER, slots + 2);
        formationMap.put(Position.DEFENDER, slotsLeft + 2);
    }

    public HashMap<Position, Integer> getFormationMap() {
        return formationMap;
    }
}
