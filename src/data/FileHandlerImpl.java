package data;

import exceptions.FileNotLoadedException;
import exceptions.FileNotSavedException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandlerImpl implements FileHandler {
    // reading file and returning as arrayList
    public List<String> loadFile(File file) throws FileNotLoadedException {

        List<String> loadedData = new ArrayList<>();

        if(file == null) {
            throw new FileNotLoadedException("File is of value Null: Internal system error");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String nextInput;

            while ((nextInput = reader.readLine()) != null) {
                loadedData.add(nextInput);
            }
        } catch (IOException e) {
            throw new FileNotLoadedException(file.getName());
        }

        return loadedData;
    }

    public void saveFile(List<String> saveData, File file) throws FileNotSavedException {

        if(saveData == null || file == null) {
            throw new FileNotSavedException("Savedata or specified file is of value null: Internal systems error");
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {

            if(file.length() > 0) {
                writer.println();
            }
            //Print savaData to file, except last element of Array. Last element is printed separately
            for (int i = 0; i < saveData.size() - 1; i++) {
                writer.println(saveData.get(i));
            }

            //Prints the last element of saveData without /n
            writer.print(saveData.get(saveData.size() - 1));

        } catch (IOException e) {
            throw new FileNotSavedException(file);
        }
    }

    public void saveFileOverwrite(List<String> saveData, File file) throws FileNotSavedException {

        if(saveData == null || file == null) {
            throw new FileNotSavedException("Savedata or specified file is of value null: Internal systems error");
        }

        try (PrintWriter writer = new PrintWriter(file)) {

            //Print savaData to file, except last element of Array. Last element is printed separately
            for (int i = 0; i < saveData.size() - 1; i++) {
                writer.println(saveData.get(i));
            }

            //Prints the last element of saveData without exiting with a /n
            writer.print(saveData.get(saveData.size() - 1));

        } catch (IOException e) {
            throw new FileNotSavedException(file);
        }
    }

    public Image getImage(String title, String mediaType) throws IOException {
        if(mediaType.equals("film")) {
            try {
                return ImageIO.read(new File("lib/media/" + mediaType + "plakater/" + title + ".jpg"));
            } catch (IOException | IllegalArgumentException e) {
                return ImageIO.read(new File("lib/media/" + mediaType + "plakater/Placeholder.jpg"));
            }
        } else if (mediaType.equals("serie")) {
            try {
                return ImageIO.read(new File("lib/media/" + mediaType + "forsider/" + title + ".jpg"));
            } catch (IOException | IllegalArgumentException e) {
                return ImageIO.read(new File("lib/media/" + mediaType + "forsider/Placeholder.jpg"));
            }
        }
        return null;
    }
}
