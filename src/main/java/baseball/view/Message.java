package baseball.view;

/*
클라이언트에게 출력되는 메시지
 */
public class Message {

  // 게임 안내 메시지
  public static final String GAME_START_PROMPT = "숫자 야구 게임을 시작합니다.\n";
  public static final String REQUEST_USER_GUESS = "숫자를 입력해주세요 ";
  public static final String RESTART_OR_QUIT_PROMPT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
  public static final String GAME_FINISH = "게임 종료\n";
  public static final String RETURN_GAME_RESULT_FORMAT = "%d개의 숫자를 모두 맞히셨습니다! ";

  // 에러 메시지
  public static final String INVALID_INPUT = "잘못된 입력입니다. 1 또는 2를 입력해야 합니다.";
  public static final String INVALID_DIGIT_COUNT = "3자리 수로 입력해주세요.";
  public static final String OUT_OF_RANGE = "숫자만 입력해주세요.";
}
