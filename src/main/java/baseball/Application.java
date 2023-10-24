package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean newGame;
        do {
            newGame = new GameController().playGame();
        } while (newGame);
    }
}

class GameController {
    public boolean playGame() {
        List<Integer> comList = RandomNumberGenerator.generateRandomNumberList();
        while (true) {
            System.out.print("숫자를 입력해주세요: ");
            int ball = 0;
            int strike = 0;
            int num = InputHandler.getInputNumber();
            checkValid(num);
            List<Integer> myList = NumberUtil.getInts(num);
            for (int i = 0; i < 3; i++) {
                if (!Objects.equals(myList.get(i), comList.get(i))) {
                    boolean contains = comList.contains(myList.get(i));
                    if (contains) {
                        ball++;
                    }
                }
                if (Objects.equals(myList.get(i), comList.get(i))) {
                    strike++;
                }
            }
            GameOutput.printResult(ball, strike);
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return InputHandler.askForNewGame();
            }
        }
    }

    private static void checkValid(int num) {
        if (num < 100 || num > 999) {
            throw new IllegalArgumentException("입력 범위를 초과했습니다.");
        }
    }
}

class RandomNumberGenerator {
    public static List<Integer> generateRandomNumberList() {
        List<Integer> comList = new ArrayList<>();
        while (comList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!comList.contains(randomNumber)) {
                comList.add(randomNumber);
            }
        }
        return comList;
    }
}

class InputHandler {
    public static int getInputNumber() {
        return Integer.parseInt(Console.readLine());
    }

    public static boolean askForNewGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int value = getInputNumber();
        if (value == 1) {
            return true;
        } else if (value == 2) {
            return false;
        } else {
            throw new IllegalArgumentException("올바른 입력이 아닙니다.");
        }
    }
}

class GameOutput {
    public static void printResult(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else {
            if (ball != 0) {
                System.out.print(ball + "볼 ");
            }
            if (strike != 0) {
                System.out.print(strike + "스트라이크");
            }
            System.out.println();
        }
    }
}

class NumberUtil {
    public static List<Integer> getInts(int num) {
        List<Integer> myList = new ArrayList<>();
        myList.add(num / 100);
        myList.add((num / 10) % 10);
        myList.add(num % 10);
        return myList;
    }
}


