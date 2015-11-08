package poa.exercices.feedPigeons.interfaces;

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

    public void move(Point newPosition) {
        this.position = newPosition;
        this.drawing.setLocation(newPosition.x, newPosition.y);
    }



    public Rectangle getDrawing() {
        return this.drawing;
    }

    public Color getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        return "EntityShape{Color:" + this.color + ", Position: " + this.position + ", Rectangle: " + this.drawing + "}";
    }
}
