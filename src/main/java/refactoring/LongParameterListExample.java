package refactoring;

// Demonstrates how to fix the "long parameter list" code smell using parameter objects.
// Need a reference here, but I forgot where this example is from..
public class LongParameterListExample {

    // Code smell - long list of parameters
    public static void drawHouse(int xCenter, int yCenter, int rectWidth, int rectHeight, int triangleHeight) {
        // code to draw a house with rectangle and a triangle
        // ...
    }

    // Better: using parameter objects
    public static void drawHouseNew(Rectangle base, EquilateralTriangle roof) {
        base.draw("blue");
        roof.draw("red");
        // ...
    }

    public static void main(String[] args) {
        Rectangle base = new Rectangle(0, 0, 10, 10);
        EquilateralTriangle roof = new EquilateralTriangle(10, 0, 10, 10);
        drawHouseNew(base, roof);
    }
}
