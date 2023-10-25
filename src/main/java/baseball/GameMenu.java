package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameMenu {
    public static final String RESTART="1";
    public static final String END="2";

    public static String getUserChoice(){
        while (true){
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String userChoice = Console.readLine();

            if(userChoice.equals(RESTART) || userChoice.equals(END)){
                return userChoice;
            }else {
                throw new IllegalArgumentException();
            }
        }
    }
}
