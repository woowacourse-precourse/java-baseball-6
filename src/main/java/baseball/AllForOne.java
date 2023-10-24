package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class AllForOne {


  protected static List<Integer> list(){
  List<Integer> Computer =
      Randoms.pickUniqueNumbersInRange(1,9,3);
  System.out.println(Computer);
  return Computer;
  }
  protected static void main(String[] args) {

    System.out.println("숫자 야구 게임을 시작합니다");
    List<Integer> Computer = list();

    outLoop:
    while(true) {
      System.out.println("숫자를 입력해주세요 : ");

      try {
        String userChat = Console.readLine();
        if (userChat.trim().isEmpty()) {throw new IllegalArgumentException("빈 문자열 예외");}
        if (userChat.length() != 3) {throw new IllegalArgumentException("입력 3칸이 초과");}

        int num0 = Character.getNumericValue(userChat.charAt(0));
        int num1 = Character.getNumericValue(userChat.charAt(1));
        int num2 = Character.getNumericValue(userChat.charAt(2));

        if (num0 == num1) {
          throw new IllegalArgumentException("첫번째 두번째 같은 수 입력");
        } else if (num0 == num2) {
          throw new IllegalArgumentException("첫번째 세번째 같은 수 입력");
        } else if (num1 == num2) {
          throw  new IllegalArgumentException("두번째 세번째 같은 수 입력");
        }

        List<Integer> userNumbers = new ArrayList<>();
        userNumbers.add(num0);
        userNumbers.add(num1);
        userNumbers.add(num2);
        System.out.println(userNumbers);


        for (int num : userNumbers) {
          if (num >= 10) { throw new IllegalArgumentException("문자발견");}
          else if (num < 1) {throw new IllegalArgumentException("0/음수발견");}
        }

        int st = 0;
        int ball = 0;
        int count = 0;

        for (int i = 0; i <= 2; i++){
          for (int j = 0; j <= 2; j++){
            if      (Computer.get(i) == userNumbers.get(i)) { st ++; break; }
            else if (Computer.get(i).equals(userNumbers.get(j))) { ball ++; break; }
            else                                            { count ++; }
          }
        }

        if (st != 0){
          System.out.print(st + "스트라이크 ");
        }
        if (ball != 0) {
          System.out.println(ball + "볼");
        }
        if (count == 9) {
          System.out.println("낫씽");
        }
        if (st == 3){
          System.out.println();
          System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
          System.out.println("새로운 게임을 시작하려면 1, 종료하려면 2를 입력하세요");

          String RePlay = Console.readLine();

          switch (Character.getNumericValue(RePlay.charAt(0))) {
            case 1: Computer = list(); continue outLoop;
            case 2:            return;
            default: System.out.println("1/2 이외의 수 발견 : 프로그램을 종료합니다.");
          }
        }

      } catch (IllegalArgumentException e){
        System.err.println(e.getMessage());
        break;
      }}}


}
