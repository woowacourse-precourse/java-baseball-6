package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        //TODO: 프로그램 구현
        String reGame = "1";
        String stop = "2";
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (reGame.equals("1")) {
            baseball();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String reStart = Console.readLine();
            if (reStart.equals(stop)) {
                break;
            }
        }


    }

    private static void baseball() throws IllegalArgumentException {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        int strike = 0;
        int ball = 0;
        boolean nothing = false;
        while (strike != 3) {
            System.out.print("숫자를 입력해주세요 : ");
            String playerInput = Console.readLine();

            if (playerInput.length() != 3) {
                throw new IllegalArgumentException();
            }
            int[] playerNumber = new int[3];

            for (int i = 0; i < 3; i++) {
                playerNumber[i] = playerInput.charAt(i) - '0';
                int checkInteger = playerNumber[i];
                if (checkInteger == 0 || checkInteger > 9) {
                    throw new IllegalArgumentException();
                }
            }
            int[] checkDuplication = Arrays.stream(playerNumber)
                    .distinct()
                    .toArray();
            if (checkDuplication.length != playerNumber.length) {
                throw new IllegalArgumentException();
            }


            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (computer.get(i) == playerNumber[j]) {
                        if (i == j) {
                            strike++;
                            nothing = false;

                        } else {
                            ball++;
                            nothing = false;

                        }
                    } else {
                        nothing = true;

                    }
                }
            }
            if (strike == 3) {
                System.out.println(strike + "스트라이크");
                break;
            } else if (strike > 0 && ball == 0) {
                System.out.println(strike + "스트라이크 ");
                strike = 0;

            } else if (strike == 0 && ball > 0) {
                System.out.println(ball + "볼 ");
                ball = 0;
            } else if (strike > 0 && ball > 0) {
                System.out.println(ball + "볼 " + strike + "스트라이크 ");
                strike = 0;
                ball = 0;

            } else if (nothing) {
                System.out.println("낫싱");
                nothing = false;
            }
        }
        System.out.print("3개의 숫자를 모두 맞히셨습니다!  ");
        System.out.println("게임 종료");


    }
}
