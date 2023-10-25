package baseball;

import java.util.List;

public class BaseBallGameManager {
    private final User user = new User();
    private final Computer computer = new Computer();
    private final BaseballGame baseballGame = new BaseballGame();
    private boolean roundResult = false;

    public void startGame() {
        printGameStart();
        resetRound();
        while (true) {
            boolean isGameOver = true;
            playRound();
            if (roundResult) {
                isGameOver = baseballGame.gameOver();
            }
            if (!roundResult) {
                continue;
            }
            if (isGameOver) {
                resetRound();
            }
            if (!isGameOver) {
                break;
            }
        }
    }

    private void playRound() {
        userSelectNumber();

        List<Integer> strikeZoneResult = getStrikeZoneResult();
        boolean isRoundOver = printRoundResult(strikeZoneResult);
        if (!isRoundOver) {
            return;
        }
        if (isRoundOver) {
            roundResult = true;
        }
    }

    public void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void userSelectNumber() {
        user.userSelect();
    }

    public List<Integer> getStrikeZoneResult() {
        return baseballGame.strikeZone(user, computer);
    }

    public boolean printRoundResult(List<Integer> strikeZoneResult) {
        return baseballGame.printGameResult(strikeZoneResult);
    }

    public void resetRound() {
        computer.randomComputerPick();
    }
}
