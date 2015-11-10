package poa.exercices.feedPigeons;

import poa.exercices.feedPigeons.interfaces.EntityShape;
import poa.exercices.feedPigeons.utils.Case;

import java.awt.*;

public abstract class Entity extends Thread {
    protected final static int worldSize = 500;
    private final static int gridSizer = 1;
    protected static long id = 0;
    protected long identifier;
    protected Case position;
    protected EntityShape shape;

    public Entity(Case position) {
        this.position = position;
        this.identifier = id;
        this.shape = null;
        id += 1;
    }

    public Case getPosition() {
        return position;
    }

    public void setPosition(Case position) {
        this.position = position;
    }

    public Point getGridPosition() {
        return new Point(this.position.getX() * gridSizer, this.position.getY() * gridSizer);
    }

    public long getIdentifier() {
        return this.identifier;
    }

    public void registerShape(EntityShape shape) {
        this.shape = shape;
    }

    public EntityShape getShape() {
        return shape;
    }
}
