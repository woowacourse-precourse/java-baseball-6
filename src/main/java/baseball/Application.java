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
            // 컴퓨터 숫자 랜덤 설정
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
                // 사용자 숫자 입력 받은 후 배열로 저장
                System.out.print("숫자를 입력해주세요 : ");
                int num = Integer.parseInt(Console.readLine());
                int[] user = Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
                if (user.length != numberSize) throw new IllegalArgumentException(); // 예외 처리

                // 볼, 스트라이크 개수 파악
                for (int i = 0; i < numberSize; i++) {
                    if (computer.get(i).equals(user[i])) strike++;
                }
                if (computer.get(0).equals(user[1]) || computer.get(0).equals(user[2])) ball++;
                if (computer.get(1).equals(user[0]) || computer.get(1).equals(user[2])) ball++;
                if (computer.get(2).equals(user[0]) || computer.get(2).equals(user[1])) ball++;
                // 점수 계산
                if      (ball > 0 && strike == 0) System.out.println(ball + "볼");
                else if (ball == 0 && strike > 0) System.out.println(strike + "스트라이크");
                else if (ball > 0 && strike > 0)  System.out.println(ball + "볼 " + strike + "스트라이크");
                else                              System.out.println("낫싱");
                // 게임 종료 or 재시작
                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    int restart = Integer.parseInt(Console.readLine());
                    if      (restart == 1) break;
                    else if (restart == 2) {
                        startGame = false; break;
                    }
                    else throw new IllegalArgumentException(); // 예외처리
                }

            }
        }
    }
}
