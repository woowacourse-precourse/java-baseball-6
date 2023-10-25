package baseball.utils;

public final class Constants {

  public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
  public static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
  public static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
  public static final String GAME_RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
  public static final String GUESS_NUMBER_ERROR_MESSAGE = "1-9 사이에 숫자 중 중복되지 않는 3자리를 입력해주세요.";
  public static final String EXIT_NUMBER_ERROR_MESSAGE = "1,2 중 하나를 입력해주세요. [1 : 재시작, 2 : 종료]";
  public static final String STRIKE = "스트라이크";
  public static final String BALL = "볼 ";
  public static final String NOTHING = "낫싱";
  public static final String GAME_RESTART = "1";
  public static final String GAME_END = "2";
  public static final String GUESS_NUMBER_REGEX = "^(?!.*(\\d).*\\1)[1-9]{3}$";

  private Constants() {
  }
}
