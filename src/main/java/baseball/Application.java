package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

  public static List<Integer> make_computer() { // 컴퓨터의 랜덤값 지정
    List<Integer> com = new ArrayList<>();
    while (com.size() < 3) {
      int randomNumber = Randoms.pickNumberInRange(1, 9);
      if (!com.contains(randomNumber)) {
        com.add(randomNumber);
      }
    }
    return com;
  }

  public static List<Integer> get_user() { // 사용자의 입력값 받기
    List<Integer> us = new ArrayList<>();
    String s = Console.readLine();

    for (int i = 0; i < s.length(); i++) {
      int currenChar = Character.getNumericValue(s.charAt(i));
      us.add(currenChar);
    }

    return us;
  }


  public static int gostop() { // 게임을 더 진행하는지 확인
    String s = Console.readLine();
    int result = Character.getNumericValue(s.charAt(0));
    return result;
  }


  public static void main(String[] args) {
    List<Integer> computer = new ArrayList<>(); // 컴퓨터 List 선언

    System.out.println("숫자 야구 게임을 시작합니다.");
    computer = make_computer(); // 컴퓨터 랜덤값 가져오기

    while (true) {
      int ball = 0; // ball값 초기화
      int strike = 0; // strike값 초기화

      System.out.println("컴퓨터 ; " + computer);

      System.out.print("숫자를 입력해주세요 : ");

      List<Integer> user = new ArrayList<>(); // 사용자 List 선언
      user = get_user(); // 사용자 입력값 가져오기

      // 예외처리
      if (user.size() < 3 || user.size() > 3) {
        throw new IllegalArgumentException();
      }

      // 문자열 확인하기
      for (int i = 0; i < user.size(); i++) {
        for (int j = 0; j < user.size(); j++) {
          if (computer.get(i) == user.get(j)) {
            if (i == j) {
              strike++;
            } else {
              ball++;
            }
          }
        }
      }

      // 게임 결과 출
      if (ball != 0) {
        System.out.print(ball + "볼 ");
      }
      if (strike != 0) {
        System.out.print(strike + "스트라이크");
      }
      if (ball == 0 && strike == 0) {
        System.out.print("낫싱");
      }
      // 정답을 맞췄을 경우
      if (strike == 3) {
        System.out.println();
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        if (gostop() == 1) {
          strike = 0; // strike 초기화
          computer = make_computer(); // 컴퓨터값 변경
          ball = 0; // ball 초기화
          strike = 0; // strike 초기화
          continue;
        } else {
          break;
        }
      }
      System.out.println();
    }
  }
}
