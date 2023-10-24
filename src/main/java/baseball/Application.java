package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    final static int RESTART_GAME = 1;
    final static int MATCH_NUMBER = 3;

    public static void main(String[] args) {
        int restartCount = RESTART_GAME;
        List<Integer> randomNumber;
        List<Integer> inputNumber;

        try {
        } catch (IllegalArgumentException e) {
            return;
        }

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (restartCount == RESTART_GAME) {
            int strikeCount = 0; //게임 재시작 -> strikeCount 초기화 -> 26줄 회문 재실행
            randomNumber = generateRandomNumber();
            while (strikeCount != MATCH_NUMBER) {
                System.out.println("숫자를 입력해주세요 :");
                inputNumber = inputToList(Console.readLine());
                validateInputLength(inputNumber);
                validateInputSameNum(inputNumber);
                strikeCount = validateGameResult(randomNumber, inputNumber);
            }
            restartCount = outputGameRestart();
            validateInputRestart(restartCount);
        }
    }

    public static List<Integer> generateRandomNumber() {
        List<Integer> tempRandomNumber = new ArrayList<>();
        while (tempRandomNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!tempRandomNumber.contains(randomNumber)) {
                tempRandomNumber.add(randomNumber);
            }
        }
        return tempRandomNumber;
    }

    public static List<Integer> inputToList(String stringInput) {
        List<Integer> inputToList = new ArrayList<>();
        for (int i = 0; i < stringInput.length(); i++) {
            char inputSplitChar = stringInput.charAt(i);
            int inputSplitInt = Character.getNumericValue(inputSplitChar);
            inputToList.add(inputSplitInt);
        }

        return inputToList;
    }

    public static int validateGameResult(List<Integer> randomNumber, List<Integer> inputNumber) {
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < randomNumber.size(); i++) {
            if (randomNumber.get(i).equals(inputNumber.get(i))) { //==사용시 주소 동일성 비교로 부적절
                strikeCount++;
            } else if (randomNumber.contains(inputNumber.get(i))) {
                ballCount++;
            }
        }
        outputGameResult(strikeCount, ballCount);
        return strikeCount;
    }

    public static void outputGameResult(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        } else if (strikeCount == 0) {
            System.out.printf("%d볼\n", ballCount);
        } else if (ballCount == 0) {
            System.out.printf("%d스트라이크\n", strikeCount);
        } else {
            System.out.printf("%d볼 %d스트라이크\n", ballCount, strikeCount);
        }
    }

    public static int outputGameRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(Console.readLine());
    }

    public static void validateInputLength(List<Integer> inputNumber) {
        if (inputNumber.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateInputRestart(int restartCount) {
        if (restartCount != 1 && restartCount != 2) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateInputSameNum(List<Integer> inputNumber) {
        if (inputNumber.get(0).equals(inputNumber.get(1))) {
            throw new IllegalArgumentException();
        }
        if (inputNumber.get(1).equals(inputNumber.get(2))) {
            throw new IllegalArgumentException();
        }
        if (inputNumber.get(2).equals(inputNumber.get(0))) {
            throw new IllegalArgumentException();
        }
    }
}
