package baseball;

public class Computer {
    private Baseballs baseballs;

    public void createBaseballs() {
        baseballs = BaseballsGenerator.createBaseballsByRandomNumber();
    }

    public Baseballs getBaseballs() {
        return baseballs;
    }

}
