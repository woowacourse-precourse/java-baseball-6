package baseball.domain;

public class Balls {

    private int number;
    private int location;

    public Balls(int number, int location) {
        this.number = number;
        this.location = location;
    }

    public int getNumber() {
        return number;
    }

    public int getLocation() {
        return location;
    }
}
