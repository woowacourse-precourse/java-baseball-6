package baseball;

import java.util.List;

public class ComNums {
  private List<Integer> comNums;
  public ComNums(List<Integer> comNums){
    this.comNums = comNums;
  }
  public List<Integer> getComNums(){
    return comNums;
  }
  public boolean contains(int num){
    return comNums.contains(num);
  }
  public int get(int num){
    return comNums.get(num);
  }
  public int size(){
    return comNums.size();
  }
}
