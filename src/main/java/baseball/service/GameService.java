package baseball.service;

import java.util.List;

public class GameService {
    private int[] gameResult;

    public GameService() {
        this.gameResult = new int[3];
    }

    public int[] getGameResult(List<Integer> randomNumbers, String inputNumbers) {
        int[] playersNumbers = convertToArray(inputNumbers);
        return checkGameResultOf(randomNumbers, playersNumbers);
    }

    private int[] checkGameResultOf(List<Integer> randomNumbers, int[] playersNumbers) {
        int strike = 0;
        int ball = 0;
        int nothing = 0;

        for (int i = 0; i < 3; i++) {
            if (randomNumbers.get(i).equals(playersNumbers[i])) {
                gameResult[0] = ++strike;
                continue;
            }
            if (randomNumbers.contains(playersNumbers[i])) {
                gameResult[1] = ++ball;
            }
        }
        if (gameResult[0] + gameResult[1] == 0) {
            gameResult[2] = ++nothing;
        }

        return gameResult;
    }

    private int[] convertToArray(String inputNumbers) {
        int[] playersNumbers = new int[3];

        for (int i = 0; i < 3; i++) {
            playersNumbers[i] = Integer.parseInt(String.valueOf(inputNumbers.charAt(i)));
        }

        return playersNumbers;
    }
}
