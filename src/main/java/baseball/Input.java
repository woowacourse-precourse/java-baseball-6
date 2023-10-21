package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import net.bytebuddy.implementation.bytecode.Throw;

public class Input {
  public List<Integer> Input_num() {

    System.out.println("숫자를 입력해주세요 : ");
    List<Integer> Input_num = new ArrayList<>();
    String input = Console.readLine();

    for(String number : input.split("")) {
      Input_num.add(Integer.parseInt(number));
    }
    exception_Length(input);

    return Input_num;
  }   
  
  public void exception_Length(String s){
    if(s.length() != Application.size) {
        throw new IllegalArgumentException("세자리 수보다 크거나 작음");
    }
    System.out.println();
}
}
