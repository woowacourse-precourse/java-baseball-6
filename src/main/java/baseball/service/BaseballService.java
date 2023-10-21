package baseball.service;

import baseball.dto.GameStateDto;

public class BaseballService {

    private final String userNumber;
    private final String computerNumber;


    public BaseballService(String userNumber, String computerNumber) {
        this.userNumber = userNumber;
        this.computerNumber = computerNumber;
    }

    public GameStateDto caculate() {
        GameStateDto gameStateDto = new GameStateDto();
        calculateStrike(gameStateDto);
        calculateBall(gameStateDto);
        return gameStateDto;

    }

    private void calculateBall(
        GameStateDto gameStateDto) {
        for (int i = 0; i < 3; i++) {
            findDifferentIndexSameNumber(gameStateDto, i);
        }
    }

    private void findDifferentIndexSameNumber(GameStateDto gameStateDto, int i) {
        for (int j = 0; j < 3; j++) {
            if (isDifferentIndex(i, j) && isSameNumber(i, j)) {
                addBall(gameStateDto);
            }
        }
    }

    private boolean isSameNumber(int i, int j) {
        return userNumber.charAt(i) == computerNumber.charAt(j);
    }

    private boolean isSameNumber(int i) {
        return userNumber.charAt(i) == computerNumber.charAt(i);
    }


    private boolean isDifferentIndex(int i, int j) {
        return i != j;
    }

    private void addBall(GameStateDto gameStateDto) {
        gameStateDto.addBall();
    }

    private void calculateStrike(GameStateDto gameStateDto) {
        for (int i = 0; i < 3; i++) {
            if (isSameNumber(i)) {
                addStrike(gameStateDto);
            }
        }
    }

    private void addStrike(GameStateDto gameStateDto) {
        gameStateDto.addStrike();
    }
}
