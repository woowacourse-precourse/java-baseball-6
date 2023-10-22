package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Application {

    static void playGame(){
        List<Integer> computerNumber = getRandomNumber();
        while (true) {
            System.out.print("숫자를 입력해 주세요 : ");
            String userNumber = inputUserNumber();
            // result[2] = {ball 갯수, strike 갯수}
            int[] result = compareNumber(userNumber, computerNumber);
        }

    }

    static int[] compareNumber(String userNumber, List<Integer> computerNumber) {
        String[] number = userNumber.split("");
        int[] countBall = new int[2];

        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(number[i]);
            if (computerNumber.get(i) == num) {
                countBall[1]++;
            } else if (computerNumber.contains(num)) {
                countBall[0]++;
            }
        }
        return countBall;
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
        playGame();
    }
}
