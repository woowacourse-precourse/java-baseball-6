package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

  private static Set<Integer> list(){
    Set<Integer> list = new HashSet<>();
    while(list.size() < 3) {
      list.add(Randoms.pickNumberInRange(1,9));
    }
    System.out.println(list);
    return list;
  }
  private static List<Integer> stringChangeIntegerList(String input){
    List<Integer> numbers = new ArrayList<>();
    for (char c : input.toCharArray()){
      numbers.add(Character.getNumericValue(c));
    }
    return numbers;
  }

  public static void main(String[] args) {

    System.out.println("숫자 야구 게임을 시작합니다");
    List<Integer> Computer = new ArrayList<>();
    Computer.addAll(list());

    outLoop:
    while(true) {
      System.out.println("숫자를 입력해주세요 : ");

      try {
        String userChat = Console.readLine();
        if (userChat.trim().isEmpty()) {throw new IllegalArgumentException("빈 문자열 예외");}
        if (userChat.length() != 3) {throw new IllegalArgumentException("입력 3칸이 초과");}

        List<Integer> userNumbers = stringChangeIntegerList(userChat);
        System.out.println(userNumbers);

        if (new HashSet<>(userNumbers).size() != userNumbers.size()){
          System.out.println(new HashSet<>(userNumbers).size());
          System.out.println(userNumbers.size());
          throw new IllegalArgumentException("중복된 숫자 발견");
        }


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

        if (ball != 0) {
          System.out.print(ball + "볼");
        }
        if (st != 0){
          System.out.println(st + "스트라이크 ");
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
            case 1: Computer.clear(); Computer.addAll(list()); continue outLoop;
            case 2:            return;
            default: System.out.println("1/2 이외의 수 발견 : 프로그램을 종료합니다.");
          }
        }

      } catch (IllegalArgumentException e){
        System.err.println(e.getMessage());
        break;
      }}}
}