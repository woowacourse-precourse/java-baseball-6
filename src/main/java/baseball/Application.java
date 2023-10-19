package baseball;



import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.print("@");





      ArrayList<Integer> comArr = new ArrayList<Integer>(3);
        for(int i=0;i<3;i++){
          comArr.add(Randoms.pickNumberInRange(1,9));
        }
      System.out.print(comArr);
        
    }
}
