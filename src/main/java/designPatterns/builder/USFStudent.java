package designPatterns.builder;

public class USFStudent {
    private final int id;  // required
    private final String name;  // required
    private final int numCourses;
    private final String address;

    private USFStudent(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.numCourses = builder.numCourses;
        this.address = builder.address;
    }

    public static class Builder {
        private int id; // required
        private String name; // required
        private int numCourses = 0;     // optional
        private String address = null;  // optional

        public Builder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder setCourses(int numCourses) {
            this.numCourses = numCourses;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public USFStudent build() {
            return new USFStudent(this);
        }
    }
}
