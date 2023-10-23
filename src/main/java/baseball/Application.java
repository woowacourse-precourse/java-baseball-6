package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static String convertInputError() {
        String inputString;
        try {
            inputString = readLine();
        } catch (Throwable e) {
            throw new IllegalArgumentException();
        }
        return inputString;
    }

    public static void findInputNumberError(String inputNum) {
        if (inputNum.length() != 3) {
            throw new IllegalArgumentException();
        }

        boolean[] duplicateBall = new boolean[10];
        for (int i = 0; i < 3; i++) {
            int num = inputNum.charAt(i) - '0';
            if (num < 1 || num > 9 || duplicateBall[num]) {
                throw new IllegalArgumentException();
            }
            duplicateBall[num] = true;
        }
    }

    public static boolean findBaseballNumber(List<Integer> answerNum, String inputNum) {
        boolean[] findBall = new boolean[10];
        for (int i = 0; i < 3; i++) {
            findBall[answerNum.get(i)] = true;
        }

        int ballCount = 0;
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            int num = inputNum.charAt(i) - '0';
            if (num == answerNum.get(i)) {
                strikeCount++;
            } else if (findBall[num]) {
                ballCount++;
            }
        }

        if (ballCount == 0 && strikeCount == 0) {
            System.out.print("낫싱");
        }
        if (ballCount != 0) {
            System.out.print(ballCount + "볼");
        }
        if (ballCount != 0 && strikeCount != 0) {
            System.out.print(" ");
        }
        if (strikeCount != 0) {
            System.out.print(strikeCount + "스트라이크");
        }
        System.out.print("\n");

        return strikeCount == 3;
    }

    public static void playBaseballGame() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String inputNumber = convertInputError();
            findInputNumberError(inputNumber);

            if (findBaseballNumber(computer, inputNumber)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            playBaseballGame();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String replayGame = convertInputError();
            if (replayGame.equals("2")) {
                break;
            } else if (!replayGame.equals("1")) {
                throw new IllegalArgumentException();
            }
        }
    }
}