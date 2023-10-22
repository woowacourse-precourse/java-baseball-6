package baseball;

import baseball.domain.Player.Player;
import baseball.domain.computer.Computer;

import static baseball.domain.script.Script.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int flag = 1;

        // 1. Computer/Player Entity 생성.
        Computer computer = new Computer();

        // 2. 게임시작
        System.out.println(GAME_START.getMessage());

        while (flag == 1) {

            // 2- 1. Player 숫자를 입력받음.
            System.out.print(NUMS_INPUT.getMessage());

            List<Integer> list = new ArrayList<>();
            String tmp = scanner.next();
            for (int i = 0; i < 3; i++) {
                list.add(tmp.charAt(i) - '0');
            }
            Player player = new Player(list);

            // 2-2. Player 숫자랑 Computer 숫자와 비교해보기.
            int strikeCount = 0;
            int ballCount = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (computer.getIndexNumbers(i) == player.getIndexNumbers(j) && i == j) strikeCount++;
                    else if (computer.getIndexNumbers(i) == player.getIndexNumbers(j)) ballCount++;
                }
            }

            // 2-3. Player 숫자에 따른 카운트 출력.
            if (strikeCount != 0 && ballCount == 0) System.out.println(strikeCount + "스트라이크");
            else if (strikeCount == 0 && ballCount != 0) System.out.println(ballCount + "볼");
            else if (strikeCount == 0) System.out.println("낫싱");
            else {
                System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
            }

            // 2-4. 만약 전부 완료하게 된다면, 게임을 다시 시작할지, 아니면 종료할지 선택.
            if (strikeCount == 3) {
                System.out.println(GAME_END.getMessage());
                System.out.println(GAME_RESTART.getMessage());

                int n = scanner.nextInt();
                if (n == 1) {
                    System.out.println(GAME_START.getMessage());
                    computer.resetNumbers();
                }
                if (n == 2) flag = 2;
            }
        }


    }
}
