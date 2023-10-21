package baseball;

import java.util.List;

public class Code {

  Long id;

  List<Integer> number;

  public Code(Long id, List<Integer> number) {
    this.id = id;
    this.number = number;
  }

  public Long getId() {
    return id;
  }

  public List<Integer> getNumber() {
    return number;
  }

}
