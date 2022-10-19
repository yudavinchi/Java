package org.day2;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Team {

    private final int numOfTeamPlayer = 11;
    private String name;
    private Player[] team;

    private HashMap<Position, Integer> positionMap = new HashMap<>();

    public Team(String name){

        this.name = name;

        team = new Player[numOfTeamPlayer];
        Set<Integer> jerseySet = new HashSet<>();
        Random rnd = new Random();
        int jerseyNum;

        for (int i = 0; i < numOfTeamPlayer; i++) {

            // generates unique jersey number
//            do{
//                jerseyNum = rnd.nextInt(upperBoundJerseyShirt);
//            }
//            while(!jerseySet.add(jerseyNum));

            int grade = rnd.nextInt(101);

            //team[i] = new Player(name, jerseyNum, grade);
        }
    }

    public void print(){
        for(Player player: team){
            System.out.println(player.name + " " + player.jerseyNum + " " + player.grade + " " + player.pos);
        }
    }

    private void defineNumOfPositions(int goalKeeper, int attacker, int midfielder,  int defender){
        positionMap.put(Position.GOAL_KEEPER, goalKeeper);
        positionMap.put(Position.ATTACKER, attacker);
        positionMap.put(Position.MIDFIELDER,midfielder);
        positionMap.put(Position.DEFENDER, defender);
    }

    public static void main(String[] args) {
        Team team = new Team("Barcelona");
        team.print();
    }
}
