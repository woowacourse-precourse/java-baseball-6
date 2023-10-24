package baseball;

import camp.nextstep.edu.missionutils.*;
import java.util.*;
import java.util.stream.StreamSupport;

public class Application {
    public static void main(String[] args) {
        List<Integer> computer = new ArrayList<>();
        int restart = 1, strike = 3;

        System.out.printf("숫자 야구 게임을 시작합니다.\n");

        while (restart == 1) {
            if(strike == 3) {
                computer = new ArrayList<>();
                while (computer.size() < 3) {
                    int randomNumber = Randoms.pickNumberInRange(1, 9);
                    if (!computer.contains(randomNumber)) {
                        computer.add(randomNumber);
                    }
                }
            }
            int ball = 0; strike = 0;

            System.out.printf("숫자를 입력해주세요 : ");

            List<Integer> user = new ArrayList<>();

            String input = Console.readLine();
            int length = input.length();
            if (length != 3) throw new IllegalArgumentException();

            int num = Integer.parseInt(input);
            while (user.size() < 3) {
                if (user.contains(num % 10)) {
                    throw new IllegalArgumentException();
                }
                if (!user.contains(num % 10)) {
                    user.add(num % 10);
                }
                num /= 10;
            }
            Collections.reverse(user);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (computer.get(i) == user.get(j)) {
                        if (i == j) strike++;
                        if (i != j) ball++;
                    }
                }
            }

            if(ball > 0 && strike >0) System.out.printf("%d볼 %d스트라이크\n", ball, strike);
            if(ball > 0 && strike == 0) System.out.printf("%d볼\n", ball);
            if(ball == 0 && strike > 0) System.out.printf("%d스트라이크\n", strike);
            if(ball == 0 && strike == 0) System.out.printf("낫싱\n");

            if (strike == 3) {
                System.out.printf("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
                System.out.printf("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
                String re = Console.readLine();
                if (Integer.parseInt(re) == 2) restart = 2;
            }
        }
    }
}