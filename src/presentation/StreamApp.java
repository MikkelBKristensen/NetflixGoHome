package presentation;

import domain.*;
import exceptions.FileNotLoadedException;

import java.util.ArrayList;
import java.util.List;


public class StreamApp {
    private ProfileCollection profileList;
    private MediaCollection fullMediaList;
    private MediaCollection currentMediaList;

    public StreamApp() {
        initialize();
    }
    private void initialize() {
        //TODO Proper exception handling
        try {
            profileList = new ProfileList();
            fullMediaList = new MediaList();
            currentMediaList = fullMediaList.getCollectionByName(generateMediaTitleList(fullMediaList.getMedia()));
        } catch (FileNotLoadedException e) {
            System.out.println("Fuck");
        }

    }

    private List<String> generateMediaTitleList(List<Media> mediaList) {

        List<String> mediaNames = new ArrayList<>();

        for(Media media : mediaList) {
            mediaNames.add(media.getTitle());
        }

        return mediaNames;
    }


    public static void main(String[] args) {
        StreamApp streamingApp = new StreamApp();
    }
}
