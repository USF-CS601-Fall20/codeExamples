package nestedClasses.innerClasses;

/** Example of an inner class contained within an outer class.  */
public class MyOuter {
    private int outerVar; // instance variable in the outer class

    public MyOuter(int var) {
        this.outerVar =  var;
    }

    public void outerFunc() {
        MyInner innerObj  = new MyInner();
        System.out.println(innerObj.innerVar);
    }
    /* Inner class, MyInner
     *  Declared with default visibility */
    class MyInner { // could make this class private, protected, default or public
        private int innerVar;

        void innerFunc() {
            System.out.println(innerVar); // referring to its own variable
            System.out.println(outerVar); // referring to outer's variable
        }

    }

}

