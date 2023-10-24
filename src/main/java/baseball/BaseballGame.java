package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseballGame {
    private static boolean runningGame = true;
    private static final int MAX_NUM_LENGTH = 3;
    public static void setRunningGame(boolean runningGame) {
        BaseballGame.runningGame = runningGame;
    }

    public void getGame() {
        GetNumbers gn = new GetNumbers();
        List<Integer> computerNum = gn.getRandomNumber();
        getGameProcess(computerNum);
    }

    public void getGameProcess(List<Integer> computer) {
        while (runningGame) {
            getGameResult(computer);
        }
    }

    public void getGameResult(List<Integer> computer) {
        GetNumbers gn = new GetNumbers();
        List<Integer> user = gn.getUserInput();
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < MAX_NUM_LENGTH; i++) {
            if (computer.contains(user.get(i)) && !computer.get(i).equals(user.get(i))) {
                ballCount++;
            }
            if (computer.get(i).equals(user.get(i))) {
                strikeCount++;
            }
        }

        checkCountResult(ballCount, strikeCount);
    }

    public int selectExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int choice = Integer.parseInt(Console.readLine());
        int selectNum = 1;
        if (choice != 1) {
            selectNum = -1;
        }
        return selectNum;
    }

    public void checkCountResult(int ballCount, int strikeCount) {
        StringBuilder result = new StringBuilder();

        if (strikeCount == MAX_NUM_LENGTH) {
            result.append("3스트라이크 3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
            System.out.println(result);
            int userSelectNum = selectExit();
            if (userSelectNum == 1) {
                getGame();
            }
            if (userSelectNum == -1) {
                runningGame = false;
            }
            return;
        }

        getCountMessage(result, ballCount, strikeCount);
        System.out.println(result.toString().trim());
    }

    public void getCountMessage(StringBuilder result, int ballCount, int strikeCount) {
        if (ballCount > 0) {
            result.append(ballCount).append("볼 ");
        }

        if (strikeCount > 0) {
            result.append(strikeCount).append("스트라이크 ");
        }

        if (ballCount == 0 && strikeCount == 0) {
            result.append("낫싱");
        }
    }
}
