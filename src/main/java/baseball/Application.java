package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int computer = generateRandomNumber();
        int user = 0;

        while(true) {
            Set<Integer> computerSet = new HashSet<>(parseDigits(computer));
            int strike = 0, ball = 0;

            try {
                user = getUserInput();
            } catch (Exception e) {
                throw new IllegalArgumentException(e.getMessage());
            }

            Set<Integer> userSet = new HashSet<>(parseDigits(user));

            if (checkIsNothing(computerSet, userSet)) {
                System.out.println("낫싱");
                continue;
            }

            strike = countStrikes(computer, user, computerSet, userSet);
            ball = countBalls(computerSet, userSet);

            if (strike == 3) {
                System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                try {
                    if (continuePlaying()) {
                        computer = generateRandomNumber();
                        continue;
                    }
                } catch (IOException ignored) {}
                break;
            }

            String consoleStrike = "", consoleBall = "";
            if (strike != 0) {
                consoleStrike = strike + "스트라이크";
            }

            if (ball != 0) {
                consoleBall = Integer.toString(ball) + "볼";
            }

            System.out.println(consoleBall + " " + consoleStrike);
        }
    }

    private static int generateRandomNumber() {
        int result = 0;

        // 중복 되지 않은 3개의 무작위 수 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        result = listToInt(computer);

        return result;
    }

    /**
     * number = 123
     * return = [1, 2, 3]
     */
    private static List<Integer> parseDigits(int number) {
        List<Integer> result = new ArrayList<>();

        int tmpNumber = number;

        while (tmpNumber > 0) {
            result.add(tmpNumber % 10);
            tmpNumber = tmpNumber / 10;
        }

        Collections.reverse(result);

        return result;
    }

    /**
     * list = [1, 2, 3]
     * return = 123
     */
    private static int listToInt(List<Integer> integers) {
        int result = 0;

        for (int i=0; i<integers.size(); i++) {
            result = result * 10 + integers.get(i);
        }

        return result;
    }

    private static int getUserInput() throws IOException {
        int result = 0;

        System.out.print("숫자를 입력해주세요 : ");
        String strInput = Console.readLine();

        // 사용자 입력이 3자리 이상의 입력인 경우 예외 던지기
        if (strInput.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }

        // 사용자 입력이 정수가 아닌 경우 예외 던지기
        try {
            result = Integer.parseInt(strInput);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("정수를 입력해주세요.");
        }

        List<Integer> integers = parseDigits(result);
        int first = integers.get(0), second = integers.get(1), third = integers.get(2);

        // 입력 받은 3개의 숫자가 중복 되는 경우 예외 던지기
        if (first == second || first == third || second == third) {
            throw new IllegalArgumentException("중복 되지 않은 3개의 숫자를 입력해주세요.");
        }

        // 1 ~ 9까지의 숫자를 입력하도록 예외 던지기
        for (Integer integer : integers) {
            if (integer == 0) {
                throw new IllegalArgumentException("1부터 9까지의 숫자를 입력해주세요.");
            }
        }

        return result;
    }

    private static boolean checkIsNothing(Set<Integer> leftSet, Set<Integer>rightSet) {
        Set<Integer> cloneSet = new HashSet<>(leftSet);
        cloneSet.retainAll(rightSet);

        return cloneSet.isEmpty();
    }

    /**
     *
     */
    private static int countStrikes(int leftNumber, int rightNumber, Set<Integer> leftSet, Set<Integer> rightSet) {
        int result = 0;

        List<Integer> leftIntegers = parseDigits(leftNumber);
        List<Integer> rightIntegers = parseDigits(rightNumber);

        for (int i=0; i<leftIntegers.size(); i++) {
            if (Objects.equals(leftIntegers.get(i), rightIntegers.get(i))) {
                leftSet.remove(leftIntegers.get(i));
                rightSet.remove(rightIntegers.get(i));
                result += 1;
            }
        }

        return result;
    }

    private static int countBalls(Set<Integer> leftSet, Set<Integer>rightSet) {
        Set<Integer> cloneSet = new HashSet<>(leftSet);
        cloneSet.retainAll(rightSet);

        return cloneSet.size();
    }

    private static boolean continuePlaying() throws IOException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String strInput = Console.readLine();;

        if ("1".equals(strInput)) {
            return true;
        }
        return false;
    }

}
