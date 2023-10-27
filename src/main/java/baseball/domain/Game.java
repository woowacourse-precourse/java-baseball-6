package baseball.domain;

import java.util.List;

public class Game {
   private List<Integer> targetNumberList;

   public List<Integer> getTargetNumberList() {
      return targetNumberList;
   }

   public void setTargetNumberList(List<Integer> randomNumberList) {
      this.targetNumberList = randomNumberList;
   }
}
