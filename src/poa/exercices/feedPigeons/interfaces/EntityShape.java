package poa.exercices.feedPigeons.interfaces;

import poa.exercices.feedPigeons.utils.Case;

import java.awt.*;

public abstract class EntityShape {

    private Point position;
    private Rectangle drawing;
    private Color color;

    public EntityShape(Point position, Rectangle d, Color c) {
        super();
        this.position = position;
        this.drawing = d;
        this.color = c;
    }

    protected abstract void init();

    public void move(Case newPosition) {
        this.drawing.setLocation(newPosition.getX(), newPosition.getY());
    }


    public Point getPosition() {
        return this.position;
    }

    public Rectangle getDrawing() {
        return drawing;
    }

    public Color getColor() {
        return color;
    }
}
