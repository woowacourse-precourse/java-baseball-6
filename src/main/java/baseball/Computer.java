package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
  
  ArrayList<Integer> comNumbers = new ArrayList<Integer>();
  
  public Computer() {
    
  }

  public void init() {
    comNumbers.clear();
    while(comNumbers.size()<3){
      int pickedNum= Randoms.pickNumberInRange(1,9);
      if(comNumbers.contains(pickedNum))
        continue;
      comNumbers.add(pickedNum);
    }
    System.out.println(comNumbers);
  }
  public ArrayList<Integer> calculateResult(ArrayList<Integer> userNumbers){
    int strikeCnt=0, ballCnt=0;
    ArrayList<Integer> resultArr = new ArrayList<Integer>(2);
    
    for(int i=0;i<3;i++){
      for(int j=0;j<3;j++) {
        if (i == j && userNumbers.get(i) == this.comNumbers.get(j)) {
          strikeCnt++;
        } else if (i != j && userNumbers.get(i) == this.comNumbers.get(j)) {
          ballCnt++;
        }
      }
    }
    resultArr.add(ballCnt);
    resultArr.add(strikeCnt);
    return resultArr;
  }
   
  
}
