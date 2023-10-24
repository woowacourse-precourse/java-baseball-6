package baseball;

public class User {
    private Baseballs baseballs;

    public void createBaseballs(String inputNumbers) {
        baseballs = BaseballsGenerator.createBaseballsByUserInput(inputNumbers);
    }

    public Baseballs getBaseballs() {
        return baseballs;
    }
}