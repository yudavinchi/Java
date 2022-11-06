package org.day8.exercise2;

import org.day8.exercise2.Farm.Animal;
import org.day8.exercise2.Farm.WoodenHorse;
import org.day8.exercise2.Farm.WoodenStructureAdapter;
import org.day8.exercise2.Farm.WoodenStructures;

public class Main {
    public static void main(String[] args) {
        WoodenStructures woodenHorse1 = new WoodenHorse();
        WoodenStructureAdapter woodenStructureAdapter1 = new WoodenStructureAdapter(woodenHorse1);
        woodenStructureAdapter1.move();
        Animal woodenStructureAdapter2 = (WoodenStructureAdapter)woodenStructureAdapter1.mate(null);
        woodenStructureAdapter2.move();
    }
}
