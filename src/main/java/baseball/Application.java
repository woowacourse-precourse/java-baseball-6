package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    static final int MAX_COUNT = 3;

    public static void main(String[] args) {

        baseball.Application game = new baseball.Application();

        System.out.println("숫자 야구 게임을 시작합니다.");
        game.playGame();

    }

    public void playGame() {

        List<Integer> computerNumber = makeComputerNumber();

        while (true) {

            System.out.print("숫자를 입력해주세요 : ");
            String writeNumber = readLine();
            checkInputValue(writeNumber);

            String text = resultCount(writeNumber, computerNumber);
            System.out.println(text);

            if (text.equals(MAX_COUNT + "스트라이크")) {
                startNewGame();
                break;
            }
        }
    }

    private static List<Integer> makeComputerNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < MAX_COUNT) {
            int computerNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(computerNumber)) {
                computer.add(computerNumber);
            }
        }

        return computer;
    }

    static void checkInputValue(String input) {
        if (!isEqualsMaxLength(input)
                || !isAllInteger(input)
                || isContainZero(input)
                || isDuplicate(input)) {
            throw new IllegalArgumentException();
        }
    }

    static boolean isEqualsMaxLength(String input) {
        return input.length() == MAX_COUNT;
    }

    static boolean isAllInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    static boolean isContainZero(String input) {
        String[] inputArr = input.split("");
        for (String num : inputArr) {
            if ("0".equals(num)) {
                return true;
            }
        }
        return false;
    }

    static boolean isDuplicate(String input) {
        String[] inputArr = input.split("");
        Set<String> set = new HashSet<>(Arrays.asList(inputArr));
        return set.size() != MAX_COUNT;
    }

    public static int countStrikes(List<Integer> number, List<Integer> computer) {
        int strike = 0;
        for (int i = 0; i < MAX_COUNT; i++) {
            if (number.get(i).equals(computer.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public static int countBall(List<Integer> number, List<Integer> computer) {
        int balls = 0;
        for (int i = 0; i < MAX_COUNT; i++) {
            int matchIndex = number.indexOf(computer.get(i));
            if (matchIndex != i && matchIndex != -1) {
                balls++;
            }
        }
        return balls;
    }

    private static List<Integer> changeArr(String number) {

        String[] nArr = number.split("");

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < MAX_COUNT; i++) {
            numbers.add(Integer.parseInt(nArr[i]));
        }
        return numbers;

    }

    private static String resultCount(String number, List<Integer> computerNumber) {

        List<Integer> n = changeArr(number);

        int strike = countStrikes(n, computerNumber);
        int ball = countBall(n, computerNumber);
        return outText(strike, ball);

    }

    private static String outText(int strike, int ball) {

        if (strike == 0 && ball == 0) {
            return "낫싱";
        } else if (ball > 0 && strike == 0) {
            return ball + "볼";
        } else if (strike > 0 && ball == 0) {
            return strike + "스트라이크";
        }

        return ball + "볼 " + strike + "스트라이크";
    }

    private static void startNewGame() {

        System.out.println(MAX_COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputNumber = readLine();

        if (inputNumber.equals("1")) {
            baseball.Application app = new baseball.Application();
            app.playGame();
        }

    }
}
