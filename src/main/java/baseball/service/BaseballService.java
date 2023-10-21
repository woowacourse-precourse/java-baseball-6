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
        calculateStrike(userNumber, computerNumber, gameStateDto);
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
            if (i != j && userNumber.charAt(i) == computerNumber.charAt(j)) {
                addBall(gameStateDto);
            }
        }
    }

    private void addBall(GameStateDto gameStateDto) {
        gameStateDto.addBall();
    }

    private void calculateStrike(String userNumber, String nowComNumber,
        GameStateDto gameStateDto) {
        for (int i = 0; i < 3; i++) {
            if (userNumber.charAt(i) == nowComNumber.charAt(i)) {
                addStrike(gameStateDto);
            }
        }
    }

    private void addStrike(GameStateDto gameStateDto) {
        gameStateDto.addStrike();
    }
}
