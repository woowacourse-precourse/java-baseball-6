package baseball.game.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Computer {
    private Long id;
    private List<Integer> numbers = new ArrayList<>();
    private int strikeCount;
    private int ballCount;

    public static Computer create(Long id, List<Integer> numbers) {
        Computer game = new Computer();
        game.id = id;
        game.numbers = numbers;
        game.strikeCount = 0;
        game.ballCount = 0;

        return game;
    }

    public Long getId() {
        return id;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public String getNumberToString() {
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void changeGameCount(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

}
