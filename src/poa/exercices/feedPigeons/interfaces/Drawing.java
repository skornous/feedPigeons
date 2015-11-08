package poa.exercices.feedPigeons.interfaces;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Drawing extends JPanel {
    private List<EntityShape> shapes;

    public Drawing(UserInterface ui) {
        super();
        this.shapes = new ArrayList<>();

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
//            es.repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
//        this.setBackground(Color.WHITE);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        for (EntityShape es : this.shapes) {
            g.setColor(es.getColor());
            Rectangle esDrawing = es.getDrawing();
            g.fillRect(esDrawing.x, esDrawing.y, esDrawing.width, esDrawing.height);
        }
    }
}
