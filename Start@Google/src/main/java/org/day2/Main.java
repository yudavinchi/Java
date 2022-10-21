package org.day2;

/*
    [V] - Create a Team class that has a name and a collection of players
    [V] - Add static factory methods that create a team given a specific formation. A formation is the number of players each position has.
        ex:
        1 - GK, 4 - Defense, 4 - Middlefiled, 2 - Attack
        1 - GK, 4 - Defense, 3 - Middlefiled, 3 - Attack
        etc…
    [V] - Add static factory methods to the Player class to enable creating different type of players.
    [V] - Create a NameGenerator class that has a name dictionary injected upon creation, and use it to generate player names.
    [V] - Use at least two different name dictionaries in your code.
    [V] - Add a function to the Team class that writes all the team’s data to a file.
 */

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Team.createTeamWithoutGivenFormation().print();
    }
}
