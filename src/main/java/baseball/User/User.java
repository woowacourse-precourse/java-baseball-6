package baseball.User;

import camp.nextstep.edu.missionutils.Console;

public class User {
    public String UserInput() {
        String userInput = Console.readLine();
        CheckLength(userInput);
        CheckRepeat(userInput);
        return userInput;
    }

    // 사용자가 잘못된 값을 입력한 경우 exception 일으키고 종료
    public void CheckLength(String userInput) {
        if(userInput.length() != 3) {
            throw new IllegalArgumentException("3자리만 입력하세요");
        }
    }

    public void CheckRepeat(String userInput) throws IllegalArgumentException {
        for(Integer i = 0; i<3; i++) {
            for(Integer j=0; j<3; j++) {
                if(i != j && userInput.charAt(i) == userInput.charAt(j)) {
                    throw new IllegalArgumentException("서로 다른 숫자만 입력하세요");
                }
            }
        }
    }
}
