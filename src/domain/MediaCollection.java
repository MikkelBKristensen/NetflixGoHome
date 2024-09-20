package domain;

import java.io.IOException;
import java.util.List;

public interface MediaCollection {
    MediaCollection getCollectionByGenre(String genre);

    MediaCollection getCollectionByName(List<String> chosenMedia);

    MediaCollection getCollectionByName(String chosenMedia);

    MediaCollection getCollectionByType(String mediaType) throws IOException;

    void sortByRating();

    void sortByRatingReverse();

    void sortByReleaseYear();

    void sortByReleaseYearReverse();

    void sortByAlphabetical() throws IOException;

    void sortByAlphabeticalReverse() throws IOException;

    List<Media> getMedia();

    String getGenre();
}
