package org.day2;

import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Random;

public class Player {
    String name;
    Integer jerseyNum = null;
    int grade;
    Position pos = null;

    private static final int upperBoundGrade = 101;

    static NameGenerator nameGenerator;

    public Player(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public static Player createPlayerWithRandomName(int grade) throws FileNotFoundException {
        String name = NameGenerator.createNameGeneratorWithoutInput().generateName();
        return new Player(name, grade);
    }

    public static Player createPlayerWithRandomGrade(String name) {
        Random rnd = new Random();
        return new Player(name, rnd.nextInt(upperBoundGrade));
    }

    public static Player createPlayerWithRandomData() {

        String name = NameGenerator.createNameGeneratorWithoutInput().generateName();
        Random rnd = new Random();

        return new Player(name, rnd.nextInt(upperBoundGrade));
    }

    public static Player createPlayerGoalKeeper() {
        String name = NameGenerator.createNameGeneratorWithoutInput().generateName();
        Random rnd = new Random();

        return new Player(name, rnd.nextInt(upperBoundGrade)).setPosition(Position.GOAL_KEEPER);
    }

    public static Player createPlayerAttacker() {
        String name = NameGenerator.createNameGeneratorWithoutInput().generateName();
        Random rnd = new Random();

        return new Player(name, rnd.nextInt(upperBoundGrade)).setPosition(Position.ATTACKER);
    }

    public static Player createPlayerMidfielder() {
        String name = NameGenerator.createNameGeneratorWithoutInput().generateName();
        Random rnd = new Random();

        return new Player(name, rnd.nextInt(upperBoundGrade)).setPosition(Position.MIDFIELDER);
    }

    public static Player createPlayerDefender() {
        String name = NameGenerator.createNameGeneratorWithoutInput().generateName();
        Random rnd = new Random();

        return new Player(name, rnd.nextInt(upperBoundGrade)).setPosition(Position.DEFENDER);
    }

    public void setJerseyNum(int jerseyNum) {
        this.jerseyNum = jerseyNum;
    }

    public Player setPosition(Position pos) {
        this.pos = pos;
        return this;
    }
}
