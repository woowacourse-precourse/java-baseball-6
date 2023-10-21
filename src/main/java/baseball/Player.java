package baseball;

public class Player {

  public Player() {
  }

  public boolean validateInput(String input) {
    if (input.length() != 3) {
      return false;
    }
    for (Character ch : input.toCharArray()) {
      if (ch  < '0' || ch > '9') {
        return false;
      }
    }
    return true;
  }
}
