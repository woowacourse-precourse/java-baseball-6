package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {

    private int[] user_input = new int[3];
    private final CheckException checkException = new CheckException();

    public int[] getUser_input() {
        return user_input;
    }

    public void input(){
        String input = Console.readLine(); // 사용자가 데이터를 입력한다.
        checkException.checkException_input(input); // 예외 처리 객체를 호출하여 예외가 발생하였는지 확인한다.

        char[] temp = input.toCharArray(); // 우선 데이터를 char로 변경하고 이후 int형 변수로 변환하여 배열에 저장할 예정
                                           // [수정 필요] String을 한번에 int로 변환하여 배열 저장하는 방법

        // 유저가 저장한 데이터를 사용할 배열에 int 데이터로 저장한다.
        for(int i=0; i<user_input.length; i++){
            user_input[i] = Character.getNumericValue(temp[i]);
        }
    }



}
