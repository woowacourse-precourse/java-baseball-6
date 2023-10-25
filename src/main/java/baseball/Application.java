package baseball;

import baseball.Stationary.*;
import baseball.Validation.*;
import baseball.Random.*;
import camp.nextstep.edu.missionutils.Console;

public class Application {

        public static void main(String[] args) {
                System.out.println("숫자 야구 게임을 시작합니다.");

                while (true) {
                        String randomNumber = Random.returnRandomNumber();
                        run(randomNumber);
                        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                        String restart = Console.readLine();
                        if (restart.equals("2")) {
                                break;
                        }
                }

        }

        // 사용자가 입력한 값의 유효성 검사
        public static void Validation(String input) {
                Validation.isNumber(input);
                Validation.isZeroIncluded(input);
                Validation.isContainDuplicate(input);
        }

        // 사용자에게 입력을 받고 유효성 검사한 다음 결과를 출력
        public static void run(String randomNumber) {
                boolean flag = false;
                do {
                        System.out.print("숫자를 입력해주세요 : ");
                        String input = Console.readLine();
                        Validation(input);
                        flag = CompareNumber(randomNumber, input);  // 결과 계산
                } while (!flag);
        }

        // 결과 계산
        public static boolean CompareNumber(String randomNumber, String input) {
                String result = Compare.compare(randomNumber, input);
                boolean flag = false;
                if (result.equals("3개의 숫자를 모두 맞히셨습니다! 게임 종료")) {
                        System.out.println("3스트라이크");
                        flag = true;
                }
                System.out.println(result);
                return flag;
        }

}
