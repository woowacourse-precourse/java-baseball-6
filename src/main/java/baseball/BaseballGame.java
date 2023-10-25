package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class BaseballGame {
  private static int ball = 0, strike = 0;

  public static void play() {
    List<Integer> computer = Computer.createAnswer();//서로 다른 3자리 수 생성

    while (strike != Constants.INPUT_SIZE) {
      ball = 0;
      strike = 0;

      System.out.printf("숫자를 입력해주세요 : ");
      String num = readLine();

      Input.verifiedInput(num);

      isStrikeOrBall(num, computer);

      Output.getHint(ball, strike);//입력한 수에 대한 결과 출력
    }

    Output.endMessage();
    int restart = Integer.parseInt(readLine());

    if (isRestart(restart)) {
      ball = 0;
      strike = 0;
      play();
    }
  }

  private static void isStrikeOrBall(String num, List<Integer> computer) {
    for (int pos = 0; pos < Constants.INPUT_SIZE; pos++) {
      int m = Character.getNumericValue(num.charAt(pos));
      int index = computer.indexOf(m);

      isStrike(index, pos);
      isBall(index, pos);
    }
  }

  private static void isBall(int index, int pos) {
    if (index != pos && index != -1) {
      ball++;
    }
  }

  private static void isStrike(int index, int pos) {
    if (index == pos) {
      strike++;
    }
  }

  private static boolean isRestart(int restart) {
    if (restart != 1 && restart != 2) {
      throw new IllegalArgumentException("1또는 2를 입력하세요");
    }
    if (restart == 2) {
      return false;
    }

    return true;
  }

}
