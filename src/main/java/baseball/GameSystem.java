package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class GameStart {

  public GameStart() {
    //컴퓨터의 값을 랜덤값으로 초기화한다.
    Computer computer = new Computer();

    //게임을 진행한다.
    System.out.println("숫자 야구 게임을 시작합니다.");
    while (true) {
      System.out.print("숫자를 입력해주세요 : ");
      //숫자를 입력받는다
      List<Integer> player = convertStringToList(readLine());
      System.out.println("user input : " + player);
      //받은 입력값을 예외처리

      //컴퓨터와 숫자 비교 후 출력
      CheckNum checkNum = new CheckNum(computer.getNum(), player);
      String result = checkNum.Check();
      System.out.println(result);
    }
    //게임을 종료하거나 다시 시작한다.
  }

  public static List<Integer> convertStringToList(String str) {
    List<Integer> result = new ArrayList<>();

    for (char c : str.toCharArray()) {
      if (Character.isDigit(c)) { // 숫자인지 확인
        result.add(Character.getNumericValue(c));
      } else {
        throw new IllegalArgumentException("String contains non-numeric characters");
      }
    }

    return result;
  }
}