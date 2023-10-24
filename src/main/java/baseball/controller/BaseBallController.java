package baseball.controller;

import static baseball.domain.number.InputNumbers.INPUT_NUMBER_LENGTH;

import baseball.domain.number.InputNumbers;
import baseball.domain.number.RandomNumbers;
import baseball.domain.result.GameResult;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallController {

  private static final String IS_NOT_ONE_OR_TWO_ERROR_MESSAGE = "1과 2중 입력해야 합니다.";
  private static final String RESTART_GAME_CODE = "1";
  private static final String END_GAME_CODE = "2";
  private static final int GAME_END_STRIKE_COUNT = 3;

  private final InputView inputView;
  private final OutputView outputView;

  public BaseBallController(final InputView inputView, final OutputView outputView) {
    this.inputView = inputView;
    this.outputView = outputView;
  }

  public void run() {
    do {
      play();
    } while (restart());
  }

  private void play() {
    int strikeCount, ballCount;
    outputView.printGameStartMessage();
    final RandomNumbers randomNumbers = RandomNumbers.create();
    do {
      final InputNumbers inputNumbers = makeInputNumbers();
      strikeCount = countStrikes(randomNumbers, inputNumbers);
      ballCount = countBalls(randomNumbers, inputNumbers);
      final String gameResultMessage = makeGameResult(strikeCount, ballCount);
      outputView.printGameResultMessage(gameResultMessage);
    } while (strikeCount != GAME_END_STRIKE_COUNT);
    outputView.printGameEndMessage();
  }

  private InputNumbers makeInputNumbers() {
    final String input = inputView.readNumbers();
    return InputNumbers.of(input);
  }

  private int countStrikes(final RandomNumbers randomNumbers, final InputNumbers inputNumbers) {
    int strikeCount = 0;
    for (int i = 0; i < INPUT_NUMBER_LENGTH; i++) {
      if (randomNumbers.get(i).equals(inputNumbers.get(i))) {
        strikeCount++;
      }
    }
    return strikeCount;
  }

  private int countBalls(final RandomNumbers randomNumbers, final InputNumbers inputNumbers) {
    int ballCount = 0;
    for (int i = 0; i < INPUT_NUMBER_LENGTH; i++) {
      if (randomNumbers.contains(inputNumbers.get(i))
          && !randomNumbers.get(i).equals(inputNumbers.get(i))) {
        ballCount++;
      }
    }
    return ballCount;
  }

  private String makeGameResult(int strikeCount, int ballCount) {
    final GameResult gameResult = GameResult.of(strikeCount, ballCount);
    return gameResult.toString();
  }

  private boolean restart() {
    final String gameCode = inputView.readGameCode();
    if (gameCode.equals(RESTART_GAME_CODE)) {
      return true;
    }
    if (gameCode.equals(END_GAME_CODE)) {
      return false;
    }
    throw new IllegalArgumentException(IS_NOT_ONE_OR_TWO_ERROR_MESSAGE);
  }
}
