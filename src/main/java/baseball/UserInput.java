package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserInput{
    String userAnswer;
    UserInput(){
        System.out.print("숫자를 입력해주세요 : ");
        userAnswer = Console.readLine();
        chkInputException(userAnswer);
    }
    //사용자 입력값에 대한 예외처리
    static void chkInputException(String answer) throws IllegalArgumentException {
        //1) 길이3 아닌 경우
        if (answer.length() != 3) {
            throw new IllegalArgumentException();
        }
        //2) 입력값 각 숫자 범위가 1-9 외 구성인 경우
        for (int i = 0; i < 3; i++) {
            int num = Character.getNumericValue(answer.charAt(i));
            if (num < 1 || num > 9) throw new IllegalArgumentException();
        }
        //3) 입력값 중복된 경우-서로 다른 수가 아닌 경우
        String tmp = "";
        for (int i = 0; i < 3; i++) {
            String num = String.valueOf(answer.charAt(i));
            if (tmp.contains(num)) {
                throw new IllegalArgumentException();
            }
            tmp += num;
        }
    }
}