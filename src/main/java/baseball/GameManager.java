package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class GameManager {
  static ArrayList<Integer> resultArr = new ArrayList<Integer>();

  public static void setIsGameRestart(boolean isGameRestart) {
    GameManager.isGameRestart = isGameRestart;
    
  }

  static boolean isGameRestart = true;

  static {
  resultArr.add(0);
  resultArr.add(0);
}  
 
  public static void initGameManager(){
    resultArr.set(0,0);
    resultArr.set(1,0);
    isGameRestart = true;
  }


 
  public static void calculateResult(ArrayList<Integer> userNumbers, ArrayList<Integer> comNumbers){
    int strikeCnt=0, ballCnt=0;
   

    for(int i=0;i<3;i++){
      for(int j=0;j<3;j++) {
        if (i == j && userNumbers.get(i) == comNumbers.get(j)) {
          strikeCnt++;
        } else if (i != j && userNumbers.get(i) == comNumbers.get(j)) {
          ballCnt++;
        }
      }
    }
    resultArr.set(0,ballCnt);
    resultArr.set(1,strikeCnt);
    
  }
  public static boolean isGameEnd(){
    return resultArr.get(1)==3;
  }


}
