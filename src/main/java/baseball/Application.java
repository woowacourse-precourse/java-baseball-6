package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다");

        // 컴퓨터가 랜덤 숫자 만들기
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }

        System.out.println("computerNumber = " + computerNumber);

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");

            // 사용자에게 3자리 숫자 입력받기
            String userNumber = Console.readLine();

            // 사용자가 입력한 3자리 숫자가 유효한지 확인
            // 1. 3자리가 아닌경우
            if (userNumber.length() != 3) {
                System.out.println("올바른 숫자 3가지를 입력해주세요.");
            }
            // 2. 중복된 수가 있을 경우
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < userNumber.length(); i++) {
                int number = userNumber.charAt(i) - 48;
                set.add(number);
            }
            if (set.size() != 3) {
                System.out.println("올바른 숫자 3가지를 입력해주세요");
            }

            // 3. 숫자를 입력하지 않은 경우


            // 사용자와 컴퓨터 숫자 비교하기
            String result = "";
            int strike = 0;
            int ball = 0;
            for (int i = 0; i < 3; i++) {
                int currentUsernNumber = userNumber.charAt(i) - 48;
                int currentComputerNumber = computerNumber.get(i);
                if (currentUsernNumber == currentComputerNumber) {
                    strike++;
                } else {
                    if (computerNumber.contains(currentUsernNumber)) {
                        ball++;
                    }
                }
            }

            if (strike == 0 && ball == 0) {
                result = "낫싱";
            } else {
                if (ball > 0) {
                    result += String.format("%d 볼", ball);
                }
                if (strike > 0) {
                    result += String.format("%d 스트라이크", strike);
                }
            }
            System.out.println(result);

            if (userNumber.equals(computerNumber.stream().map(String::valueOf).collect(Collectors.joining()))) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
}
