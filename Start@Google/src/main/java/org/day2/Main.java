package org.day2;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Team.createTeamWithoutGivenFormation().printDataOnFile();
    }
}
