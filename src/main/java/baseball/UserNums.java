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
  public boolean contains(int num){
    return userNums.contains(num);
  }
  public int get(int i) {
    return userNums.get(i);
  }
}
