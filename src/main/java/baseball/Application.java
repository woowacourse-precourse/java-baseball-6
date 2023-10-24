package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;

public class Application {
  public static void main(String[] args) {
    // TODO: 프로그램 구현
    List<Integer> computer = new ArrayList<>();
    while (computer.size() < 3) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }
    String startMsg = "숫자 야구 게임을 시작합니다.";
    String inputMsg = "숫자를 입력해주세요 : ";
    System.out.println(startMsg);
    while (true) {
      System.out.print(inputMsg);
      String guessNumber = Console.readLine();
      System.out.println(guessNumber);
      List<Integer> guessNumberList = new ArrayList<>();

      // 입력받아서 숫자 list에 추가
      for (int i = 0; i < guessNumber.length(); i++) {
        char digitChar = guessNumber.charAt(i); // 문자열의 i번째 문자를 가져옴
        int digit = Character.getNumericValue(digitChar); // 문자를 정수로 변환
        guessNumberList.add(digit); // List에 추가
      }
      if (guessNumberList.size() != 3) {
        //IllegalArgumentException 발생
        throw new IllegalArgumentException("잘못된 입력입니다.");
      }
      int strikeCount = 0;
      int ballCount = 0;

      for (int i = 0; i < guessNumberList.size(); i++) {
        boolean containCheck = computer.contains(guessNumberList.get(i));

        if (containCheck) {
          if (computer.get(i) == guessNumberList.get(i)) {
            strikeCount += 1;
          } else {
            ballCount += 1;
          }
        }
      }

      if (strikeCount == 3) {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restart = Console.readLine();
        if (restart.equals("1")){
          computer = new ArrayList<>();
          while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
              computer.add(randomNumber);
            }
          }
          if (guessNumberList.size() != 3) {
            //IllegalArgumentException 발생
            throw new IllegalArgumentException("잘못된 입력입니다.");
          }
        } else if (restart.equals("2")){
          break;
        }
      } else if (strikeCount == 0 & ballCount == 0) {
        System.out.println("낫싱");
      } else if (strikeCount != 0 & ballCount != 0) {
        String result = String.format("%d볼 %d스트라이크", ballCount, strikeCount);
        System.out.println(result);
      } else if (strikeCount != 0) {
        String result = String.format("%d스트라이크", strikeCount);
        System.out.println(result);
      } else if (ballCount != 0) {
        String result = String.format("%d볼", ballCount);
        System.out.println(result);
      }
    }
  }
}
