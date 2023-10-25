package baseball.domain;

public class Computer {
    private NumberBaseball numberBaseball;

    public Computer(int count) {
        this.numberBaseball = NumberBaseball.generateRandom(count);
    }

    public NumberBaseball getNumberBaseball() {
        return numberBaseball;
    }
}