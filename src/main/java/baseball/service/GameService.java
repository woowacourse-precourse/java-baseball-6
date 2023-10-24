package baseball.service;
// 새로운 게임 시작
// user 입력 저장
// 결과 반환 -> outputview로 반환

import baseball.domain.Game;
import baseball.view.OutputView;

public class GameService {
    private Game game;

    public GameService(Game game) {
        this.game = game;
    }

    public void startNewGame() {
        game.resetGame();
    }

    public void playGame(String userInput) {
        int[] userNumbers = parseUserInput(userInput);

        game.updateGameResult(userNumbers);

        if (game.isWin()) {
            OutputView.printGameResult(3, 0); // 3스트라이크 출력
        } else {
            int strikes = game.getStrikes();
            int balls = game.getBalls();
            OutputView.printGameResult(strikes, balls);
        }

    }
    // 사용자 입력 문자열을 파싱하여 숫자 배열로 변환
    private int[] parseUserInput(String userInput) {
        int[] userNumbers = new int[3];

        if (userInput.length() != 3) {
            return null;
        }

        for (int i = 0; i < 3; i++) {
            char c = userInput.charAt(i);
            if (!Character.isDigit(c)) {
                return null; // 숫자가 아닌 문자가 있는 경우 유효하지 않은 입력
            }
            userNumbers[i] = Character.getNumericValue(c);
        }

        return userNumbers;
    }
}
