package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    //숫자 입력받기
    public static String input(){
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return input;
    }

    //게임 재시작 여부 입력받기
    public static String restart(){
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

}
