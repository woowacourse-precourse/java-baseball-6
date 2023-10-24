package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomService {

  public RandomService(){}

  /*
      설명서 :
      random 값을 셋으로 3자리를 만들어 뱉어주는 램덤기계
      pickNumber의 값을 사용하면 원하는 값을 List<Integer> 로 뱉어준다.
   */

    public static List<Integer> randomValue(int pickNumber){
        Set<Integer> setList = new HashSet<>();
          while(setList.size() < pickNumber){
            int ran = Randoms.pickNumberInRange(1,9);
            setList.add(ran);
          }
        List<Integer> ranList = new ArrayList<>(setList);
    return ranList;
    }
}
