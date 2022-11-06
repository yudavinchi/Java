package org.day8.exercise2.Farm;

public class WoodenStructureAdapter implements Animal {

    WoodenStructures woodenStructures;

    public WoodenStructureAdapter(WoodenStructures woodenStructures) {
        this.woodenStructures = woodenStructures;
    }

    @Override
    public void move() {
        woodenStructures.roll();
    }

    @Override
    public Animal mate(Animal partner) {
        return new WoodenStructureAdapter(woodenStructures.replicate());
    }

    @Override
    public int getId() {
        return 0;
    }
}
