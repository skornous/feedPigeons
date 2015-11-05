package poa.exercices.feedPigeons;

import poa.exercices.feedPigeons.interfaces.EntityShape;
import poa.exercices.feedPigeons.utils.Case;

public abstract class Entity extends Thread {
    protected static long id = 0;
    protected long identifier;
    protected Case position;
    protected EntityShape shape;

    public Entity(Case position) {
        this.position = position;
        this.identifier =  this.id;
        this.shape = null;
        this.id +=  1;
    }

    public Case getPosition() {
        return position;
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
