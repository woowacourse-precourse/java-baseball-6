package baseball.Model;

public class UserNum {
    private String userNum;

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    public UserNum(String userNum) {
        checkNumLength(userNum);
        checkValid(userNum);
        this.userNum = userNum;
    }

    private void checkNumLength(String checkNum) throws IllegalArgumentException {
        if (checkNum.length() != 3) {
            throw new IllegalArgumentException("잘못 입력하였습니다. 입력값은 서로 다른 3자리의 수입니다.");
        }
    }

    private void checkValid(String checkNum) throws IllegalArgumentException {
        for(int i = 0; i<3; i++) {
            if (!Character.isDigit(checkNum.charAt(i))) {
                throw new IllegalArgumentException("숫자만 입력 가능합니다.");
            }
        }
    }
}
