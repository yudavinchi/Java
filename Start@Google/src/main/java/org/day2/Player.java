package org.day2;

public class Player {
    String name;
    int jerseyNum;
    int grade;
    Position pos;

    static NameGenerator nameGenerator;

    public Player(String name, int jerseyNum, int grade){
        this.name = name;
        this.jerseyNum = jerseyNum;
        this.grade = grade;
    }

//    public Player(int jerseyNum, int grade){
//        this(, jerseyNum, grade);
//    }

    public void setPosition(Position pos){
        this.pos = pos;
    }
}
