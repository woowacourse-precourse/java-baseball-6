package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        // TODO: 프로그램 구현

        String guessStr = "";
        int guessInt = 0;
        int g1, g2, g3; // guessed numbers on each position
        int t1, t2, t3; // target numbers on each position

        int strike = 0;
        int ball = 0;

        int restart = 1;

        // Game Start announcement
        System.out.println("숫자 야구 게임을 시작합니다.");

        // Play until restart value is not 1
        while (restart == 1) {
            // Storing three different numbers in target ArrayList
            List<Integer> target = new ArrayList<>();
            while (target.size() < 3) {
                int rand = Randoms.pickNumberInRange(1, 9);
                if (!target.contains(rand)) {
                    target.add(rand);
                }
            }

            // Storing numbers of target on each index
            t1 = target.get(0);
            t2 = target.get(1);
            t3 = target.get(2);

            // Getting guessed input from the user until the user gets it right
            while (true) {
                // reset the value of ball and strike to resume
                ball = 0;
                strike = 0;

                System.out.print("숫자를 입력해주세요 : ");
                guessStr = Console.readLine();

                // Throwing Error in case of wrong input from the user
                try {
                    guessInt = Integer.parseInt(guessStr);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

                // Throwing Error in case the number is not between 100, 999
                if (guessInt < 100 || guessInt > 999) {
                    throw new IllegalArgumentException("Invalid argument: " + guessInt);
                }

                // Storing numbers on each position to compare
                g1 = guessInt / 100;
                g2 = guessInt % 100 / 10;
                g3 = guessInt % 100 % 10;

                // Comparing value and index, but i think this code is too bulky
                if (g1 == t1) {
                    strike++;
                } else if (g2 == t1) {
                    ball++;
                } else if (g3 == t1) {
                    ball++;
                }

                if (g2 == t2) {
                    strike++;
                } else if (g1 == t2) {
                    ball++;
                } else if (g3 == t2) {
                    ball++;
                }

                if (g3 == t3) {
                    strike++;
                } else if (g1 == t3) {
                    ball++;
                } else if (g2 == t3) {
                    ball++;
                }

                // Printing the result
                if (strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                } else if (strike >= 1 || ball >= 1) {
                    if (strike == 3) {
                        System.out.println("3스트라이크\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        ball = 0;
                        strike = 0;
                        break;
                    } else if (ball >= 1) {
                        System.out.println(ball + "볼" + ((strike >= 1) ? " " + strike + "스트라이크" : ""));
                    } else if (strike >= 1) {
                        System.out.println(strike + "스트라이크");
                    }
                }
            }

            //task if the user wants to continue playing
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String re = Console.readLine();
            restart = Integer.parseInt(re);

            // Throws error in case of wrong input from the user
            if (!(restart == 1 || restart == 2)) {
                throw new IllegalArgumentException("Invalid argument: " + restart);
            }
        }
    }

}