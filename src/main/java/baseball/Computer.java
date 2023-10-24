package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

  private List<Integer> computer;

  public Computer() {
    computer = new ArrayList<>();
  }


  public void makeRandomNumber() {
    while (computer.size() < 3) {
      int randomNumber = Randoms.pickNumberInRange(1, 9);
      if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);
      }
    }
  }

  public void compare(User user) {
    for (int i = 0; i < 3; i++) {
      int num = user.getUser().get(i);
      int s = user.getStrike();
      int b = user.getBall();
      if (computer.contains(num)) {
        if (computer.get(i) == num) {
          user.setStrike(++s);
        } else {
          user.setBall(++b);
        }
      }
    }
  }

}
