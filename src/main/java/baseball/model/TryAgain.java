package baseball.model;

public class TryAgain {
    private boolean isStatus = true;
    public boolean reStart(String userNum) {
        if (Integer.parseInt(userNum)==2) {
            this.isStatus = false;
            return false;
        }
        return true;
    }

    public boolean getIsStatus() {
        return this.isStatus;
    }
}
