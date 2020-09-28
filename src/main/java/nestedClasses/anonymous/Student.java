package nestedClasses.anonymous;

public class Student {
    protected String name;

    public Student(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Student " + getFirstName();
    }

    public String getName() {
        return name;
    }

    private String getFirstName() {
        return name.split(" ")[0];
    }
}
