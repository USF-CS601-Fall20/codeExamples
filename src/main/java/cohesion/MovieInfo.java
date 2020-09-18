package cohesion;

import java.util.*;

public class MovieInfo {
    //maps a movie title to the list of cast members
    private Map<String, List<String>> movieMap;

    public MovieInfo() {
        movieMap = new HashMap<>();
    }

    public void addToMap(String movieTitle, String castMember) {
        if (movieMap.get(movieTitle) == null)
            movieMap.put(movieTitle, new ArrayList<>());
        movieMap.get(movieTitle).add(castMember);
    }

    public boolean isInMovie(String movieTitle, String castMember) {
        List<String> cast = movieMap.get(movieTitle);
        return cast.contains(castMember);
    }

    public void printCastMembers(String movieTitle) {
        List<String> cast = movieMap.get(movieTitle);
        for (String castMember: cast)
            System.out.println(castMember);

    }

}
