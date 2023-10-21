package baseball.vo;

import java.util.List;

public final class BaseballCode {
    private final List<Integer> codes;

    public BaseballCode(List<Integer> codes) {
        this.codes = codes;
    }

    public BaseballCode makeNewBaseballCode(List<Integer> codes) {
        return new BaseballCode(codes);
    }

    public Integer getBaseballCodeSize() {
        return codes.size();
    }

    public Integer getBaseballCodeElement(int index) {
        return codes.get(index);
    }
}
