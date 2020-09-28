package nestedClasses.innerClasses;

public class MyOuterExample {
    public static void main(String[] args) {
        MyOuter outer = new MyOuter(2);
        //outer.outerFunc();

        MyOuter.MyInner inner  = outer.new MyInner();
        inner.innerFunc();

        MyOuter.MyInner inner1 = new MyOuter(2).new MyInner();

    }
}
