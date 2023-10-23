package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 컴퓨터가 가지고 있는 숫자 세 개
        List<Integer> computerNums = new ArrayList<>();

        boolean userPlay = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (userPlay) {
            // 컴퓨터가 중복되지 않는 랜덤 숫자 생성
            while (computerNums.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computerNums.contains(randomNumber)) {
                    computerNums.add(randomNumber);
                }
            }

            // 사용자 입력 받기
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();

            // 입력받은 값 예외 처리
            if (userInput.length() != 3) {
                throw new IllegalArgumentException("숫자 세 개를 입력해주세요.");
            } else if (userInput.charAt(0) == userInput.charAt(1)) {
                throw new IllegalArgumentException("중복되지 않은 숫자를 입력해주세요.");
            } else if (userInput.charAt(0) == userInput.charAt(2)) {
                throw new IllegalArgumentException("중복되지 않은 숫자를 입력해주세요.");
            } else if (userInput.charAt(1) == userInput.charAt(2)) {
                throw new IllegalArgumentException("중복되지 않은 숫자를 입력해주세요.");
            } else if (!Character.isDigit(userInput.charAt(0))) {
                throw new IllegalArgumentException("숫자를 입력해주세요.");
            } else if (!Character.isDigit(userInput.charAt(1))) {
                throw new IllegalArgumentException("숫자를 입력해주세요.");
            } else if (!Character.isDigit(userInput.charAt(2))) {
                throw new IllegalArgumentException("숫자를 입력해주세요.");
            }

            // String을 Integer로 변환하기
            List<Integer> userNums = new ArrayList<>();
            for (int i = 0; i < userInput.length(); i++) {
                userNums.add(i, Character.getNumericValue(userInput.charAt(i)));
            }

            int strike = 0;
            int ball = 0;

            for (int i = 0; i < 3; i++) {
                if (userNums.get(i) == computerNums.get(i)) {
                    ++strike;
                } else if (computerNums.contains(userNums.get(i))) {
                    ++ball;
                }
            }
            if (ball > 0) {
                System.out.print(ball + "볼 ");
            }
            if (strike > 0) {
                System.out.println(strike + "스트라이크");
            }
            if (ball + strike < 1) {
                System.out.println("낫싱");
            }
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                userInput = Console.readLine();
                if (userInput.length() != 1) {
                    throw new IllegalArgumentException("0 또는 1을 입력해주세요.");
                } else if (!Character.isDigit(userInput.charAt(0))) {
                    throw new IllegalArgumentException("숫자를 입력해주세요.");
                }
                computerNums.clear();
                if (userInput.equals("2")) {
                    userPlay = false;
                }
            }
        }
    }
}
