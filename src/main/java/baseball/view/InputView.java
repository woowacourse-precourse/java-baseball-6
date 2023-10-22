package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

  private static final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
  private static final String INPUT_GAME_CODE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

  public String readNumbers() {
    System.out.print(INPUT_NUMBERS_MESSAGE);
    return readLine();
  }

  public String readGameCode() {
    System.out.println(INPUT_GAME_CODE_MESSAGE);
    return readLine();
  }
}
