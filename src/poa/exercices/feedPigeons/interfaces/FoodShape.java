package poa.exercices.feedPigeons.interfaces;

import java.awt.*;

public class FoodShape extends EntityShape {

    public FoodShape(Point position) {
        super(position, new Rectangle(position.x, position.y, 10, 10), Color.ORANGE);
    }

}
