package domain;

import java.awt.*;
import java.util.List;

public class Movie extends Media{
    public Movie(String title, int releaseYear, List<String> genres, double rating, Image poster) {
        super(title, releaseYear, genres, rating, poster);
    }

    @Override
    public String toString() {
        return "Movie - " + super.toString();
    }

}
