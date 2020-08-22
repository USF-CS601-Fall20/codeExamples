package javaBasics;

/** A class that represents a six-sided die
        State: which face is showing
        Behavior: can be rolled
*/
public class Die {
    private int faceValue;

    /** Default constructor
     * (would be better to roll the die here than setting to 1)
     */
    public Die() {

        faceValue = 1;
    }

    /**
     * Rolls the die and sets the face value.
     */
    public void roll() {
        this.faceValue = (int)(6 * Math.random())  + 1;
    }

    /**
     * Getter for the face value
     * @return current face value
     */
    public int getFaceValue(){
        return this.faceValue;
    }

    /**
     * Setter for the face value
     * @param faceValue new face value
     * Note: I added this method to show how we may want to validate parameters in a setter,
     * but we generally may not want to allow setting the face value manually
     *
     */
    public void setFaceValue(int faceValue) {
        if (faceValue < 1 || faceValue > 6)
            throw new IllegalArgumentException();
        this.faceValue = faceValue;
    }

    /**
     * toString
     * @return a string representation of this die
     */
    public String toString() {
        return "Face Value: " + faceValue;
    }

}
