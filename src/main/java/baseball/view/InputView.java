package baseball.view;

public class InputView {

  private final String inputMessage = "숫자를 입력해주세요 : ";
  private final String restartMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

  public void displayInputMessage() {
    System.out.println(inputMessage);
  }

  public void displayRestartMessage() {
    System.out.println(restartMessage);
  }


}
