package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import javax.swing.plaf.ComponentUI;
import java.lang.reflect.Array;
import java.util.Objects;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.parseInt;

public class Application {
    public static void main(String[] args) {
        System.out.println("야구게임을 시작합니다.");

        Integer restart;
        do {
            // 컴퓨터 숫자 랜덤 받았음
            int[] ComNumbers = new int[3];
            Randoms randoms = null;

            ComNumbers[0] = randoms.pickNumberInRange(1, 9);
            ComNumbers[1] = randoms.pickNumberInRange(1, 9);
            ComNumbers[2] = randoms.pickNumberInRange(1, 9);

            while (ComNumbers[0] == ComNumbers[1]) {
                ComNumbers[1] = randoms.pickNumberInRange(1, 9);
            }

            while (ComNumbers[2] == ComNumbers[0] || ComNumbers[2] == ComNumbers[1]) {
                ComNumbers[2] = randoms.pickNumberInRange(1, 9);
            }

            System.out.print("숫자를 입력해주세요 : ");
            String UserNumbers = readLine();
            String[] User = UserNumbers.split("");

            IllegalArgumentException f = new IllegalArgumentException("똑바로 입력해라 뒤지기싫으면");

            if (UserNumbers.contains("0")) {
                throw f;
            }

            if (UserNumbers.length() != 3) {
                throw f;
            } else if (User[0].equals(User[1])) {
                throw f;
            } else if (User[0].equals(User[2])) {
                throw f;
            } else if (User[1].equals(User[2])) {
                throw f;
            }


            int strike = 0;
            int ball = 0;

            while (strike != 3) {

                strike = 0;
                ball = 0;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (i == j && ComNumbers[i] == parseInt(User[j])) {
                            strike++;
                        } else if (ComNumbers[i] == parseInt(User[j])) {
                            ball++;
                        }

                    }
                }

                // 숫자 다 받았음

                if (strike == 3) {
                    System.out.println("3스트라이크");
                    break;
                } else if (strike != 0 && ball != 0) {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                } else if (strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                } else if (strike != 0) {
                    System.out.println(strike + "스트라이크");
                } else if (ball != 0) {
                    System.out.println(ball + "볼");
                }


                System.out.print("숫자를 입력해주세요 : ");
                UserNumbers = readLine();
                User = UserNumbers.split("");

                if (UserNumbers.length() != 3) {
                    throw f;
                } else if (User[0].equals(User[1])) {
                    throw f;
                } else if (User[0].equals(User[2])) {
                    throw f;
                } else if (User[1].equals(User[2])) {
                    throw f;
                }

            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            restart = Integer.valueOf(Console.readLine());
            while (restart != 1 && restart != 2) {
                System.out.println("1 또는 2 이외의 값이 입력되었습니다. 다시 입력해주세요.");
                restart = Integer.valueOf(Console.readLine());
            }
        } while (restart == 1);
    }
}
