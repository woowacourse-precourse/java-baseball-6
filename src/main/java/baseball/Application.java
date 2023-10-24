package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;
public class Application {
    static List<Integer> mixNum(List<Integer> computer) {       //컴퓨터로부터 랜덤숫자
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int play = 1;
        List<Integer> computer = new ArrayList<>();
        mixNum(computer);

        int strike = 0;
        int ball = 0;

        while (play == 1) {
            int N = Integer.parseInt(Console.readLine());

            List<Integer> input = new ArrayList<>();
            HashSet<Integer> check = new HashSet<>();

            int first = N/100;
            int second = (N%100)/ 10;
            int third = N%10;

            check.add(first);
            check.add(second);
            check.add(third);

            if((check.size() != 3) || String.valueOf(N).length() != 3)
                throw new IllegalArgumentException();   //중복된 숫자나 숫자 입력 갯수가 잘 못 되었을 때

            input.add(first);
            input.add(second);
            input.add(third);

            for (int i = 0; i < 3; i++) {
                if (!computer.contains(input.get(i))) continue;
                if (computer.get(i) == input.get(i))
                    strike++;
                else ball++;
            }

            if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
            } else if (strike == 3) {
                System.out.println("3스트라이크 \n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                play = Integer.parseInt(Console.readLine());
                if(play == 1) {
                    strike = 0;                     //스트라이크 초기화
                    computer = new ArrayList<>();   //컴퓨터가 뽑은 숫자 배열 초기화
                    mixNum(computer);               //숫자를 다시 뽑음
                }else break;
            } else if (strike > 0 && ball > 0) {
                System.out.println(ball + "볼 " + strike + "스트라이크");
                strike = 0;
                ball = 0;
            } else if (strike == 0) {
                System.out.println(ball + "볼");
                ball = 0;
            } else {
                System.out.println(strike + "스트라이크");
                strike = 0;
            }
        }
    }
}

