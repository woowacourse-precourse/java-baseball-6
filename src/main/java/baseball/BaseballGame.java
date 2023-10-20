package baseball;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class BaseballGame {
    private static final int BASEBALL_NUMBER_SIZE = 3;
    public static List<Integer> createComputerNumbers() {
        return pickUniqueNumbersInRange(1,9, BASEBALL_NUMBER_SIZE);
    }

    //사용자로부터 입력 받은 숫자를 userNumber에 저장
    public static List<Integer> createUserNumbers() {
        List<Integer> userNumbers = new ArrayList<>();
        String userInput = readLine();
        for (int i=0;i<userInput.length();i++) {
            String str = userInput.substring(i, i+1);
            userNumbers.add(Integer.parseInt(str));
        }
        validateUserNumber(userNumbers);
        return userNumbers;
    }


    // userNumber 검증
    private static void validateUserNumber(List<Integer> userNumbers) {
        int randomUserNumber = pickNumberInList(userNumbers);
        if (randomUserNumber < 1) {
            throw new IllegalArgumentException("각 숫자는 1부터 9까지만 입력해주세요.");
        }
        if (userNumbers.size() != BASEBALL_NUMBER_SIZE) {
            throw new IllegalArgumentException("숫자 3개만 입력해주세요.");
        }
        Set<Integer> userNumbersSet = new HashSet<>(userNumbers);
        if (userNumbersSet.size() != userNumbers.size()) {
            throw new IllegalArgumentException("서로 다른 숫자 3개를 입력해주세요.");
        }
    }

    //값이 List에 포함되있는지 확인하는 메서드
    private static boolean contains(List<Integer> numbers, int value) {
        return numbers.stream()
                .anyMatch(number -> number.equals(value));
    }

    //컴퓨터숫자와 사용자숫자가 일치하면 1, 아니면 0 반환하는 메서드
    private static int correct(int computerNumber, int userNumber) {
        if (computerNumber == userNumber) {
            return 1;
        }
        return 0;
    }

    //contains 개수 세는 메서드
    private static int countContains(List<Integer> computerNumbers, List<Integer> userNumbers) {
        return Optional.of(userNumbers.stream()
                .filter(userNumber -> contains(computerNumbers, userNumber))
                .count()).orElse(0L).intValue();
    }

    private static int countStrike(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int count = 0;
        for (int i=0;i<BASEBALL_NUMBER_SIZE;i++) {
            count += correct(computerNumbers.get(i), userNumbers.get(i));
        }
        return count;
    }

    private static int countBall(List<Integer> computerNumbers, List<Integer> userNumbers) {
        return countContains(computerNumbers, userNumbers) - countStrike(computerNumbers, userNumbers);
    }

    //게임 결과 출력하기
    public static void gameScore() {
        List<Integer> computerNumbers = createComputerNumbers();
        System.out.println(computerNumbers);
        List<Integer> userNumbers = createUserNumbers();
        int countBall = countBall(computerNumbers, userNumbers);
        int countStrike = countStrike(computerNumbers, userNumbers);

        System.out.println(countBall);
        System.out.println(countStrike);
    }
}
