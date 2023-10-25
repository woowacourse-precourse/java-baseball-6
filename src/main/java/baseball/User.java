package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class User {
    public List<Integer> userNumber;

    public List<Integer> getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String number = Console.readLine();
        convertStringToInteger(number);
        return userNumber;
    }

    public boolean checkRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int restart;

        try {
            restart = Integer.parseInt(Console.readLine());
            if (restart != 1 && restart !=2) {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        return restart == 1;
    }

    private void convertStringToInteger(String number) {
        userNumber = new ArrayList<>();

        try {
            if (number.length() != 3) {
                throw new Exception();
            }
            for (int i=0; i<3; i++) {
                int c = number.charAt(i) - '0';
                if (c < 1 || c > 9 || userNumber.contains(c)) {
                    throw new Exception();
                }
                userNumber.add(c);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
