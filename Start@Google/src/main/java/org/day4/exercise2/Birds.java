package org.day4.exercise2;

public enum Birds {
    CUKOO("Cuculus canorus"){
        public void sing(){
            System.out.println("ku-ku");
        }
    },
    FLAMINGO("Phoenicopterus ruber"){
        public void sing(){
            System.out.println("The flamingo produces a goose-like honk");
        }
    },
    LOON("Gavia immer"){
        public void sing(){
            System.out.println("cooo-leee");
        }
    },
    RAVEN("Corvux corax"){
        public void sing(){
            System.out.println("cruck-cruck");
        }
    };

    Birds(String scientificName){
        this.scientificName = scientificName;
    }
    public final String scientificName;

    public abstract void sing();
}
