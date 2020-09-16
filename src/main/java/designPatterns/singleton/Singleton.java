package designPatterns.singleton;

/** Example of a class that implements the Singleton pattern */
public class Singleton {
  private static  Singleton singleton = new Singleton();

  private Singleton() { // Constructor must be private
  }

  public static Singleton getInstance() {
      return singleton;
  }


}
