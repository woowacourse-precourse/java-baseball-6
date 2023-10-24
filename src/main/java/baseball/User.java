package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {

    private int[] user_input = new int[3];
    private final CheckException checkException = new CheckException();

    public int[] getUser_input() {
        return user_input;
    }

    public void input() {
        String input = Console.readLine(); // 사용자가 데이터를 입력한다.

        checkException.checkException_input(input);

        char[] temp = input.toCharArray();
        for (int i = 0; i < user_input.length; i++) {
            user_input[i] = Character.getNumericValue(temp[i]);
        }
    }


}
