package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application extends RuntimeException {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 서로 다른 3개의 숫자 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) { // 서로 다른 3개의 정수여야 함.
                computer.add(randomNumber);
            }
        }

        numberBaseball(computer);

    }

    // 숫자 야구 함수
    public static void numberBaseball(List<Integer> computer) {
        int status = 0; //1: 재시작, 2:종료
        int strike = 0;
        int ball = 0;
        int nothing = 0;

        List<Integer> user = new ArrayList<>();
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            user.clear(); // 사용자의 이전 입력을 갱신
            try {
                System.out.println("숫자를 입력해주세요 :");
                String userInput = Console.readLine();

                // 입력된 문자열의 각 문자를 int로 변환하여 user 리스트에 추가
                for (int i = 0; i < userInput.length(); i++) {
                    char digitChar = userInput.charAt(i);
                    int temp = Character.getNumericValue(digitChar);
                    user.add(temp);
                    if (temp < 1 || temp > 9) { // 0을 입력했을 경우
                        throw new IllegalArgumentException("잘못된 입력: 1에서 9 사이의 숫자를 입력해야 합니다.");
                    }
                    if (user.contains(temp)) { // 중복된 숫자를 입력했을 경우
                        throw new IllegalArgumentException("잘못된 입력: 중복된 숫자를 입력할 수 없습니다.");
                    }
                }
            } catch (IllegalArgumentException e) {
                System.err.println("오류: " + e.getMessage());
                System.exit(1); // 시스템 종료
            }

            // 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱
            for (int i = 0; i < user.size(); i++) {
                int userNumber = user.get(i);
                int computerNumber = computer.get(i);

                if (userNumber == computerNumber) {
                    // 같은 수가 같은 자리에 있으면 스트라이크
                    strike++;
                } else if (user.contains(computerNumber)) {
                    // 같은 수가 다른 자리에 있으면 볼
                    ball++;
                }
            }

            if (strike == 0 && ball == 0) {
                // 같은 수가 전혀 없으면 낫싱
                nothing++;
            }
            // 결과값 출력
            if (ball != 0) {
                System.out.print(ball + "볼");
            }
            if (strike != 0) {
                System.out.print(strike + "스트라이크");
            } else {
                System.out.println("낫싱");
            }

            if (computer.equals(user)) { // 이용자가 숫자를 맞춘 경우
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                status = Console.readLine(); // 1,2 입력 받기
                if (status != 1 || status != 2) { // 사용자가 다른 수를 입력했을 경우
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                }
            }
        } while (status == 1);
    }
}
