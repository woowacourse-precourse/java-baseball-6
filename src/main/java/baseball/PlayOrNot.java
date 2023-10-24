package baseball;

import camp.nextstep.edu.missionutils.Console;

public class PlayOrNot {
    private static final String PLAY_OR_NOT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

    public static boolean inputNum(){
        System.out.print(PLAY_OR_NOT);
        String inputNumber = Console.readLine();

        int number = checkNumber(inputNumber);
        validNumber(number);

        if (number == 1) return true;
        else return false;
    }

    private static int checkNumber(String inputNumber){
        try{
            int number = Integer.parseInt(inputNumber);
            return number;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    private static void validNumber(int number){
        if (number != 1 && number != 2){
            throw new IllegalArgumentException();
        }
    }

}
