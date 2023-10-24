package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int restart = 1;

        while (restart == 1) {

            // 컴퓨터 랜덤 번호 생성
            List<Integer> computerNumber = new ArrayList<>();
            while (computerNumber.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computerNumber.contains(randomNumber)) {
                    computerNumber.add(randomNumber);
                }
            }
            System.out.println("숫자 야구 게임을 시작합니다.");

            int strike = 0;
            int ball = 0;

            while (strike != 3) {

                strike = 0;
                ball = 0;
                System.out.print("숫자를 입력해주세요 : ");

                // 사용자 번호 입력
                String userNumber = Console.readLine();

                // 사용자 번호 유효성 검사
                if (!Pattern.matches("^[1-9]{3}$", userNumber) 
                		|| userNumber.charAt(0) == userNumber.charAt(1)
                        || userNumber.charAt(0) == userNumber.charAt(2)
                        || userNumber.charAt(1) == userNumber.charAt(2)) {
                    throw new IllegalArgumentException();
                }
                
                // 스트라이크, 볼 판정 로직
                for (int i = 0; i < userNumber.length(); i++) {
                    int userInt = Character.getNumericValue(userNumber.charAt(i));
                    if (computerNumber.contains(userInt)) {
                        if (userInt == computerNumber.get(i)) {
                            strike++;
                        } else {
                            ball++;
                        }
                    }
                }

                if (strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                } else if (strike == 0) {
                    System.out.println(ball + "볼");
                } else if (ball == 0) {
                    System.out.println(strike + "스트라이크");
                } else {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                }
                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                }
            }

            // 게임 재시작 혹은 종료 기능
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            restart = Integer.parseInt(Console.readLine());

            if (restart == 2) {
                System.out.println("프로그램을 종료합니다.");
                return;
            }
            if (restart != 1 && restart != 2) {
                throw new IllegalArgumentException();
            }

        }
    }
}
