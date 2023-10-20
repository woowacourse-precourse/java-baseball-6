package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserNumber {

  int userNumber;

  public UserNumber(int userNumber) {
    this.userNumber = userNumber;

  }

  public int getUserNumber() {
    return userNumber;
  }

  public void readUserNumberFromConsole() {
    this.userNumber = parseUserNumber(Console.readLine());
  }

  public void setUserNumberForTest(String input) {
    this.userNumber = parseUserNumber(input);
  }

  private int parseUserNumber(String input) {
    return Integer.parseInt(input);
  }
}