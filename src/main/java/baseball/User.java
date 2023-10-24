package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class User {
  public ArrayList<Integer> getUserNumbers() {
    return userNumbers;
  }

  ArrayList<Integer> userNumbers = new ArrayList<Integer>();
  public  void inputUserNumbers(){
    userNumbers.clear();
    String input = Console.readLine();
    for(int i=0;i<3;i++){
      userNumbers.add(input.charAt(i)-'0');
    }

  }
}
