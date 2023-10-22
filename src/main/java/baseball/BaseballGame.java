package baseball;

import java.util.HashSet;
import java.util.Set;

public class BaseballGame {
    PlayerView playerView = new PlayerView();

    public void play() {
        playerView.start();
        do {
            startGame();
            playerView.end();
        } while (!isRetry());
    }

    private void startGame() {
        Computer computer = new Computer();
        String computerNumbers = computer.generate();
        GameResult gameResult = new GameResult();
        Referee referee = new Referee();
        do {
            playerView.inputNumbers();
            String playerNumbers = playerView.input();
            gameResult = referee.judge(computerNumbers, playerNumbers);
            gameResult.result();
        } while (!gameResult.isWin());
    }

    public void validateNumbers(String numbers) {
        if (!isValidNumeric(numbers)) {
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }
        if (!isValidLength(numbers)) {
            throw new IllegalArgumentException("자릿수가 올바르지 않습니다.");
        }
        if (!isDuplicate(numbers)) {
            throw new IllegalArgumentException("중복된 수가 존재합니다.");
        }
    }

    private boolean isValidNumeric(String numbers) {
        return numbers.matches("^[1-9]+$");
    }

    private boolean isValidLength(String numbers) {
        return numbers.length() == 3;
    }

    private boolean isDuplicate(String numbers) {
        Set<Character> uniqueDigits = new HashSet<Character>();
        for (char element : numbers.toCharArray()) {
            uniqueDigits.add(element);
        }
        return uniqueDigits.size() == 3;
    }

    private boolean isRetry() {
        return playerView.input().equals("2");
    }
}
