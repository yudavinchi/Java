package org.day3.exercise1;

public class Circle implements Figure{

    double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    public double area(){
        return Math.PI * (radius * radius);
    }
}
