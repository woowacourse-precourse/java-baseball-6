package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    GameManager() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public List<Integer> getUserTrialInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLine();
        InputValidator.checkUserTrialInput(userInput);

        List<Integer> userInputList = new ArrayList<>();
        for (char c : userInput.toCharArray()) {
            userInputList.add(c - '0');
        }

        return userInputList;
    }

    public int getUserRestartInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String userInput = readLine();
        InputValidator.checkUserRestartInput(userInput);

        return Integer.parseInt(userInput);
    }

    public boolean askGameEnd() {
        return getUserRestartInput() == 2;
    }

    public void newGameStart() {
        Game game = new Game();

        while (true) {
            List<Integer> userInputList = getUserTrialInput();
            GameResult gameResult = game.getGameResult(userInputList);
            System.out.println(gameResult);

            if (gameResult.isAllStrike()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    public void clear() {
        camp.nextstep.edu.missionutils.Console.close();
    }
}
