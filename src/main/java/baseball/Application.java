package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.LinkedList;

public class Application {

    public static void main(String[] args) {
        int isContinue = 1;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(isContinue == 1) {
            LinkedList<Integer> num = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
            LinkedList<Integer> answer = new LinkedList<>();

            /**
             * 정답 설정
             */
            for (int i = 0; i < 3; i++) {
                int buf = Randoms.pickNumberInRange(0, num.size() - 1);
                int selectedNum = num.get(buf);
                answer.add(selectedNum);
                num.remove(Integer.valueOf(selectedNum));
            }

            while (true) {
                int strike = 0;
                int ball = 0;

                System.out.print("숫자를 입력해주세요 : ");
                int input = Integer.parseInt(Console.readLine());
                for (int trial = 2; trial >= 0; trial--) {
                    int remainder = input % 10;
                    input /= 10;
                    if (answer.contains(remainder))
                        if (answer.get(trial) == remainder)
                            strike++;
                        else
                            ball++;
                }

                if (ball == 0 && strike == 0)
                    System.out.print("낫싱");

                else {
                    if (ball != 0)
                        System.out.printf("%d볼 ", ball);
                    if (strike != 0)
                        System.out.printf("%d스트라이크", strike);
                }
                System.out.println();

                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            isContinue = Integer.parseInt(Console.readLine());
        }
    }
}
