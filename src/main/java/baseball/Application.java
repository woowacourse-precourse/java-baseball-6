package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    // 정답 생성 메서드
    public static List<Integer> randomNumbers() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    // 사용자 숫자 입력 메서드
    public static List<Integer> choiceNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        List<Integer> userNumber = new ArrayList<>();
        // 입력값이 세자리가 아닐때 예외 처리
        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < userInput.length(); i++) {
            char inputChar = userInput.charAt(i);
            int c = Character.getNumericValue(inputChar);

            userNumber.add(c);
            // 입력값이 0이나 숫자가 아닐 때 예외 처리
            if (c < 1 || c > 9) {
                throw new IllegalArgumentException();
            }
            String cStr = String.valueOf(c);
            // 입력값 중복 예외 처리
            if (userInput.indexOf(cStr) != userInput.lastIndexOf(cStr)) {
                throw new IllegalArgumentException();
            }
        }
        return userNumber;
    }

    // 스트라이크 계산 메서드
    public static int checkStrike(List<Integer> userNumber, List<Integer> computerNumber) {
        int strike = 0;
        for (int i = 0; i < userNumber.size(); i++) {
            if (userNumber.get(i).equals(computerNumber.get(i))) {
                strike += 1;
            }
        }
        return strike;
    }

    // 볼 계산 메서드
    public static int checkBall(List<Integer> userNumber, List<Integer> computerNumber) {
        int ball = 0;
        for (int i = 0; i < userNumber.size(); i++) {
            if (!userNumber.get(i).equals(computerNumber.get(i)) && computerNumber.contains(userNumber.get(i))) {
                ball += 1;
            }
        }
        return ball;
    }

    // 결과 출력 메서드
    public static void grading() {
        List<Integer> computerNumber = randomNumbers();
        int ball = 0;
        int strike = 0;

        do {
            List<Integer> userNumber = choiceNumbers();
            ball = checkBall(userNumber, computerNumber);
            strike = checkStrike(userNumber, computerNumber);

            if (ball != 0 && strike != 0) {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            } else if (ball != 0 && strike == 0) {
                System.out.println(ball + "볼");
            } else if (ball == 0 && strike != 0) {
                System.out.println(strike + "스트라이크");
            } else if (ball == 0 && strike == 0) {
                System.out.println("낫싱");
            }
        } while (strike != 3);
    }

    // 메인 메서드
    public static void main(String[] args) {
        String retryInput = "";
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            grading();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            retryInput = Console.readLine();
            // 입력값이 1 혹은 2가 아닐 때 예외 처리
            if (!retryInput.equals("1") && !retryInput.equals("2")) {
                throw new IllegalArgumentException();
            }
        } while (retryInput.equals("1"));
    }
}