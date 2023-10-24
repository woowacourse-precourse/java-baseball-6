package baseball;

import java.util.Set;

public class Vaildate {
  public static final int INPUT_SIZE = 3;
  public static final int TRUE_NUMBER = 1;
  public static final int FALSE_NUMBER = 2;
  public static final String ERROR_3_NUMBER = "입력은 3자리 숫자로 이루어져야 합니다.";
  public static final String ERROR_DUPLICATION_NUMBER = "입력은 서로다른 숫자로 이루어져야 합니다.";
  public static final String ERROR_RESTART_NUMBER = "입력은 1(재시작) 또는 2(종료)로만 이루어져야 합니다.";
  public static final String ERROR_NOT_NUMBER = "입력은 숫자로만 이루어져야 합니다.";

  private static Vaildate vaildate;
  private Vaildate(){}

  public static Vaildate getInstance(){
    if(vaildate == null){
      synchronized (Vaildate.class) {
        if(vaildate == null) vaildate = new Vaildate();
      }
    }
    return vaildate;
  }


  public void validate(String[] input) throws IllegalArgumentException {
    if (input.length != INPUT_SIZE) {
      throw new IllegalArgumentException(ERROR_3_NUMBER);
    }
  }

  public void validate(Set<Integer> input) throws IllegalArgumentException {
    if (input.size() != INPUT_SIZE) {
      throw new IllegalArgumentException(ERROR_DUPLICATION_NUMBER);
    }
  }

  public void validate(String input) throws IllegalArgumentException {
    try {
      Integer.parseInt(input);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(ERROR_NOT_NUMBER);
    }
  }

  public void validate(int input) throws IllegalArgumentException {
    if (input != TRUE_NUMBER && input != FALSE_NUMBER) {
      throw new IllegalArgumentException(ERROR_RESTART_NUMBER);
    }
  }
}
