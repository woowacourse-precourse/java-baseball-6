package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class GameController {

    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String SUCCESS_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INPUT_ERROR_MESSAGE = "잘못된 입력값 입니다.";
    private final Computer computer = new Computer();
    private final User user = new User();
    private String computerNumber;
    private String userNumber;

    public void play() {

        System.out.println(START_GAME_MESSAGE);
        startGame();

        while (true) {
            getUserNumber();

            // 스트라이크 & 볼 계산
            int strike = 0;
            int ball = 0;

            List<String> randomNumberArr = Arrays.asList(computerNumber.split(""));
            List<String> userNumberArr = Arrays.asList(userNumber.split(""));

            for (int i = 0; i < 3; i++) {
                String checkNumber = userNumberArr.get(i);

                if (randomNumberArr.get(i).equals(checkNumber)) {
                    strike++;
                } else if (randomNumberArr.contains(checkNumber)) {
                    ball++;
                }
            }

            String result;
            if (ball == 0 && strike == 0) {
                result = "낫싱";
            } else if (ball == 0 && strike != 0) {
                result = strike + "스트라이크";
            } else if (ball != 0 && strike == 0) {
                result = ball + "볼";
            } else {
                result = ball + "볼" + " " + strike + "스트라이크";
            }
            System.out.println(result);

            if (result.equals("3스트라이크")) {
                System.out.println(SUCCESS_GAME_MESSAGE);
                System.out.println(RESTART_GAME_MESSAGE);
                String restart = Console.readLine();

                if (restart.equals("1")) {
                    startGame();
                } else if (restart.equals("2")) {
                    break;
                } else {
                    throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
                }
            }
        }

    }

    private void getUserNumber() {
        user.setUserInputNumber();
        userNumber = user.getUserInputNumber();
    }

    private void startGame() {
        computer.makeComputerRandomNumber();
        computerNumber = computer.computerRandomNumber;
    }
}
