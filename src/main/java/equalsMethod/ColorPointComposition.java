package equalsMethod;

import java.awt.*;

public class ColorPointComposition {
    private Point point;
    private Color color;

    public ColorPointComposition(int x, int y, Color col) {
        point  = new Point(x, y);
        color = col;
    }

    public Point asPoint() {
        return point;
    }



    @Override
    public boolean equals(Object obj) {
        if (! (obj instanceof ColorPointComposition)) {
            return false;
        }
        else {
            ColorPointComposition cpc = (ColorPointComposition) obj;

            return cpc.asPoint().equals(this.asPoint()) && (this.color.equals(((ColorPointComposition) obj).color));
        }
    }
}
