package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    private static final String GAME_OVER = "2";
    private static final String GAME_START = "1";
    private static final boolean CONTINUE = true;


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        String click = GAME_START;

        while (!click.equals(GAME_OVER)) {
            List<Integer> computerBall = RandomBall.makeRandomBall();
            boolean loop = CONTINUE;

            while (loop) {
                System.out.print("숫자를 입력해주세요 : ");
                String tempBall = Console.readLine();
                List<Integer> resultBall = CheckException.giveException(tempBall);
                loop = CheckBall.giveBallResult(resultBall, computerBall);
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            click = Console.readLine();
        }

    }
}
