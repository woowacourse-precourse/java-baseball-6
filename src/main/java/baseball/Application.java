package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {

        boolean startGame = true;
        int randomMin = 1;
        int randomMax = 9;
        int numberSize = 3;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (startGame) {

            List<Integer> computer = new ArrayList<>();
            while (computer.size() < numberSize) {
                int randomNumber = Randoms.pickNumberInRange(randomMin, randomMax);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            while (true) {

                int strike = 0;
                int ball = 0;

                System.out.print("숫자를 입력해주세요 : ");
                int num = Integer.parseInt(Console.readLine());
                int[] user = Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
                if (user.length != numberSize) throw new IllegalArgumentException();

                for (int i = 0; i < numberSize; i++) {
                    for (int j = 0; j < numberSize; j++) {
                        if (j != i) {
                            if (computer.get(i).equals(user[j])) ball++;
                        }
                    }
                    if (computer.get(i).equals(user[i])) strike++;
                }

                if      (ball > 0 && strike == 0) System.out.println(ball + "볼");
                else if (strike > 0 && ball == 0) System.out.println(strike + "스트라이크");
                else if (ball > 0 && strike > 0)  System.out.println(ball + "볼 " + strike + "스트라이크");
                else                              System.out.println("낫싱");

                if (strike == numberSize) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    int restart = Integer.parseInt(Console.readLine());
                    if      (restart == 1) break;
                    else if (restart == 2) { startGame = false; break; }
                    else    throw new IllegalArgumentException();
                }
            }
        }
    }
}
