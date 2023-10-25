package baseball.computer;

import baseball.dto.Score;

import java.util.List;

public interface GameManager {
    List<Integer> createNumber();

    Score calculateCount(List<Integer> randomNumber);

    void printCount(List<Integer> randomNumber);
}
