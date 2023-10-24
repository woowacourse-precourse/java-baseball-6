package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserChatService {

  public UserChatService(){}

  /*
      가이드 :
      유저 채팅 중 값을 담아내거나 예외를 처리하기 위한 Service.
   */

  public String inputChat(){
    System.out.print("숫자를 입력해주세요 : ");
    String input = Console.readLine();
    System.out.println();

    iaException(input);
    return input;
  }

  public String stringCaseNumber(){
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    String result = Console.readLine();
    return result;
  }

private Object iaException(String input){
  List<Integer> intExceptionTest;
  intExceptionTest = inputPasIntList(input);
    try {
      if (input.isEmpty()){throw new IllegalArgumentException("빈 문자");}
      if (input.length() != 3){throw new IllegalArgumentException("3글자 아님");}
      if (input.charAt(0) == input.charAt(1)
          || input.charAt(0) == input.charAt(2)
          || input.charAt(1) == input.charAt(2)){
        throw new IllegalArgumentException("중복 문자 발견");
      }
      for(int num : intExceptionTest){
        if(num >= 10){throw new IllegalArgumentException("지정된 값을 입력 하세요");}
        else if(num < 1){throw new IllegalArgumentException("0/음수 발견");}
      }
    }catch (IllegalArgumentException e){
      System.err.println(e.getMessage());
    }
    return 1;
}

  private List<Integer> inputPasIntList(String input){
    List<Integer> pasInt = new ArrayList<>();
    int num0 = Character.getNumericValue(input.charAt(0));
    int num1 = Character.getNumericValue(input.charAt(1));
    int num2 = Character.getNumericValue(input.charAt(2));
    pasInt.add(num0);
    pasInt.add(num1);
    pasInt.add(num2);
    return pasInt;
  }



}
