package baseball.utils;

import java.util.List;

public class checkExceptionUser {
    public void checkUserInputSizeException(List<Integer> user) throws IllegalArgumentException {
        if (!(user.size() == 3)) {
            throw new IllegalArgumentException("숫자 3자리를 입력해주세요. ");
        }
        for (int i = 0; i < user.size(); i++) {
            for (int j = 0; j < user.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (user.get(i) == user.get(j)) {
                    throw new IllegalArgumentException("동일한 숫자가 포함되어있습니다. ");
                }
            }
        }
    }

    public void checkUserRegameException(int num) throws IllegalArgumentException {
        if (!(num == 1 || num == 2)) {
            throw new IllegalArgumentException("입력 번호를 다시 확인해주세요: ");
        }
    }
}
