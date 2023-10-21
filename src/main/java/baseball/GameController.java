package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class GameController {

    private static final String INPUT_ERROR_MESSAGE = "잘못된 입력값입니다.";
    private static final Pattern pattern = Pattern.compile("([1-9]{3,3})");

    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        Computer computer = new Computer();
        String computerNumber = computer.getComputerRandomNumber();

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
                break;
            }
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    // 스트라이크 볼 계산 test method
    String logicTest(String computerInput, String userInput) {

        String userInputNumber = userInput;

        if (userInputNumber.length() != 3) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }

        if (!pattern.matcher(userInputNumber).matches()) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }

        // 스트라이크 & 볼 계산
        int strike = 0;
        int ball = 0;

        List<String> randomNumberArr = Arrays.asList(computerInput.split(""));
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

        return result;
    }
}
