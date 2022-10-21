package org.day2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Team {

    private static final int numOfTeamPlayers = 11;
    private String name;
    private ArrayList<Player> team;
    UniqueJerseyNumberGenerator uniqueJerseyNumberGenerator;

    public Team(String name) {
        this.name = name;
        this.team = new ArrayList<>();
        this.uniqueJerseyNumberGenerator = new UniqueJerseyNumberGenerator();
    }

    public static Team createTeamWithoutGivenFormation() throws FileNotFoundException {

        Team team = new Team(NameGenerator.createFootballNameGeneratorWithoutInput().generateName());
        FormationGenerator formationGenerator = new FormationGenerator();
        team.setTeamFormation(formationGenerator.getFormationMap());
        team.setTeamNumbers();

        return team;
    }

    public static Team createTeamWithGivenFormation(HashMap<Position, Integer> formation) throws FileNotFoundException {

        Team team = new Team(NameGenerator.createFootballNameGeneratorWithoutInput().generateName());
        team.setTeamFormation(formation);
        team.setTeamNumbers();

        return team;
    }

    private void setTeamFormation(HashMap<Position, Integer> formation) {

        formation.forEach(((key, value) -> {
            switch (key) {
                case GOAL_KEEPER:
                    for (int i = 0; i < value; i++) {
                        try {
                            team.add(Player.createPlayerGoalKeeper());
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case ATTACKER:
                    for (int i = 0; i < value; i++) {
                        try {
                            team.add(Player.createPlayerAttacker());
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case MIDFIELDER:
                    for (int i = 0; i < value; i++) {
                        try {
                            team.add(Player.createPlayerMidfielder());
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case DEFENDER:
                    for (int i = 0; i < value; i++) {
                        try {
                            team.add(Player.createPlayerDefender());
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
            }
        }));
    }

    private void setTeamNumbers()
    {
        for(Player player : team)
        {
            player.setJerseyNum(uniqueJerseyNumberGenerator.generateUniqueNumber());
        }
    }



    public void print() {
        for (Player player : team) {
            System.out.println(player.name + " " + player.jerseyNum + " " + player.grade + " " + player.pos);
        }
    }

    public void printDataOnFile() throws FileNotFoundException {

        PrintWriter out = new PrintWriter("out.txt");

        for (Player player : team) {
            out.println(player.name + " " + player.jerseyNum + " " + player.grade + " " + player.pos);
        }

        out.close();
    }

    public static void main(String[] args) throws FileNotFoundException {

        HashMap<Position, Integer> formation = new HashMap<>();
        formation.put(Position.GOAL_KEEPER, 2);
        formation.put(Position.ATTACKER, 3);

        Team.createTeamWithGivenFormation(formation).printDataOnFile();
    }
}
