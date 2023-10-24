package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberBaseball {

    public static final int RESTART_INPUT = 1;
    public static final int EXIT_INPUT = 2;

    public boolean execute() throws IllegalArgumentException {

        System.out.println("숫자 야구 게임을 시작합니다.");

        int randomNumber1, randomNumber2, randomNumber3;
        // 랜덤(타겟)숫자 생성
        do {
            randomNumber1 = Randoms.pickNumberInRange(1, 9);
            randomNumber2 = Randoms.pickNumberInRange(1, 9);
            randomNumber3 = Randoms.pickNumberInRange(1, 9);
        } while (randomNumber1 == randomNumber2 || randomNumber1 == randomNumber3 || randomNumber2 == randomNumber3);

         System.out.println(randomNumber1);
         System.out.println(randomNumber2);
         System.out.println(randomNumber3);

        while (true) {
            int strike = 0;
            int ball = 0;
            // 게이머(사용자)의 숫자를 입력을 받는다.
            // 3자리 숫자가 아닌 경우, 에러 발생
            System.out.print("숫자를 입력해주세요 : ");
            String gamerNumber = Console.readLine();
            if (gamerNumber.length() != 3) {
                throw new IllegalArgumentException();
            }
            // 게이머(사용자)가 입력한 숫자를 랜덤(타겟)숫자와 비교
            // 입력이 숫자가 아닌 경우, 에러 발생
            int gamerNumber1;
            int gamerNumber2;
            int gamerNumber3;
            try {
                char[] gNArr = gamerNumber.toCharArray();
                gamerNumber1 = Character.getNumericValue(gNArr[0]);
                gamerNumber2 = Character.getNumericValue(gNArr[1]);
                gamerNumber3 = Character.getNumericValue(gNArr[2]);
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
            // 중복된 숫자 입력한 경우, 에러 발생
            if (gamerNumber1 == gamerNumber2 || gamerNumber1 == gamerNumber3 || gamerNumber2 == gamerNumber3) {
                throw new IllegalArgumentException();
            }
            // 게이머(사용자) 숫자와 랜덤(타겟) 숫자를 비교 하여 볼, 스트라이크 갯수 확인
            if (gamerNumber1 == randomNumber1) {
                strike++;
            } else if (gamerNumber1 == randomNumber2 || gamerNumber1 == randomNumber3) {
                ball++;
            }

            if (gamerNumber2 == randomNumber2) {
                strike++;
            } else if (gamerNumber2 == randomNumber1 || gamerNumber2 == randomNumber3) {
                ball++;
            }

            if (gamerNumber3 == randomNumber3) {
                strike++;
            } else if (gamerNumber3 == randomNumber1 || gamerNumber3 == randomNumber2) {
                ball++;
            }
            // 볼, 스트라이크 출력
            if (strike == 3) {
                System.out.println(strike + "스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                break;
            } else if (ball == 0 && strike == 0) {
                System.out.println("낫싱");
            } else if (ball > 0 && strike == 0) {
                System.out.println(ball + "볼");
            } else if (ball == 0 && strike > 0) {
                System.out.println(strike + "스트라이크");
            } else {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }
        }

        String Restart = Console.readLine();
        // 게임 재시작 및 종료 여부 확인
        // RESTART_INPUT, EXIT_INPUT를 입력 하지 않은 경우, 에러 발생
        switch (Integer.parseInt(Restart)) {
            case RESTART_INPUT:
                return true;
            case EXIT_INPUT:
                return false;
            default:
                throw new IllegalArgumentException();
        }
    }
}