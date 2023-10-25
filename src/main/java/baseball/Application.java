package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO
        // 1. 컴퓨터가 서로 다른 숫자 3개를 정한다
        // 2. 사용자가 숫자를 입력한다
        // 3. 각 숫자에 대해 볼, 스트라이크, 낫싱 여부를 판별한다
        // 4. 정답을 맞출 수 있을 때까지 이 과정을 반복한다

        boolean playing = true;
        Computer computer = new Computer();
        List<Integer> randomNums;

        System.out.println("숫자 야구 게임을 시작합니다.");

        // TODO 1: 컴퓨터로 랜덤 숫자 만들기
        randomNums = computer.makeRandomNumbers();

        while (playing) {

            // TODO 2 : 사용자가 숫자를 입력한다
            // 숫자는 문자열 형태로 입력된다.
            // 입력된 숫자가 3자리가 아니거나 & 중복된 숫자들이 있으면 에러 처리
            // 입력된 숫자를 비교할 수 있도록
            System.out.println("숫자를 입력해주세요 : ");
            int inputNums = Integer.parseInt(Console.readLine());

            // 숫자가 3자리가 아닌 경우
            if (inputNums < 100 || inputNums > 999) {
                throw  new IllegalArgumentException();
            }

            // 중복된 숫자가 있는 경우 중간에 에러 처리
            List<Integer> userNums = new ArrayList<>();
            int tmp = 100;
            for (int i = 0; i<3; i++) {
                int num = inputNums/tmp;
                if (userNums.contains(num)) {
                    throw new IllegalArgumentException();
                }
                userNums.add(num);
                inputNums %= tmp;
                tmp /= 10;
            }


            // TODO 3: 볼, 스트라이크, 낫싱 판별
            // 볼, 스트라이크 판별
            // 둘 다 없으면 낫싱
            int ball = 0;
            int strike = 0;
            for (int i = 0; i<3; i++) {
                int nowNum = userNums.get(i);
                if (nowNum == randomNums.get(i)) {
                    strike++;
                }
                else if (randomNums.contains(nowNum)) {
                    ball++;
                }
            }

            if (strike == 3) {
                int isRestart = 0;
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                while (isRestart != 1 && isRestart != 2) {
                    isRestart = Integer.parseInt(Console.readLine());
                }

                if (isRestart == 2) {
                    playing = false;
                } else {
                    randomNums = computer.makeRandomNumbers();
                }

            }
            else {
                if (ball > 0) {
                    System.out.print(ball+"볼 ");
                }
                if (strike > 0) {
                    System.out.print(strike+"스트라이크");
                }
                if (ball == 0 && strike == 0) {
                    System.out.print("낫싱");
                }
            }
            System.out.println();
        }
    }
}


