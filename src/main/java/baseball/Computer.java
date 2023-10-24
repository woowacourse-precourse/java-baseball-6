package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
  
  ArrayList<Integer> comNumbers = new ArrayList<Integer>();


  public ArrayList<Integer> getComNumbers() {
    return comNumbers;
  }

  public void init() {
    comNumbers.clear();
    while(comNumbers.size()<3){
      int pickedNum= Randoms.pickNumberInRange(1,9);
      if(comNumbers.contains(pickedNum))
        continue;
      comNumbers.add(pickedNum);
    }
//    System.out.println(comNumbers);
  }
 
   
  
}
