package mango;

import mango.task.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a storage space that saves and loads data from the hard disk.
 */
public class Storage {
    private final String filePath;

    /**
     * Constructor for a Storage.
     *
     * @param filePath The path for the file that will be saved to and loaded from.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Reads the file, interprets and loads the task list data into an ArrayList of Task objects.
     *
     * @return The ArrayList containing all the Tasks that correspond to the data in the file.
     */
    public ArrayList<Task> load() throws IOException {
        ArrayList<Task> list = new ArrayList<>();
        File f = new File(this.filePath);
        if (!f.exists()) {
            File directory = new File(f.getParent());
            if (!directory.exists()) {
                directory.mkdirs();
            }
            f.createNewFile();
        } else {
            Scanner s = new Scanner(f); // create a Scanner using the File as the source
            while (s.hasNext()) {
                String[] task = s.nextLine().split(":", 4);
                Task toAdd;
                switch (task[0]) {
                case "D":
                    toAdd = new Deadline(task[2], task[3], task[1]);
                    break;
                case "E":
                    toAdd = new Event(task[2], task[3], task[1]);
                    break;
                case "T":
                    toAdd = new Todo(task[2], task[1]);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + task[0]);
                }

                list.add(toAdd);
            }
        }

        return list;
    }

    /**
     * Saves the Tasks in the task list to the file.
     *
     * @param list The task list to be saved
     * @throws IOException If the FileWriter cannot locate the temporary file allocated.
     */
    public void save(TaskList list) throws IOException {
        String tempFilePath = "temp/mango.txt";
        File f = new File(tempFilePath);
        File directory = new File(f.getParent());
        if (!directory.exists()) {
            directory.mkdirs();
        }
        f.createNewFile();

        FileWriter fw = new FileWriter(tempFilePath);
        for (Task t : list.getList()) {
            fw.write(t.save());
        }
        fw.close();

        Files.copy(Paths.get(tempFilePath), Paths.get(this.filePath), StandardCopyOption.REPLACE_EXISTING);
        Files.delete(Paths.get(tempFilePath));
    }
}
