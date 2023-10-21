package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 1. 숫자 랜덤 생성
        String randomValue = generateNumber();

        while (true) {
            // 2. 사용자 입력 및 예외 검증
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();
            validateUserInput(userInput);

            // 3. 사용자 입력과 랜덤 숫자 비교
            String result = compare(randomValue, userInput);

            // 4. 비교 결과 출력
            System.out.println(result);

            if (result.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

                // 5. 종료 조건 입력 및 실행
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int choice = Integer.parseInt(Console.readLine());
                if (choice != 1 && choice != 2) {
                    throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
                }

                if (choice == 2) {
                    break;
                }

                randomValue = generateNumber();
            }
        }
    }

    // 랜덤 숫자 생성
    public static String generateNumber() {
        List<Integer> computer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer.toString().replaceAll("[^0-9]", "");
    }

    // 사용자 입력 유효성 확인 -> 예외 처리
    public static void validateUserInput(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("사용자 입력이 3자리 수가 아닙니다.");
        }
        for (char c : userInput.toCharArray()) {
            if (Character.getNumericValue(c) < 1 || Character.getNumericValue(c) > 9) {
                throw new IllegalArgumentException("사용자 입력 범위는 1-9 사이 값이어야 합니다.");
            }
            if (userInput.indexOf(c) != userInput.lastIndexOf(c)) {
                throw new IllegalArgumentException("사용자 입력이 중복되었습니다.");
            }
        }
    }

    // 사용자 입력과 랜덤 숫자 비교 -> 비교 결과 출력
    public static String compare(String randomValue, String userInput) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < randomValue.length(); i++) {
            char n = randomValue.charAt(i);
            int indexUserInput = userInput.indexOf(n);

            if (indexUserInput == i) {
                strike++;
            } else if (indexUserInput != -1) {
                ball++;
            }
        }

        if (strike == 0 && ball == 0) {
            return "낫싱";
        }

        if (strike == 3) {
            return "3스트라이크";
        }

        StringBuilder sb = new StringBuilder();
        if (ball > 0) {
            sb.append(ball).append("볼 ");
        }
        if (strike > 0) {
            sb.append(strike).append("스트라이크");
        }
        return sb.toString().trim();
    }

}
