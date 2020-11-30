package refactoring;

public class InlineMethodExample {
    public int getRating() {
        return (moreThanFiveLateDeliveries()) ?2:1 ; // Select this line, and Refactor/Inline Method
    }

    public boolean moreThanFiveLateDeliveries() {

        return getNumLateDeliveries() > 5;
    }

    public  int getNumLateDeliveries() {
        return 2;
    }

}
