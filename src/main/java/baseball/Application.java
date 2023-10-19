package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    static void gameStart(){
        Computer.setRandomNumber();
        do{
            User.readNumber();
            System.out.println(Computer.getHint(User.getUserNumber()));
        }while(!Computer.isCorrect());
    }
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean isContinue = true;
        while(isContinue){
            gameStart();
            String input = Console.readLine();
            if(input.equals("2")){
                isContinue = false;
            }
        }
    }
}
