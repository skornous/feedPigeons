package poa.exercices.feedPigeons.interfaces;

import java.awt.*;

public class BirdShape extends EntityShape {

    public BirdShape(Point position) {
        super(position, new Rectangle(position.x, position.y, 25, 25), Color.DARK_GRAY);
    }

}
