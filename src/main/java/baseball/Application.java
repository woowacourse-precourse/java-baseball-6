package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean restart = true;
        while(restart){
            Game game = new Game();
            game.getNewGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String exit = Console.readLine();
            isExitValid(exit);
            if(exit.equals("2")){
                restart = false;
            }
        }
    }
    private static void isExitValid(String exit){
        if(!(exit.equals("1")) && !exit.equals("2")){
            throw new IllegalArgumentException();
        }
    }
}
