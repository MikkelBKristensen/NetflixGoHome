package data;

import exceptions.FileNotLoadedException;
import exceptions.FileNotSavedException;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FileHandler {

    List<String> loadFile(File file) throws FileNotLoadedException;
    void saveFile(List<String> saveData, File file) throws FileNotSavedException;
    void saveFileOverwrite(List<String> saveData, File file) throws FileNotSavedException;
    Image getImage (String title, String mediaType) throws IOException;
}
