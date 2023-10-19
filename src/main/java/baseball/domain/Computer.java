package baseball.domain;

public class Computer {

    private Baseball baseball;

    public Computer(Baseball baseball) {
        this.baseball = baseball;
    }

    public Baseball getBaseball() {
        return baseball;
    }

}
