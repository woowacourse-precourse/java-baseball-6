package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    static void gameStart(){
        Computer.setRandomNumber();
        do{
            System.out.print("숫자를 입력해주세요 : ");
            User.readNumber();
            System.out.println(Computer.getHint(User.getUserNumber()));
        }while(!Computer.isCorrect());
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
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
