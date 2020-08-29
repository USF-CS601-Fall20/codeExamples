package javaBasics;

import java.util.*;
public class Movie {
    private String title;
    private List<String> castMembers;

    public Movie(String title) {
        this.title = title;
        this.castMembers = new ArrayList<>();
    }

    public void addCastMember(String member) {
        this.castMembers.add(member);
    }

    public String toString() {
        return title;
    }

    public List<String> getCastMembers() {
        List<String> newList = new ArrayList<>();
        for (int i = 0; i< castMembers.size(); i++) {
            newList.add(castMembers.get(i));
        }
        return newList;
    }
}
