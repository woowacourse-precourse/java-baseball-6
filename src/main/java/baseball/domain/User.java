package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class User {
    private List<Integer> userGuessNumber;

    void setUserGuessNumber() {
        try{
            List<Integer> userGuessNumber = new ArrayList<>();
            String input = Console.readLine();
            
            if (input.length() != 3) {
                throw new IllegalArgumentException("세 자리 숫자를 입력해주세요.");
            }
            for (int i = 0; i < input.length(); i++) {
                int digit = Integer.parseInt(String.valueOf(input.charAt(i)));
                
                if (digit == 0) {
                    throw new IllegalArgumentException("0은 입력할 수 없습니다.");
                }
                if (userGuessNumber.contains(digit)) {
                    throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
                }
                userGuessNumber.add(digit);
            }

            this.userGuessNumber = userGuessNumber;
                
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Integer> getUserGuessNumber() {
        return this.userGuessNumber;
    }
}
