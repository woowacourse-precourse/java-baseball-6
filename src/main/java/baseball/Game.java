package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int NUM_OF_DIGITS = 3;


    public void start() {
        // 사용자가 2를 입력하면 종료 or 1을 입력하면 게임 지속
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            int randomNumber = generateRandomNumber();

            playGame(randomNumber);
        }
    }

    private int generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUM_OF_DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        int randomNumber = 0;
        for (int i = 0; i < computer.size(); i++) {
            randomNumber += (computer.get(i) * (int) Math.pow(10, computer.size() - i - 1));
        }
        return randomNumber;
    }

    private void playGame(int randomNumber) {
        boolean isAnswerCorrect = false;
        while (!isAnswerCorrect) {
            String inputNumber = Console.readLine();
            if (!inputNumber.matches("\\d{" + NUM_OF_DIGITS + "}")) {
                throw new IllegalArgumentException();
            }
            if (compareNumbers(inputNumber, randomNumber)) { // 숫자 비교 메서드, 3스트라이크이면 true를 return
                isAnswerCorrect = true;
            }
        }
    }

    private boolean compareNumbers(String inputNumber, int randomNumber) {
        String randomString = Integer.toString(randomNumber);
        int ballCnt = 0;
        int strikeCnt = 0;
        for (int i = 0; i < randomString.length(); i++) {
            char randomChar = randomString.charAt(i);
            char inputChar = inputNumber.charAt(i);

            if (randomChar == inputChar) {
                strikeCnt++;
            } else if (inputNumber.contains(String.valueOf(randomChar))) {
                ballCnt++;
            }
        }

        printGameResult(ballCnt, strikeCnt);

        return strikeCnt == 3; // 3스트라이크이면 true를 return
    }

    private void printGameResult(int ballCnt, int strikeCnt) {
        String message = "";
        if (ballCnt > 0 && strikeCnt > 0) {
            message = ballCnt + "볼 " + strikeCnt + "스트라이크";
        } else if (ballCnt > 0) {
            message = ballCnt + "볼";
        } else if (strikeCnt > 0) {
            message = strikeCnt + "스트라이크";
        } else {
            message = "낫싱";
        }
        System.out.println(message);
    }
}
