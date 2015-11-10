package poa.exercices.feedPigeons.interfaces;

import poa.exercices.feedPigeons.Food;
import poa.exercices.feedPigeons.World;
import poa.exercices.feedPigeons.utils.Case;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class Drawing extends JPanel implements MouseListener {
    private List<EntityShape> shapes;
    private World w;

    public Drawing(UserInterface ui, World w) {
        super();
        this.shapes = new ArrayList<>();
        this.w = w;

        this.addMouseListener(this);

        this.setSize(ui.getWidth(), ui.getHeight());

        System.out.println(this.getWidth() + " " + this.getHeight());
    }

    public void addShape(EntityShape e) {
        this.shapes.add(e);
    }

    public void initShapes() {
        for (EntityShape es : this.shapes) {
            System.out.println("Entity created");
            System.out.println(es);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        ArrayList<EntityShape> deadShapes = new ArrayList<>();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        for (EntityShape es : this.shapes) {
            if (es.canDraw()) {
                g.setColor(es.getColor());
                Rectangle esDrawing = es.getDrawing();
                g.fillRect(esDrawing.x, esDrawing.y, esDrawing.width, esDrawing.height);
            } else {
                deadShapes.add(es);
            }
        }
        for (EntityShape es : deadShapes) {
            this.shapes.remove(es);
        }
    }

    public void removeShape(EntityShape es) {
        this.shapes.remove(es);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point mousePosition = this.getMousePosition();
        System.out.println("Clicked on " + mousePosition);
        Food f = new Food(new Case(mousePosition));
        this.w.addFood(f);

        FoodShape foodShape = new FoodShape(f.getGridPosition());
        f.registerShape(foodShape);
        this.addShape(foodShape);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
