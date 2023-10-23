package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class GameController {

    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String SUCCESS_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INPUT_ERROR_MESSAGE = "잘못된 입력값 입니다.";
    private static final Pattern pattern = Pattern.compile("([1-9]{3,3})");
    private String computerNumber;
    private Computer computer = new Computer();

    public void play() {

        System.out.println(START_GAME_MESSAGE);
        startGame();

        // 유저 입력
        User user = new User();

        while (true) {
            user.setUserInputNumber();
            String userInputNumber = user.userInputNumber;

            if (userInputNumber.length() != 3) {
                throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
            }

            if (!pattern.matcher(userInputNumber).matches()) {
                throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
            }

            // 스트라이크 & 볼 계산
            int strike = 0;
            int ball = 0;

            List<String> randomNumberArr = Arrays.asList(computerNumber.split(""));
            List<String> userNumberArr = Arrays.asList(userInputNumber.split(""));

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

    private void startGame() {
        computer.makeComputerRandomNumber();
        computerNumber = computer.computerRandomNumber;
    }
}
