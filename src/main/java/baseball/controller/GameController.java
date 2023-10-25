package baseball.controller;

import baseball.input.GameControlInput;
import baseball.input.NumberInput;
import baseball.model.Game;
import baseball.util.NumberGenerator;
import baseball.view.GameView;

import java.util.List;

/**
 * 게임의 흐름을 제어하는 클래스입니다.
 * 사용자 입력을 받아 게임의 로직을 실행하고, 결과를 출력하는 역할을 합니다. 또한 게임의 종료 및 재시작에 대한 결정도 처리합니다.
 *
 * <p>주요 기능:
 * <ul>
 *   <li>게임 시작 메시지 출력</li>
 *   <li>사용자로부터 숫자 입력 받기</li>
 *   <li>게임 결과 출력</li>
 *   <li>게임 재시작 여부 확인 및 처리</li>
 * </ul>
 * </p>
 */
public class GameController {

    private static final int REQUIRED_STRIKES_TO_WIN = 3;

    private final Game game;
    private final GameView gameView;
    private final NumberInput numberInput;
    private final GameControlInput gameControlInput;

    /**
     * GameController 객체를 생성합니다.
     *
     * @param game 게임 로직을 처리하는 Game 객체
     * @param gameView 게임의 화면 출력을 담당하는 GameView 객체
     * @param numberInput 사용자로부터 숫자 입력을 받는 NumberInput 객체
     * @param gameControlInput 사용자로부터 게임 컨트롤 입력(예: 재시작, 종료)을 받는 GameControlInput 객체
     */
    public GameController(Game game, GameView gameView, NumberInput numberInput, GameControlInput gameControlInput) {
        this.game = game;
        this.gameView = gameView;
        this.numberInput = numberInput;
        this.gameControlInput = gameControlInput;
    }

    /**
     * 게임을 시작하고, 게임의 전체 흐름을 제어하는 메서드입니다.
     * 사용자로부터 숫자를 입력받아 결과를 출력하며, 필요한 경우 게임을 재시작합니다.
     */
    public void startGame() {
        gameView.printStartGameMessage();

        while (true) {
            gameView.printInputNumbersMessage();
            List<Integer> userInput = numberInput.getInput();
            int strikes = game.countStrikes(game.getComputerSelectedNumbers(), userInput);
            int balls = game.countBalls(game.getComputerSelectedNumbers(), userInput);

            gameView.displayResult(strikes, balls);

            if (strikes == REQUIRED_STRIKES_TO_WIN) {
                gameView.displayGameEndMessage();
                gameView.printPlayAgainMessage();
                String input = gameControlInput.getInput();
                if (!input.equals("1")) {
                    break;
                }
                game.resetGame(NumberGenerator.generateUniqueNumbers());
            }
        }
    }
}
