package mk.finki.students;

public class Line {

    private String x;
    private String y;

    private String type;
    private String location;

    public Line(String x, String y, String type, String location) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.location = location;
    }

    public static Line createLine(String s) {

        String[] string = s.split(",");

        String x = string[0];
        String y = string[1];
        String type = string[2];
        if (string.length < 4 || string[3].equals("")) {
            return null;
        }
        String location = string[3];
        return new Line(x, y, type, location);
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s\n", x, y, location);
    }
}
