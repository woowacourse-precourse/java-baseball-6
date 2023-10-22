package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Application {

    static void playGame() {
        List<Integer> computerNumber = getRandomNumber();
        while (true) {
            System.out.print("숫자를 입력해 주세요 : ");
            String userNumber = inputUserNumber();
            // result[2] = {ball 갯수, strike 갯수}
            int[] result = compareNumber(userNumber, computerNumber);
            if (!checkResult(result)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    static int[] compareNumber(String userNumber, List<Integer> computerNumber) {
        String[] number = userNumber.split("");
        int[] result = new int[2];

        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(number[i]);
            if (computerNumber.get(i) == num) {
                result[1]++;
            } else if (computerNumber.contains(num)) {
                result[0]++;
            }
        }
        return result;
    }

    static boolean checkResult(int[] result) {
        if (result[1] == 3) {
            System.out.println("3스트라이크");
            return false;
        } else if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        } else if (result[0] != 0 && result[1] != 0) {
            System.out.println(result[0] + "볼 " + result[1] + "스트라이크");
        } else if (result[0] == 0) {
            System.out.println(result[1] + "스트라이크");
        } else if (result[1] == 0) {
            System.out.println(result[0] + "볼");
        }
        return true;
    }

    static List<Integer> getRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    static String inputUserNumber() {
        String input = readLine();
        checkUserInput(input);
        return input;
    }

    static void checkUserInput(String input) {
        HashSet<Character> numberBucket = new HashSet<>();
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 3; i++) {
            if (input.charAt(i) < '1' || input.charAt(i) > '9') {
                throw new IllegalArgumentException();
            }
            if (numberBucket.contains(input.charAt(i))) {
                throw new IllegalArgumentException();
            } else {
                numberBucket.add(input.charAt(i));
            }
        }
    }

    static boolean replayInputCheck() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = readLine();
        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean replay = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (replay) {
            playGame();
            replay = replayInputCheck();
        }
    }
}
