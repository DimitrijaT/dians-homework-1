package mk.finki.students;


import mk.finki.students.exceptions.FileExistsException;
import mk.finki.students.files.FileManager;
import mk.finki.students.files.Impl.FileManagerImpl;
import mk.finki.students.pipeandfilter.Pipe;

import java.io.File;
import java.io.IOException;

public class PipeAndFilterProblem {
    public static void main(String[] args) throws IOException, FileExistsException {
        Pipe<String> pipe = new Pipe<>();

        FileManager fileManager = new FileManagerImpl();
        File[] files = fileManager.readCsvInFolder("C:\\Users\\Public\\Documents\\PipeAndFilter\\src\\main\\java\\homework_1\\data");

        int i = 1;

        for (File s : files) {
            LineCollection collection = new LineCollection();
            collection.readLines(s.getAbsolutePath());
            collection.printLinesCsv();
            File f = fileManager.createNewFile(String.format("C:\\Users\\Public\\Documents\\PipeAndFilter\\src\\main\\java\\homework_1\\output\\%d.csv", i++));
            fileManager.writeToTextFile(f, collection, false);
        }

    }
}