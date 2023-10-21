package baseball.vo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class UserCode {

    private final List<Integer> codes;

    public UserCode(List<Integer> codes) {
        this.codes = codes;
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

    public Set<Integer> convertUserCodeToSet() {
        return new HashSet<>(codes);
    }

}
