package baseball.game;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    String userAnswer;

    public UserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String tmp = Console.readLine();
        chkInputException(tmp);
        userAnswer = tmp;
    }

    //사용자 입력값에 대한 예외처리
    private void chkInputException(String answer) throws IllegalArgumentException {
        //1) 길이3 아닌 경우
        if (answer.length() != 3) {
            throw new IllegalArgumentException("입력 길이가 잘못되었습니다. " + answer.length());
        }
        //2) 입력값 각 숫자 범위가 1-9 외 구성인 경우
        for (int i = 0; i < 3; i++) {
            int num = Character.getNumericValue(answer.charAt(i));
            if (num < 1 || num > 9) {
                throw new IllegalArgumentException("1-9 범위를 벗어난 입력입니다.");
            }
        }
        //3) 입력값 중복된 경우-서로 다른 수가 아닌 경우
        String tmp = "";
        for (int i = 0; i < 3; i++) {
            String num = String.valueOf(answer.charAt(i));
            if (tmp.contains(num)) {
                throw new IllegalArgumentException("중복된 입력입니다. 서로 다른 세가지 숫자가 입력되어야 합니다.");
            }
            tmp += num;
        }
    }
}
