package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    //상수 정의
    private static final int NUMBER_OF_DIGITS = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    public static void main(String[] args) {
        boolean playAgain = true;

        while (playAgain) {
            List<Integer> computerNumbers = randomNums();

            System.out.println("숫자 야구 게임을 시작합니다.");

            while (true) {
                List<Integer> userNumbers = getUserNumbers();
                List<Integer> result = compareNumbers(computerNumbers, userNumbers);

                if (result.get(0) == 3) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                } else {
                    System.out.println(resultToString(result));
                }
            }

            playAgain = restartOrEnd();
        }
    }

    //컴퓨터가 생성한 난수를 반환
    private static List<Integer> randomNums(){
        List<Integer> randomNums = new ArrayList<>();
        while (randomNums.size() < NUMBER_OF_DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNums.contains(randomNumber)) {
                randomNums.add(randomNumber);
            }
        }
        return randomNums;
    }

    //사용자로부터 입력을 받아 숫자 리스트로 반환
    private static List<Integer> getUserNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();

        List<Integer> numbers = parseUserInput(inputNumber);
        validateUserInput(numbers);

        return numbers;
    }

    //사용자 입력을 분석하여 숫자 리스트로 반환
    private static List<Integer> parseUserInput(String input) {
        String[] inputNumberArray = input.split("");
        List<Integer> numbers = new ArrayList<>();

        try {
            for (String digit : inputNumberArray) {
                int number = Integer.parseInt(digit);
                numbers.add(number);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 문자를 입력했습니다.");
        }

        return numbers;
    }

    //사용자 입력 유효성 검사
    private static void validateUserInput(List<Integer> numbers) {

        if (numbers.size() != NUMBER_OF_DIGITS) {
            throw new IllegalArgumentException("3자리의 수가 아닙니다.");
        }

        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException("1부터 9까지의 수가 아닙니다.");
            }
        }

        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException("중복된 숫자를 입력했습니다.");
        }
    }

    //중복 숫자 검사
    private static boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        return set.size() < numbers.size();
    }

    //사용자 숫자와 컴퓨터 숫자 비교
    private static List<Integer> compareNumbers(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < NUMBER_OF_DIGITS; i++) {
            int computerNumber = computerNumbers.get(i);
            int userNumber = userNumbers.get(i);

            if (computerNumber == userNumber) {
                strikes++;
            } else if (userNumbers.contains(computerNumber)) {
                balls++;
            }
        }

        return List.of(strikes, balls);
    }

    //결과 메시지 생성
    private static String resultToString(List<Integer> result) {
        int strikes = result.get(0);
        int balls = result.get(1);

        StringBuilder sb = new StringBuilder();

        if (balls > 0) {
            sb.append(balls).append("볼");
        }

        if (strikes > 0) {
            if (balls > 0) {
                sb.append(" ");
            }
            sb.append(strikes).append("스트라이크");
        }

        if (sb.length() == 0) {
            sb.append("낫싱");
        }

        return sb.toString();
    }

    //게임 재시작 여부 확인
    private static boolean restartOrEnd() {
        System.out.println("게임을 재시작하려면 1, 종료하려면 2를 입력하세요.");

        while (true) {
            int userInput = getUserChoice();
            if (userInput == 1) {
                return true;
            } else if (userInput == 2) {
                return false;
            }else throw new IllegalArgumentException("1 또는 2를 입력하지않았습니다.");
        }
    }

    //사용자 선택 입력 처리
    private static int getUserChoice() {
        try {
            int userChoice = Integer.parseInt(Console.readLine());
            return userChoice;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 문자를 입력했습니다.");
        }
    }
}
