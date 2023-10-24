package baseball.utils;

import baseball.message.ConsoleMessage;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class GameUtils {
    private final static int NUMBER_COUNT = 3;

    public static GameStatus startGame() {
        System.out.println(ConsoleMessage.GAME_START_MESSAGE);

        int computer = generateRandomNumber();
        Set<Integer> computerSet = new HashSet<>(Utils.parseDigits(computer));

        while(true) {
            int user = 0, strike = 0, ball = 0;
            try {
                user = getUserInput();
            } catch (Exception e) {
                throw new IllegalArgumentException(e.getMessage());
            }

            Set<Integer> userSet = new HashSet<>(Utils.parseDigits(user));

            strike = countStrikes(computer, user, computerSet, userSet);
            ball = countBalls(computerSet, userSet);

            System.out.println(ConsoleMessage.reportMessage(strike, ball));

            if (strike == NUMBER_COUNT) {
                System.out.println(ConsoleMessage.CORRECT_ANSWER_MESSAGE);
                if (continuePlaying()) {
                    return GameStatus.RESTART;
                }
                return GameStatus.EXIT;
            }
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

        result = Utils.listToInt(computer);

        return result;
    }

    private static int getUserInput() {
        int result = 0;

        System.out.println(ConsoleMessage.USER_INPUT_MESSAGE);
        String strInput = Console.readLine();

        // 사용자 입력이 3자리 이상의 입력인 경우 예외 던지기
        if (strInput.length() != NUMBER_COUNT) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }

        // 사용자 입력이 정수가 아닌 경우 예외 던지기
        try {
            result = Integer.parseInt(strInput);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("정수를 입력해주세요.");
        }

        // 중복 되지 않는 3개의 숫자를 입력 받고 그 이외는 예외 던지기
        List<Integer> integers = Utils.parseDigits(result);
        boolean[] isUsed = new boolean[10];

        for (Integer integer : integers) {
            if (isUsed[integer]) {
                throw new IllegalArgumentException("중복 되지 않은 3개의 숫자를 입력해주세요.");
            }
            isUsed[integer] = true;
        }

        // 1 ~ 9까지의 숫자를 입력 받도록 하고 그 이외는 예외 던지기
        for (Integer integer : integers) {
            if (integer == 0) {
                throw new IllegalArgumentException("1부터 9까지의 숫자를 입력해주세요.");
            }
        }

        return result;
    }

    /**
     * 집합을 이용하려는 이유는 '볼'을 쉽게 카운팅하기 위해서인데 '스트라이크'인 숫자를 각각의 집합에서
     * 제거하고 난 후, 두 집합의 교집합을 구하면 '볼'을 쉽게 구할 수 있기 때문이다.
     * @param leftNumber : 3자리 숫자로 computer가 만든 임의의 숫자가 들어온다.
     * @param rightNumber : 3자리 숫자로 user가 입력한 임의의 숫자가 들어온다.
     * @param leftSet : computer가 만든 임의의 숫자 3개의 집합이다.
     * @param rightSet : user가 만든 임의의 숫자 3개의 집합이다.
     */
    private static int countStrikes(int leftNumber, int rightNumber, Set<Integer> leftSet, Set<Integer> rightSet) {
        int result = 0;

        List<Integer> leftIntegers = Utils.parseDigits(leftNumber);
        List<Integer> rightIntegers = Utils.parseDigits(rightNumber);

        for (int i=0; i<leftIntegers.size(); i++) {
            if (Objects.equals(leftIntegers.get(i), rightIntegers.get(i))) {
                leftSet.remove(leftIntegers.get(i));
                rightSet.remove(rightIntegers.get(i));
                result += 1;
            }
        }

        return result;
    }

    /**
     * 매개변수로 받은 두 집합의 교집합을 구하면 '볼'을 구할 수 있다.
     * @param leftSet
     * @param rightSet
     */
    private static int countBalls(Set<Integer> leftSet, Set<Integer>rightSet) {
        Set<Integer> cloneSet = new HashSet<>(leftSet);
        cloneSet.retainAll(rightSet);

        return cloneSet.size();
    }

    private static boolean continuePlaying() {
        System.out.println(ConsoleMessage.PLAY_AGAIN_MESSAGE);

        String strInput = Console.readLine();

        if("1".equals(strInput)) {
            return true;
        }

        if ("2".equals(strInput)) {
            return false;
        }

        throw new IllegalArgumentException("1 또는 2만 입력해주세요.");
    }
}
