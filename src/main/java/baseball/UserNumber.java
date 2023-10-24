package baseball;

import camp.nextstep.edu.missionutils.Console; // 입력: readLine()
import java.lang.IllegalArgumentException;

public class UserNumber {
    int[] userNumber = new int[3];

    public inputUserNumber() {
        for (int i = 0; i < 3; i++) {
            userNumber[i] = Console.readLine();

            try {
                if (userNumber[i] == 0) {
                    throw new IllegalArgumentException("1~9 사이 숫자를 입력해주세요.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            
        }
    }
    
}