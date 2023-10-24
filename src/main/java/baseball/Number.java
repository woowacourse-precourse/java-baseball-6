package baseball;

import java.util.List;

public class Number {
    // 패키지에 상관없이 하위 클래스에서 사용할 수 있도록 protected로 설정한다.
    protected List<Integer> number;

    // Counter 클래스에서 사용하므로 public으로 설정한다.
    public List<Integer> getNumber() {
        return this.number;
    }
}
