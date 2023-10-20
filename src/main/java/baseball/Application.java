package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean startGame = true;
        while (startGame) {
            // computer의 정답 3자리 수 생성
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            int computerNumber = 100 * computer.get(0) + 10 * computer.get(1) + computer.get(2);
            String computerNumberStr = Integer.toString(computerNumber);

            // (숫자 입력 --> 정답과 비교 --> 결과 출력) 반복
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String userNumberStr = readLine();

                // 3개 숫자 모두 같으면 바로 종료
                if (computerNumberStr.equals(userNumberStr)) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
                // 정답이 아니라면 입력 오류 없는지 확인
                boolean rightInput = checkUserNumber(userNumberStr);
                if (rightInput) {
                    // 오류 없다면(true) IllegalArgumentException 발생 없이 다음 코드 진행
                }

                // 입력값과 정답을 비교하고 결과에 따라 스트라이크, 볼 개수 세기
                int strike = 0;
                int ball = 0;
                for (int i = 0; i < computerNumberStr.length(); i++) {
                    char computerDigit = computerNumberStr.charAt(i);
                    char userDigit = userNumberStr.charAt(i);

                    if (userDigit == computerDigit) {
                        strike++; // 같은 자리, 같은 수 --> 스트라이크
                    } else if (computerNumberStr.contains(String.valueOf(userDigit))) {
                        ball++; // 다른 자리, 같은 수 포함 --> 볼
                    }
                }
                // 스트라이크, 볼 개수 출력
                if (strike > 0 && ball > 0) {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                } else if (strike > 0) {
                    System.out.println(strike + "스트라이크");
                } else if (ball > 0) {
                    System.out.println(ball + "볼");
                } else {
                    System.out.println("낫싱");
                }
            }

            // 정답일 경우 --> 게임 종료 여부 결정
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String decisionGame = readLine();
            if (decisionGame.equals("2")) {
                startGame = false; // 게임 종료
            } else if (decisionGame.equals("1")) {
                // 게임 재시작
            } else {
                throw new IllegalArgumentException(); // 1, 2 외의 값일 때 입력 오류 발생
            }
        }
    }

    public static boolean checkUserNumber(String userNumberStr) {
        // 숫자가 아닐 때 입력 오류 발생
        try {
            Integer.parseInt(userNumberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        // 3자리가 아닐때 입력 오류 발생
        if (userNumberStr.length() != 3) {
            throw new IllegalArgumentException();
        }
        // 같은 숫자가 있을 때 입력 오류 발생
        char digit1 = userNumberStr.charAt(0);
        char digit2 = userNumberStr.charAt(1);
        char digit3 = userNumberStr.charAt(2);
        if (digit1 == digit2 || digit1 == digit3 || digit2 == digit3) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
