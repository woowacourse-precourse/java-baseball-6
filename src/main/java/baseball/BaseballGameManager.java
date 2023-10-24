package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;


public class BaseballGameManager {

    private static final int INPUT_CNT = 3;
    private static final int GAME_CONTINUE = 1;
    private static final int GAME_TERMINATE = 2;

    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        int gameProcess = GAME_CONTINUE;

        while (gameProcess != GAME_TERMINATE) {
            Baseball baseball = new Baseball();
            NumberHandler numberHandler = new NumberHandler(INPUT_CNT);

            List<Integer> randNumList = numberHandler.generateRandomNumberList();
            List<Integer> userInput;
            boolean isAllStrike = false;

            while(!isAllStrike) {
                userInput = numberHandler.inputUserNumbers();
                isAllStrike = baseball.judgeBaseball(randNumList, userInput);

                if (isAllStrike) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String restart = Console.readLine();
                    if(restart.length() > 1) throw new IllegalArgumentException();
                    gameProcess = Character.getNumericValue(restart.charAt(0));
                    if(gameProcess != GAME_TERMINATE && gameProcess != GAME_CONTINUE) throw new IllegalArgumentException();
                }
                baseball.initBaseball();
            }
        }
    }

}
