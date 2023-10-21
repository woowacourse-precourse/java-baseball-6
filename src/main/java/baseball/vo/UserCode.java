package baseball.vo;

import java.util.List;

public final class UserCode {

    private final List<Integer> codes;

    public UserCode(List<Integer> codes) {
        this.codes = codes;
    }

    public List<Integer> getCodes() {
        return codes;
    }

    public UserCode makeNewUserCode(List<Integer> codes) {
        return new UserCode(codes);
    }

    public Integer getUserCodeSize() {
        return codes.size();
    }

    public Integer getUserCodeElement(int index) {
        return codes.get(index);
    }

}
