package baseball;

import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BaseBall baseBall = new BaseBall(scanner);

        /*
        숫자 야구를 시작합니다.
        랜덤하게 생성한 1~9 사이의 숫자를 중복없이 3개를 골라 리스트를 만들고
        사용자가 맞출 때까지 진행합니다.
        한 게임이 종료되면 추가 진행여부를 물어 게임을 계속할 수 있습니다.
         */
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            List<Integer> randomList = baseBall.getRandomList();
//            System.out.println(randomList);

            baseBall.play(randomList);

            boolean wantGameMore = baseBall.endGame();
            if (!wantGameMore) {
                return;
            }
        }
    }
}
