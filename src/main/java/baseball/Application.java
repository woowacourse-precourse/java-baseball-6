package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public final static Integer NUMBER_DIGIT = 3;
    public static void main(String[] args) {
        // 게임 종료
        boolean endGame = false;

        while(!endGame) {
            System.out.println("숫자 야구 게임을 시작합니다.");

            // 컴퓨터
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            boolean UntilMatch = false;
            while(!UntilMatch) {
                // 맞출때까지 숫자 입력
                System.out.println("숫자를 입력해주세요 : ");

                List<Integer> numberList = validateInputNumber(readLine());

                int ball = 0;
                int strike = 0;
                for (int i = 0; i < NUMBER_DIGIT; i++) {
                    boolean isContain = computer.contains(numberList.get(i));
                    if (Boolean.TRUE == isContain) {
                        ++ball;
                    }
                }

                if (ball == 0) {
                    System.out.println("낫싱");
                } else {
                    for (int i = 0; i < NUMBER_DIGIT; i++) {
                        boolean isMatch = computer.get(i).equals(numberList.get(i));
                        if (Boolean.TRUE == isMatch) {
                            --ball;
                            ++strike;
                        }
                    }
                }

                System.out.println((ball > 0 ? ball + "볼 " : "") + (strike > 0 ?  strike + "스트라이크" : ""));

                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    UntilMatch = Boolean.TRUE;
                    endGame = isRestart(readLine());
                }
            }
        }
    }

    private static Boolean isRestart(String end) {
        if (end.length() != 1) {
            throw new IllegalArgumentException("number should be 1 character.");
        }
        int endNumber = java.lang.Integer.parseInt(end);

        if (endNumber > 2 || endNumber == 0) {
            throw new IllegalArgumentException("number should be 1 or 2.");
        }
        return endNumber == 2;
    }

    private static List<Integer> validateInputNumber(String numberWord) {
        if (numberWord.length() != 3) {
            throw new IllegalArgumentException("numbers should be 3 characters");
        }

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < NUMBER_DIGIT; i++) {
            int oneNumber = Character.getNumericValue(numberWord.charAt(i));

            if (oneNumber < 1 || oneNumber > 9) {
                throw new IllegalArgumentException("numbers should be between 1 to 9");
            }
            if (numbers.contains(oneNumber)) {
                throw new IllegalArgumentException("duplicate numbers are not allowed");
            }
            numbers.add(oneNumber);
        }
        return numbers;
    }
}
