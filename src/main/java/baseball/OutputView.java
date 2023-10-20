package baseball;

public class OutputView {
  private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
  private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
  private static final String HIT_BALL_MESSAGE = "";
  private static final String HIT_STRIKE_MESSAGE = "";
  private static final String HIT_NOTHING_MESSAGE = "";
  private static final String GAME_SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
  private static final String GAME_RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

  public void printStartGameMessage() {
    System.out.println(START_GAME_MESSAGE);
  }

  public void printInputMessage() {
    System.out.println(INPUT_NUMBER_MESSAGE);
  }

  public void printGameSuccessMessage() {
    System.out.println(GAME_SUCCESS_MESSAGE);
  }

  public void printRestartOrEndMeesage() {
    System.out.println(GAME_RESTART_OR_END_MESSAGE);
  }
}
