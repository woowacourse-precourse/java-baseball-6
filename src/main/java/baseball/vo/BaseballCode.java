package baseball.vo;

import java.util.List;

public final class BaseballCode {
    private final List<Integer> codes;

    public BaseballCode(List<Integer> codes) {
        this.codes = codes;
    }

    public List<Integer> getCodes() {
        return codes;
    }

    public BaseballCode makeNewBaseballCode(List<Integer> codes) {
        return new BaseballCode(codes);
    }

}
