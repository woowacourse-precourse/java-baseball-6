package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다."); // 게임 시작 문구

        while (true) {
            List<Integer> computer = new ArrayList<>(); // 랜덤 숫자 생성
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }


            while (true) {

                System.out.print("숫자를 입력해주세요 : ");
                String myInput = Console.readLine(); // 입력 숫자 생성

                List<Integer> myNum = new ArrayList<>(); // 입력 숫자를 리스트로 변경
                for (int i = 0; i < myInput.length(); i++) {
                    char digitChar = myInput.charAt(i);
                    int digit = Character.getNumericValue(digitChar);
                    myNum.add(digit);
                }

                int ball = 0;
                int strike = 0;

                for (int i = 0; i < computer.size(); i++) {
                    int computerDigit = computer.get(i);
                    int userDigit = myNum.get(i);

                    if (computerDigit == userDigit) {
                        strike++;
                    } else if (computer.contains(userDigit)) {
                        ball++;
                    }
                }

                if (0 < strike || 0 < ball) {  // 볼, 스트라이크가 둘중 하나라도 1이상이면 카운트 후 출력
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                } else if (0 == strike && 0 == ball) {  // 볼, 스트라이크가 둘다 0이면 낫싱 출력
                    System.out.println("낫싱");
                }

                if (strike == 3) {  //스트라이크가 3일시 카운트 출력, 게임 종료 출력
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞혔습니다! 게임 종료");
                    break;
                }

            }

            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: "); // 게임 재시작 묻기
            String reGame = Console.readLine();

            if (!reGame.equals("1")) {
                System.out.println("게임 종료");
                break;
            }

        }
    }
}