package nestedClasses.staticNestedClasses;

import nestedClasses.staticNestedClasses.MyMap;

public class TestClass extends MyMap.MyEntry {
    private int y ;

    public TestClass(String key, Object value, int y) {
        super(key, value);
        this.y = y;
    }


}
