package baseball;

import baseball.utils.GameState;
import baseball.utils.Utils;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {

    private final static int NUMBER_COUNT = 3;

    public static void main(String[] args) {
    }

    public static GameState startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        return GameState.EXIT;
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

        System.out.println("숫자를 입력해 주세요");
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
    private static int countBalls(Set<Integer> leftSet, Set<Integer>rightSet) {
        Set<Integer> cloneSet = new HashSet<>(leftSet);
        cloneSet.retainAll(rightSet);

        return cloneSet.size();
    }


}
