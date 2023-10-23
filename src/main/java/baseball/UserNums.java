package baseball;

import java.util.List;

public class UserNums {
  private List<Integer> userNums;
  public UserNums(List<Integer> userNums){
    this.userNums = userNums;
  }
  public List<Integer> getUserNums(){
    return userNums;
  }
}
