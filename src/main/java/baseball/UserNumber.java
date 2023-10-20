package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class UserNumber {

  private static final String REGEX = "[0-9]{3}";
  private static final int VALID_LENGTH = 3;
  private static final String REQUEST_MESSAGE = "숫자를 입력해주세요 : ";
  private static final String CHECK_TYPE = "CheckType :";

  private int userNumber;

  public UserNumber() {
  }

  public int getUserNumber() {
    return userNumber;
  }

  public void setUserNumber(String input) {
    validateInput(input);
    this.userNumber = parseUserNumber(input);
  }

  public void readUserNumberFromConsole() {
    System.out.println(REQUEST_MESSAGE);
    String input = Console.readLine();
    validateInput(input);
    this.userNumber = parseUserNumber(input);
  }

  private void validateInput(String input) {
    boolean isValidLength = input.length() == VALID_LENGTH;
    boolean isValidType = Pattern.matches(REGEX, input);
    System.out.println(CHECK_TYPE + isValidType);

    if ("1".equals(input.trim()) || "2".equals(input.trim())) {
      return; // Skip validation for game control commands
    }
    
    if (!(isValidLength && isValidType)) {
      throw new IllegalArgumentException();
    }
  }

  private int parseUserNumber(String input) {
    return Integer.parseInt(input);
  }
}