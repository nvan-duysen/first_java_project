package org.example.pojo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Environment {
    private Integer width;
    private Integer height;

    private ArrayList<ArrayList<Character>> background;

    public Environment(){
        this.width = 20;
        this.height = 10;

        ArrayList<ArrayList<Character>> backgroundArray = new ArrayList<ArrayList<Character>>();
        for (int y = 0; y < this.height; y++) {
            ArrayList<Character> tempArray = new ArrayList<Character>();
            for (int x = 0; x < this.height; x++) {
                if (x==y && y==0) {
                    tempArray.add('▧');
                    tempArray.add(' ');
                    continue;
                }
                tempArray.add('-');
                tempArray.add(' ');
            }
            backgroundArray.add(tempArray);
        }

        this.background = backgroundArray;
    }

    public Environment(Integer width, Integer height, ArrayList<ArrayList<Character>> background) {
        this.width = width;
        this.height = height;
        this.background = background;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public ArrayList<ArrayList<Character>> getBackground() {
        return background;
    }

    public void setBackground(ArrayList<ArrayList<Character>> background) {
        this.background = background;
    }

    @Override
    public String toString(){
        String s = "";
        for (int i=0; i < this.background.size(); i++) {
            for (int j=0; j < this.background.get(i).size(); j++) {
                s += this.background.get(i).get(j);
            }
            s += "\n";
        }
        return s.toString();
    }
}
