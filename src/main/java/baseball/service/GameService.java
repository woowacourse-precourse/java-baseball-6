package baseball.service;

import baseball.domain.Round;
import baseball.domain.User;
import baseball.util.InputUtil;
import baseball.util.PrintUtil;
import java.util.List;

public class GameService {
    private Round round;
    private User computer;
    private User user;

    public void startGame() {
        gameInit();
        while (true) {
            round = new Round();
            PrintUtil.printInputNumber();
            user.setUserNumber(InputUtil.getUserInputs());
            checkBallStrike(computer.getUserNumber(), user.getUserNumber());
            PrintUtil.printResult(round.getBall(), round.getStrike());
            if (round.getStrike() == 3) {
                PrintUtil.printEndMessage();
                break;
            }
        }
        if (restartGame()) {
            startGame();
        }

    }

    private boolean restartGame() {
        PrintUtil.printRestartMessage();
        return switch (InputUtil.getUserInput()) {
            case "1" -> true;
            case "2" -> false;
            default -> throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        };
    }

    private void gameInit() {
        PrintUtil.printStartMessage();
        computer = new User(InputUtil.getRandomNumberList());
        user = new User();
    }

    private void checkBallStrike(List<String> computerList, List<String> userList) {
        userList.forEach(u -> getBallOrStrike(computerList, u, user.getUserNumber().indexOf(u)));
    }

    private void getBallOrStrike(List<String> computerList, String input, int index) {
        if (computerList.contains(input)) {
            if (computerList.indexOf(input) == index) {
                round.incStrike();
            } else {
                round.incBall();
            }
        }
    }

}
