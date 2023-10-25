package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameController {

    private final GameData gameData;
    private final OutputView view;

    public BaseballGameController(GameData gameData, OutputView view) {
        this.gameData = gameData;
        this.view = view;
    }

    public void playGame() {
        view.printStart();
        initializeGameData();
        while (!isGameFinished()) {
            playRound();
        }
        view.printEndgame();
    }

    private void playRound() {
        getPlayerInput();
        evaluatePlayerInput();
        displayResult();
    }

    private void initializeGameData() {
        generateComputerNumbers();
        gameData.setStrikeCount(0);
        gameData.setBallCount(0);
    }

    private boolean isGameFinished() {
        return gameData.getStrikeCount() == 3;
    }

    private void generateComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        gameData.setComputerNumbers(computerNumbers);
    }

    private void getPlayerInput() {
        view.printRequirePlayerInput();
        List<Integer> playerInput = new ArrayList<>();
        String input = Console.readLine();
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리의 숫자가 아닙니다!");
        }
        for (char c : input.toCharArray()) {
            playerInput.add(Character.getNumericValue(c));
        }
        gameData.setPlayerNumbers(playerInput);
    }

    private void evaluatePlayerInput() {
        countStrikesAndBalls();
    }

    private void countStrikesAndBalls() {
        List<Integer> computerNumbers = gameData.getComputerNumbers();
        List<Integer> playerNumbers = gameData.getPlayerNumbers();
        int strikes = 0;
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (playerNumbers.get(i).equals(computerNumbers.get(i))) {
                strikes++;
            } else if (computerNumbers.contains(playerNumbers.get(i))) {
                balls++;
            }
        }
        gameData.setStrikeCount(strikes);
        gameData.setBallCount(balls);
    }

    private void displayResult() {
        int strikes = gameData.getStrikeCount();
        int balls = gameData.getBallCount();
        if (strikes > 0 && balls == 0) {
            view.printStrikeOnlyResult(strikes);
        } else if (balls > 0 && strikes == 0) {
            view.printBallOnlyResult(balls);
        } else if (balls > 0 && strikes > 0) {
            view.printBallAndStrikeResult(strikes, balls);
        } else {
            view.printNothingResult();
        }
    }
}