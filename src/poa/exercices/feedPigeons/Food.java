package poa.exercices.feedPigeons;

import poa.exercices.feedPigeons.utils.Case;

import java.awt.*;

public class Food extends Entity {

    private int size;
    private boolean isEatable;
    private int rottenDuration = 10000;

    public Food(Case position) {
        super(position);
        this.size = 1; // each food is a size 1 food
        this.isEatable = true;
    }

    public int getSize() {
        return size;
    }

    public boolean canEat() {
        return this.isEatable;
    }

    public void rot() {
        this.shape.setColor(new Color(85, 107, 47));
        this.isEatable = false;
    }

    public void killShape() {
        this.shape.deadShape();
    }

    @Override
    public String toString() {
        return "Food{" + "Position: " + this.position + '}';
    }

    public int getRottenDuration() {
        return rottenDuration;
    }

    public void setRottenDuration(int rottenDuration) {
        this.rottenDuration = rottenDuration;
    }
}
