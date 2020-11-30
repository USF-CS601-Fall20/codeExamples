package refactoring;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Reviews {
    private SortedSet<Review> reviews;

    public Reviews() {
        reviews = new TreeSet<>(new Comparator<Review>() {
            @Override
            public int compare(Review o1, Review o2) {
                return o1.getReviewId().compareTo(o2.getReviewId());
            }
        });
    }

    // other methods - not shown here
}
