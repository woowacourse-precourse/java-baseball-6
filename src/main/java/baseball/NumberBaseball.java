package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberBaseball {

    public static final int RESTART_INPUT = 1;
    public static final int EXIT_INPUT = 2;

    public boolean execute() throws IllegalArgumentException {

        System.out.println("숫자 야구 게임을 시작합니다.");

        int randomnumber1, randomnumber2, randomnumber3;

        do {
            randomnumber1 = Randoms.pickNumberInRange(1, 9);
            randomnumber2 = Randoms.pickNumberInRange(1, 9);
            randomnumber3 = Randoms.pickNumberInRange(1, 9);
        } while (randomnumber1 == randomnumber2 || randomnumber1 == randomnumber3 || randomnumber2 == randomnumber3);

        System.out.println(randomnumber1);
        System.out.println(randomnumber2);
        System.out.println(randomnumber3);

        while (true) {
            int strike = 0;
            int ball = 0;

            System.out.print("숫자를 입력해주세요 : ");
            String gamernumber = Console.readLine();
            if (gamernumber.length() != 3) {
                throw new IllegalArgumentException();
            }

            int gamernumber1;
            int gamernumber2;
            int gamernumber3;
            try {
                char[] gnArr = gamernumber.toCharArray();
                gamernumber1 = Character.getNumericValue(gnArr[0]);
                gamernumber2 = Character.getNumericValue(gnArr[1]);
                gamernumber3 = Character.getNumericValue(gnArr[2]);
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }

            if (gamernumber1 == gamernumber2 || gamernumber1 == gamernumber3 || gamernumber2 == gamernumber3) {
                throw new IllegalArgumentException();
            }

            if (gamernumber1 == randomnumber1) {
                strike++;
            } else if (gamernumber1 == randomnumber2 || gamernumber1 == randomnumber3) {
                ball++;
            }

            if (gamernumber2 == randomnumber2) {
                strike++;
            } else if (gamernumber2 == randomnumber1 || gamernumber2 == randomnumber3) {
                ball++;
            }

            if (gamernumber3 == randomnumber3) {
                strike++;
            } else if (gamernumber3 == randomnumber1 || gamernumber3 == randomnumber2) {
                ball++;
            }

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