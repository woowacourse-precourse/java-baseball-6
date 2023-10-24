package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        boolean game_flag = false;          // 게임 진행 여부
        StringBuilder randomNumber;                   // 컴퓨터의 랜덤 숫자

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (!game_flag) {

            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int tempNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(tempNumber)) {
                    computer.add(tempNumber);
                }
            }

            randomNumber = new StringBuilder();

            for (Integer com : computer) {
                randomNumber.append(com);
            }

            // 게임 시작
            start(randomNumber.toString());

            // 게임 종료
            game_flag = end();
        }
    } // main

    private static void start(String randomNumber) {

        String userNumber;

        while (true) {

            System.out.print("숫자를 입력해주세요 : ");

            userNumber = Console.readLine();

            try {
                Integer.parseInt(userNumber);
            } catch(Exception e) {
                throw new IllegalArgumentException();
            }

            if (userNumber.length() != 3) throw new IllegalArgumentException();

            // 입력된 숫자에 대한 결과 계산
            if (calculate(randomNumber, userNumber)) {
                return;
            }
        }
    } // start

    private static boolean calculate(String randomNumber, String userNumber) {

        char temp;

        int strike = 0;
        int ball = 0;

        // 계산
        for (int i = 0; i < 3; i++) {

            temp = userNumber.charAt(i);

            // 스트라이크
            if (randomNumber.charAt(i) == temp) {
                strike += 1;
                continue;
            }

            // 볼
            for (int j = 0; j < 3; j++) {
                if (randomNumber.charAt(j) == temp) {
                    ball += 1;
                    break;
                }
            }
        }

        // 출력
        return printResult(ball, strike);
    }

    private static boolean printResult(int ball, int strike) {

        if (ball > 0) System.out.print(ball + "볼 ");

        if (strike > 0) {
            System.out.print(strike + "스트라이크");
            if (strike == 3){
                System.out.println();
                return true;
            }
        }

        if (ball == 0 && strike == 0) System.out.print("낫싱");

        System.out.println();
        return false;
    }

    private static boolean end() {

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int check = Integer.parseInt(Console.readLine());

        if (check == 1) return false;
        else if (check == 2) return true;
        else throw new IllegalArgumentException();

    } // end
}
