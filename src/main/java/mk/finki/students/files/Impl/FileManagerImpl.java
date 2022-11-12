package mk.finki.students.files.Impl;


import mk.finki.students.Line;
import mk.finki.students.LineCollection;
import mk.finki.students.exceptions.FileExistsException;
import mk.finki.students.files.FileManager;

import java.io.*;

public class FileManagerImpl implements FileManager {

    @Override
    public File createNewFile(String file) throws IOException, FileExistsException {
        File f = new File(file);
//        if (f.exists()) {
//            throw new FileExistsException();
//        }
        f.createNewFile();
        return f;
    }

    @Override
    public void writeToTextFile(File to, LineCollection lineCollection, Boolean append) throws IOException {

        PrintWriter writer = null;

        try {
            writer = new PrintWriter(new FileWriter(to, append));
            for (Line line : lineCollection.getLines()) {
                writer.write(line.toString());
            }

        } catch (IOException exception) {
            System.out.println("IOException thrown - writeToTextFile");
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }

    }

    @Override
    public File[] readCsvInFolder(String dirPath) throws FileNotFoundException {
        File f = new File(dirPath);

        if (!f.exists()) throw new FileNotFoundException();
        if (!f.isDirectory()) throw new FileNotFoundException();

        return f.listFiles((dir, name) -> name.endsWith(".csv"));
    }
}
