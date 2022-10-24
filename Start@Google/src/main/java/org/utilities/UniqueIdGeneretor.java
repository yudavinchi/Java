package org.utilities;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class UniqueIdGeneretor {
    Set<Integer> idSet;
    Random rnd;

    public UniqueIdGeneretor() {
        idSet = new HashSet<>();
        rnd = new Random();
    }

    public int generate() {

        int id, upperBound = 100;

        do {

            id = rnd.nextInt(upperBound);
        }
        while (!idSet.add(id));

        return id;
    }

    public void remove(int id) {
        idSet.remove(id);
    }

    public boolean exists(int id){
        return idSet.contains(id);
    }
}

