package nestedClasses.anonymous;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class ComparatorExampleLambda {

    public static void demonstrateAnonymousRunnable(){
        // Lambda
        Runnable r = () -> System.out.println("Hello!");

        // Equivalent to:
        /*Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello!");
            }
        };
        */
    }

    public static void demonstrateAnonymousComparator() {

        // Lambda
        Comparator<Student> comp = (s1, s2) -> s1.getName().compareTo(s2.getName());

        // Equivalent to an Anonymous class
        /*Set<Student> students = new TreeSet<Student>(new Comparator<Student> () {
            @Override
            public int compare(Student st1, Student st2) {
                return st1.getName().compareTo(st2.getName());
            }
        });
         */

        // Alternative
        // comp = Comparator.comparing(Student::getName);
        Set<Student> students = new TreeSet<Student>(comp);

        students.add(new Student("Neha Singh"));
        students.add(new Student ("Xue Liang"));
        students.add(new Student("Allison K"));
        System.out.println(students);

    }

    public static void main(String[] args) {
        demonstrateAnonymousRunnable();
        demonstrateAnonymousComparator();

    }

}
