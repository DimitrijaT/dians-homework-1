package mk.finki.students;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LineCollection {

    private List<Line> lines;

    public List<Line> getLines() {
        return lines;
    }

    public LineCollection() {
        this.lines = new ArrayList<>();
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    public void printLinesCsv() {
//        StringBuilder stringBuilder = new StringBuilder();
        lines.stream().forEach(line -> line.toString());
    }


    public void readLines(String path) throws FileNotFoundException, UnsupportedEncodingException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
        lines = bufferedReader.lines().map(line -> Line.createLine(line)).filter(Objects::nonNull).collect(Collectors.toList());
    }

}
