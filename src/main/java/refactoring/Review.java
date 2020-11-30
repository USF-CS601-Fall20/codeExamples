package refactoring;

import com.google.gson.JsonObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class to store the details related to each review
 */
public class Review implements Comparable<Review> {
    private String hotelId;
    private String reviewId;
    private int overallRating;
    private String reviewTitle;
    private String reviewText;
    private String userNickname;
    private Date reviewDate;
    private boolean isRecom = true;

    /**
     * Creates an instance of review with all the specified data
     * @param hotelId  id of hotel to which the review is associated
     * @param reviewId The unique id of the review
     * @param overallRating The rating given in the review
     * @param title The review title
     * @param reviewText The review that is given in text format
     * @param userNickname The username of person that provided the review
     * @param reviewDate  The date on which the review was made
     * @param isRecom Yes or no question as to whether reviewer will recommend the hotel
     * @throws ParseException Gets called when an error occurs during parsing of data
     */
    public Review(String hotelId, String reviewId, int overallRating, String title,
           String reviewText, String userNickname, String reviewDate, boolean isRecom) throws ParseException {

        this.hotelId = hotelId;
        this.reviewId = reviewId;
        this.overallRating = overallRating;
        this.reviewTitle = title;
        this.reviewText = reviewText;
        this.userNickname = userNickname;
        this.isRecom = isRecom;
        reviewDate = reviewDate.replace("T","-").replace("Z","");

        this.reviewDate = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").parse(reviewDate);
    }


    public Review(Review other) {
        this.reviewId = other.reviewId;
        this.hotelId = other.hotelId;
        this.overallRating = other.overallRating;
        this.reviewTitle = other.reviewTitle;
        this.reviewText = other.reviewText;
        this.userNickname = other.userNickname;
        this.reviewDate = other.reviewDate;
    }

    public String getReviewText() {
        return reviewText;
    }

    public String getReviewId() {
        return reviewId;
    }

    public Date getSubmissionDate() {
        return reviewDate;
    }
    /**
     * Creates a json object from the review info that matches the format specified by api
     * @return JsonObject containing review details
     */
    public JsonObject createJson(){

        JsonObject json = new JsonObject();
        json.addProperty("reviewId",reviewId);
        json.addProperty("title",reviewTitle);
        json.addProperty("user",userNickname);
        json.addProperty("reviewText",reviewText);
        json.addProperty("data",reviewDate.toString());

        return json;
    }

    /**
     * Method that specifies how to compare two instance of class review
     * @param other Another instance of review classs
     * @return integer (+ve zero or -ve depending on which is bigger)
     */
    @Override
    public int compareTo(Review other) {
        int op = -1 * reviewDate.compareTo(other.reviewDate);
        if(op == 0) {
            op = userNickname.compareTo(other.userNickname);
        }
        if(op == 0){
            op = reviewId.compareTo(other.reviewId);
        }
        return  op;
    }
}
