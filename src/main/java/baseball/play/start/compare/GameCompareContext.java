package baseball.play.start.compare;

import baseball.play.start.input.GameStartedEvent;
import java.util.Arrays;
import java.util.List;

public class GameCompareContext {

  public static GameResult<ResumingGame, WinningGame> compare(GameStartedEvent event) {
    String input = event.getInputNum().getInput();
    String randomNums = event.getRandomNums();
    if (input.equals(randomNums)) {
      return GameResult.win(new ThreeStrike());
    }
    List<String> inputs = Arrays.asList(input.split(""));
    List<String> randomNumList = Arrays.asList(randomNums.split(""));
    int ballCount = 0;
    int strikeCount = 0;
    for (int i = 0; i < inputs.size(); i++) {
      if (inputs.get(i).equals(randomNumList.get(i))) {
        strikeCount++;
        continue;
      }
      if (randomNumList.contains(inputs.get(i))) {
        ballCount++;
      }
    }
    return categorizeResume(ballCount, strikeCount, randomNums);
  }

  //볼과 스트라이크의 개수에 결과를 분류한다.
  private static GameResult<ResumingGame, WinningGame> categorizeResume(
      int ballCount, int strikeCount, String randomNums) {
    return switch (ballCount * 10 + strikeCount) {
      case 0 -> GameResult.resume(new Nothing(randomNums));
      case 10 -> GameResult.resume(new OneBall(randomNums));
      case 1 -> GameResult.resume(new OneStrike(randomNums));
      case 20 -> GameResult.resume(new TwoBall(randomNums));
      case 11 -> GameResult.resume(new OneBallOneStrike(randomNums));
      case 2 -> GameResult.resume(new TwoStrike(randomNums));
      case 12 -> GameResult.resume(new OneBallTwoStrike(randomNums));
      case 21 -> GameResult.resume(new TwoBallOneStrike(randomNums));
      default -> GameResult.resume(new ThreeBall(randomNums));
    };
  }
}
