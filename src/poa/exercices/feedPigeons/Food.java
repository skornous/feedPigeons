package poa.exercices.feedPigeons;

import poa.exercices.feedPigeons.utils.Case;

public class Food extends Entity {

    private int size;

    public Food(Case position) {
        super(position);
        this.size = 1; // each food is a size 1 food
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Food{" + "Position: " + this.position + '}';
    }
}
