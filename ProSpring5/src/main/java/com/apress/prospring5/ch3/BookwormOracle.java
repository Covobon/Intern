package com.apress.prospring5.ch3;

public class BookwormOracle implements Oracle{
    private Encyclopedia encyclopedia;

    public Encyclopedia getEncyclopedia() {
        return encyclopedia;
    }

    public void setEncyclopedia(Encyclopedia encyclopedia) {
        this.encyclopedia = encyclopedia;
    }

    @Override
    public String defineMeaningOfLife(){
        return "Encyclopedia are a waste of money - go see the world instead";
    }
}
