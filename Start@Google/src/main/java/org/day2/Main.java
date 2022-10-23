package org.day2;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        try {
            Team.createTeamWithoutGivenFormation().print();
        } catch (NullPointerException e) {
            System.out.println("Team doesn't exist");
        }

        try {
            Team.createTeamWithoutGivenFormation().printDataOnFile();
        } catch (NullPointerException e) {
            System.out.println("Team doesn't exist");
        }

        HashMap<Position, Integer> temp = new HashMap<>();

        temp.put(Position.GOAL_KEEPER, 1);
        temp.put(Position.ATTACKER, 6);
        temp.put(Position.MIDFIELDER, 2);
        temp.put(Position.DEFENDER, 3);

        try {
            Team.createTeamWithGivenFormation(temp).print();
        } catch (NullPointerException e) {
            System.out.println("Team doesn't exist");
        }
    }
}
