package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> testRandom = getRandomNumber();
        List<Integer> testInput= inputUserNumber();

        System.out.println(testRandom);
        System.out.println(testInput);
    }

    private static List<Integer> getRandomNumber() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int random = Randoms.pickNumberInRange(1, 9);
            if(!randomNumbers.contains(random)) {
                randomNumbers.add(random);
            }
        }
        return randomNumbers;
    }

    private static List<Integer> inputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        List<Integer> userNumbers = userInputToInteger(userInput);
        if (userNumbers.size() < 3 || userNumbers.size() > 3) {
            throw new IllegalArgumentException("세 자리의 숫자를 입력해주세요.");
        }
        for (int userNumber : userNumbers) {
            if(userNumber < 1 || userNumber > 9) {
                throw new IllegalArgumentException("범위 밖 숫자 입력입니다.");
            }
        }
        Set<Integer> deleteDuplicate = new HashSet<>(userNumbers);
        if (deleteDuplicate.size() != userNumbers.size()) {
            throw new IllegalArgumentException("중복되지 않은 수를 입력해주세요.");
        }
        return userNumbers;
    }

    private static List<Integer> userInputToInteger(String userInput) {  /// 1 3
        List<Integer> userNumbers = new ArrayList<>();
        for (String inputStr : userInput.split("")) {
            try {
                int userNumberInt = Integer.parseInt(inputStr);
                userNumbers.add(userNumberInt);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자만 입력 가능합니다.");
            }
        }
        return userNumbers;
    }
}
