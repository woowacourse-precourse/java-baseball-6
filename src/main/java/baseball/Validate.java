package baseball;

import java.util.List;

public class Validate {
    private List<Integer> user;

    Validate() {

    }

    public void validateUser(List<Integer> user) { // 입력받은 숫자가 이상하다면 예외를 던지는 메소드
        this.user = user;
        if (user.size() != 3 || checkZeroValue() == false) {
            throw new IllegalArgumentException();
        }
    }

    boolean checkZeroValue() { // 입력받은 숫자에 gi이상한 값이 있는지 검사하는 메소드
        for (int i = 0; i < this.user.size(); i++) {
            int userNumber = user.get(i);
            if (userNumber == 0 && userNumber > 9) {
                return false;
            }
            for (int j = i + 1; j < this.user.size(); j++) {
                if (userNumber == user.get(j)) { // 중복된 값이 존재한다면
                    return false;
                }
            }
        }
        return true;
    }
}
