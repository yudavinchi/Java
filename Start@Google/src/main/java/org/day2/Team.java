package org.day2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Team {

    private String name;
    private ArrayList<Player> team;
    UniqueJerseyNumberGenerator uniqueJerseyNumberGenerator;

    public Team(String name) {
        this.name = name;
        this.team = new ArrayList<>();
        this.uniqueJerseyNumberGenerator = new UniqueJerseyNumberGenerator();
    }

    public static Team createTeamWithoutGivenFormation() {

        Team team = new Team(NameGenerator.createFootballNameGeneratorWithoutInput().generateName());
        FormationGenerator formationGenerator = new FormationGenerator();
        team.setTeamFormation(formationGenerator.getFormationMap());
        team.setTeamNumbers();

        return team;
    }

    public static Team createTeamWithGivenFormation(HashMap<Position, Integer> formation) {

        Team team = new Team(NameGenerator.createFootballNameGeneratorWithoutInput().generateName());

        if(team.validateTeamFormation(formation))
        {
            team.setTeamFormation(formation);
            team.setTeamNumbers();
            return team;
        }
        return null;
    }

    private void setTeamFormation(HashMap<Position, Integer> formation) {

        formation.forEach(((key, value) -> {
            switch (key) {
                case GOAL_KEEPER:
                    for (int i = 0; i < value; i++) {
                        team.add(Player.createPlayerGoalKeeper());
                    }
                    break;
                case ATTACKER:
                    for (int i = 0; i < value; i++) {
                        team.add(Player.createPlayerAttacker());
                    }
                    break;
                case MIDFIELDER:
                    for (int i = 0; i < value; i++) {
                        team.add(Player.createPlayerMidfielder());
                    }
                    break;
                case DEFENDER:
                    for (int i = 0; i < value; i++) {
                        team.add(Player.createPlayerDefender());
                    }
                    break;
            }
        }));
    }

    private boolean validateTeamFormation(HashMap<Position, Integer> formation) {

        ArrayList<Integer> arrayList = new ArrayList<>();

        if (formation.get(Position.GOAL_KEEPER) != null && formation.get(Position.GOAL_KEEPER) == 1)
            arrayList.add(formation.get(Position.GOAL_KEEPER));
        else
            return false;

        if (formation.get(Position.ATTACKER) != null && formation.get(Position.ATTACKER) >= 2)
            arrayList.add(formation.get(Position.ATTACKER));
        else
            return false;

        if (formation.get(Position.MIDFIELDER) != null && formation.get(Position.MIDFIELDER) >= 2)
            arrayList.add(formation.get(Position.MIDFIELDER));
        else
            return false;

        if (formation.get(Position.DEFENDER) != null && formation.get(Position.DEFENDER) >= 2)
            arrayList.add(formation.get(Position.DEFENDER));
        else
            return false;
        
        int slots = 0;
        
        for (int i : arrayList) {
            slots += i;
        }

        if(slots != 11)
            return false;
        
        return true;
    }

    private void setTeamNumbers() {
        for (Player player : team) {
            player.setJerseyNum(uniqueJerseyNumberGenerator.generate());
        }
    }


    public void print() {
        System.out.println("Team: " + name);
        for (Player player : team) {
            System.out.println("Player: " + player.name + ", Jersey number: " + player.jerseyNum + ", Grade: " + player.grade + ", Position: " + player.pos);
        }
    }

    public void printDataOnFile() {
        try (PrintWriter out = new PrintWriter("out.txt");) {
            out.println("Team: " + name);
            for (Player player : team) {
                out.println("Player: " + player.name + ", Jersey number: " + player.jerseyNum + ", Grade: " + player.grade + ", Position: " + player.pos);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        }
    }

    public static void main(String[] args) {
        HashMap<Position, Integer> temp = new HashMap<>();
        temp.put(Position.GOAL_KEEPER, 1);
        temp.put(Position.ATTACKER, 6);
        temp.put(Position.MIDFIELDER, 2);
        temp.put(Position.DEFENDER, 2);

        Team.createTeamWithGivenFormation(temp).print();
    }
}
