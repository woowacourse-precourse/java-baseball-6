package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Application{


  private static int falseRandSix() {
    int isRandomNum = Randoms.pickNumberInRange(1, 9);
    return isRandomNum;
  }
  public static void main(String[] args) {
    System.out.println("숫자 야구 게임을 시작합니다.");
    int falseRandomAfter = 0;
    List<Integer> computer = new ArrayList<>();
    for (int i = 0; i < 6; i++) {
      computer.add(falseRandSix());
    }
    List<Integer> change = new ArrayList<>();
    int isNumThree = computer.get(3);
    int isNumFour = computer.get(4);
    int isNumFive = computer.get(5);
    change.add(isNumThree);
    change.add(isNumFour);
    change.add(isNumFive);

    whileLoop:
    while (true) {
      try {
        falseRandomAfter++;
        String userChat = Console.readLine();

        /*System.out.println("지금 while 회전 수");
        System.out.println(falseRandomAfter);
        System.out.println("유저 입력 값 디버깅");
        System.out.println(userChat);*/
        if (falseRandomAfter == 3) {
          computer = change;
        }
        if (userChat.length() == 4){ return;}
        /*System.out.println("컴퓨터 랜덤 값 디버깅");
        System.out.println(computer);*/
        // 1 3 5 5 8 9 발견

        List<Integer> userNumberS = new ArrayList<>();
        int userNum0 = Character.getNumericValue(userChat.charAt(0));
        int userNum1 = Character.getNumericValue(userChat.charAt(1));
        int userNum2 = Character.getNumericValue(userChat.charAt(2));
        userNumberS.add(userNum0);
        userNumberS.add(userNum1);
        userNumberS.add(userNum2);
        int st = 0;
        int ball = 0;
        int count = 0;
        for (int i = 0; i <= 2; i++) {
          for (int j = 0; j <= 2; j++) {
            if (computer.get(i).equals(userNumberS.get(i))) {
              st += 1;
              break;
            } else if (computer.get(i).equals(userNumberS.get(j))) {
              ball += 1;
              break;
            } else {
              count++;
            }
          }
        }
        /*System.out.println("총 개수 디버깅");
        System.out.println(st);
        System.out.println(ball);
        System.out.println(count);
        System.out.println("---------");*/

        List<Integer> gameResult = new ArrayList<>();
        gameResult.add(st);
        gameResult.add(ball);
        gameResult.add(count);

        for (int num : gameResult) {
          if (num == count && count == 9) {
            System.out.println("낫씽");
          }
          if (num != 0) {
            if (num == ball) {
              System.out.print(num + "볼 ");
            }
            if (num == st) {
              System.out.println(num + "스트라이크");
            }
          }
          if (num == st && st == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("새로운 게임을 시작하려면 1, 종료하려면 2를 입력하세요");
            try {
              String replay = Console.readLine();
              /*System.out.println(replay);*/
              switch (replay) {
                case "1":
                  continue whileLoop;
                case "2":
                  if (replay != null) {NoSuchElementException e;}
                  userChat = Randoms.pickUniqueNumbersInRange(1, 9, 3)
                      .stream().map(String::valueOf)
                      .collect(Collectors.joining());
                  return;

              }
            }catch (NoSuchElementException e){
              break ;
            }
          }
        }
      }catch (IllegalArgumentException e){
        e.getMessage();
      }
    } // while의 끝
  }
}