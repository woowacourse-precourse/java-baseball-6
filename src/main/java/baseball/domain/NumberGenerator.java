package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {

  public List<Integer> createRandomNumbers(){
    List<Integer> numbers = new ArrayList<>();

    while (numbers.size() < 3){
      int n = new Random().nextInt(9) +1;
      if (numbers.contains(n)){
        continue;
      } else {
        numbers.add(n);
      }
    }
    return numbers;
  }
}
