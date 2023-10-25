package baseball;

import camp.nextstep.edu.missionutils.Console;

public class PlayOrNot {
    private static final String PLAY_OR_NOT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

    public static boolean inputNum(){
        System.out.print(PLAY_OR_NOT);
        String inputNumber = Console.readLine();

        ValidationNumber.checkNumber(inputNumber);
        int number = Integer.parseInt(inputNumber);
        ValidationNumber.validNumber(number);

        if (number == 1) return true;
        else return false;
    }

}
