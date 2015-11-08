package poa.exercices.feedPigeons;

import poa.exercices.feedPigeons.interfaces.EntityShape;
import poa.exercices.feedPigeons.utils.Case;

import java.awt.*;

public abstract class Entity extends Thread {
    protected static long id = 0;
    protected long identifier;
    protected Case position;
    protected EntityShape shape;
    private final static int gridSizer = 10;

    public Entity(Case position) {
        this.position = position;
        this.identifier =  this.id;
        this.shape = null;
        this.id +=  1;
    }

    public Case getPosition() {
        return position;
    }
    public Point getGridPosition() {
        return new Point(this.position.getX() * this.gridSizer, this.position.getY() * this.gridSizer);
    }

    public void setPosition(Case position) {
        this.position = position;
    }

    public long getIdentifier() {
        return this.identifier;
    }

    public void registerShape(EntityShape shape) {
        this.shape = shape;
    }
}
