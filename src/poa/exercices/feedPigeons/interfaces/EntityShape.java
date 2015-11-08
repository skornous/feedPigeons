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
        return this.drawing;
    }

    public Color getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        return "EntityShape{Color:" + this.color + ", Position: " + this.position + ", Rectangle: " + this.drawing + "}";
    }

//    @Override
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        g.setColor(this.color);
//        g.fillRect(this.drawing.x, this.drawing.y, this.drawing.width, this.drawing.height);
//    }
}
