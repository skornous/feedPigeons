package poa.exercices.feedPigeons.utils;

import java.awt.*;

public class Case {
    protected int x;
    protected int y;

    public Case(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Case(Point point) {
        this(point.x, point.y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int distanceTo(Case c) {
        int distance = 0;

        distance += Math.abs(c.getX() - this.getX());
        distance += Math.abs(c.getY() - this.getY());

        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Case) {
            Case c = (Case) o;
            return this.x == c.getX() && this.y == c.getY();
        }
        return false;
    }

    @Override
    public String toString() {
        return "[x:" + this.x + ", y:" + this.y + "]";
    }

    public void moveTo(Case position) {
        if (Math.abs(this.x - position.getX()) > Math.abs(this.y - position.getY())) { // DistX > DistY
            this.setX((this.x > position.getX()) ? x - 1 : x + 1);
        } else {
            this.setY((this.y > position.getY()) ? y - 1 : y + 1);
        }
    }
}
