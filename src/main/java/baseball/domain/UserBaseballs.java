package baseball.domain;

import java.util.List;

public class UserBaseballs extends AbstractBaseballs {

    public UserBaseballs(List<Baseball> baseballs) {
        super(baseballs);
        verifySizeExact(this.baseballs);
        verifyNoDuplicate(this.baseballs);
    }

    private void verifySizeExact(List<Baseball> baseballs) throws IllegalArgumentException {
        if (baseballs.size() != BASEBALLS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void verifyNoDuplicate(List<Baseball> baseballs) throws IllegalArgumentException {
        if (baseballs.stream().distinct().count() != BASEBALLS_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
