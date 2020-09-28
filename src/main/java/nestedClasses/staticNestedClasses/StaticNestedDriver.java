package nestedClasses.staticNestedClasses;

public class StaticNestedDriver {
    public static void main(String args[]) {
        // OuterWithNestedStatic example
        //OuterWithNestedStatic.NestedStaticClass obj = new OuterWithNestedStatic.NestedStaticClass();
        //obj.message();

        // MyMap example
        //MyMap m = new MyMap(5);
        //m.put("hello", 2);
        //System.out.println(m.get("hello"));
        MyMap.MyEntry entry = new MyMap.MyEntry("hello", 6);
        System.out.println(entry.getKey());

    }
}
