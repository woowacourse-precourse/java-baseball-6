package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int NUM_OF_DIGITS = 3;
    private static final int NEW_GAME = 1;
    private static final int QUIT = 2;

    public void start() {
        // 사용자가 2를 입력하면 종료 or 1을 입력하면 게임 지속
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            int randomNumber = generateRandomNumber();

            playGame(randomNumber);

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            int choice = Integer.parseInt(Console.readLine());
            if (choice == QUIT) {
                break; // 게임 종료
            }
            if (choice != NEW_GAME) {
                throw new IllegalArgumentException();
            }
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
        for (int digit : computer) {
            randomNumber = randomNumber * 10 + digit;
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
            if (compareNumbers(inputNumber, randomNumber)) {
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

        return strikeCnt == NUM_OF_DIGITS;
    }

    private void printGameResult(int ballCnt, int strikeCnt) {
        StringBuilder message = new StringBuilder();

        if (ballCnt > 0) {
            message.append(ballCnt).append("볼 ");
        }
        if (strikeCnt > 0) {
            message.append(strikeCnt).append("스트라이크");
        }
        if (ballCnt == 0 && strikeCnt == 0) {
            message.append("낫싱");
        }

        System.out.println(message.toString());
    }

}
