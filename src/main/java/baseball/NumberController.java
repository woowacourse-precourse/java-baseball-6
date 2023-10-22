package baseball;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberController {

  public List<Integer> generate() {
    List<Integer> numList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
    Collections.shuffle(numList);

    List<Integer> result = new ArrayList<>(3);
    result.add(numList.get(0));
    result.add(numList.get(1));
    result.add(numList.get(2));

    return result;
    }

    public List<Integer> splitter(int num) {
      List<Integer> numList = new ArrayList<>(3);

      numList.add(num/100);
      numList.add((num%100)/10);
      numList.add(num%10);

      return numList;
    }

    public Map compareNumberList(List<Integer> numList1, List<Integer> numList2) {
      Map<String, Integer> result = new HashMap<>();
      result.put("strike", 0);
      result.put("ball", 0);

      int strike = 0;
      int ball = 0;

      for(int i=0; i<3; i++) {
        for(int j=0; j<3; j++) {
          if(numList1.get(i)==numList2.get(j) && i==j) {
            strike++;
          }
          else if (numList1.get(i)==numList2.get(j)) {
            ball++;
          }
        }
      }

      if(strike==0 && ball==0) {
        return result;
      }

      result.replace("strike", strike);
      result.replace("ball", ball);

      return result;
    }

}
