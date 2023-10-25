package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static boolean resetGame() throws IllegalArgumentException{
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String checkNextGame = Console.readLine();

        if(checkNextGame.equals("2") || checkNextGame.equals("1") ){
            return checkNextGame.equals("1");
        }

        throw new IllegalArgumentException();

    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            try{
                Baseball newGame = new Baseball();
                newGame.playGame();
                if(!resetGame()){
                    break;
                }
            }catch (IllegalArgumentException ex){
                throw ex;
            }
        }
    }
}
