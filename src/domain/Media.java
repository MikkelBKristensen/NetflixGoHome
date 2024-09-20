package domain;

import java.awt.*;
import java.util.List;

public abstract class Media {

    protected String title;
    protected int releaseYear;
    protected List<String> genres;
    protected double rating;
    protected Image poster;

    public Media(String title, int releaseYear, List<String> genres, double rating, Image poster) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.genres = genres;
        this.rating = rating;
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public List<String> getGenres() {
        return genres;
    }

    public double getRating() {
        return rating;
    }

    public Image getPoster() {
        return poster;
    }

    @Override
    public String toString() {

        String outputString = "";

        outputString += "Title: " + title + ". ";
        outputString += "Year of release: " + releaseYear + ". ";
        outputString += "Genres: ";

        for(String genre : genres) {
            outputString += genre + " ";
        }

        return outputString;
    }
}
