package baseball;

import camp.nextstep.edu.missionutils.Console;


public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            String Restart = Game();
            if(Restart.equals("2")){
                System.out.println("게임 종료");
                break;
            }
        }
    }
    public static String Game() {
        String ComNum = Computer.generateRandomNumber();
        while(true){
            String UsrNum = User.UserInput();
            if(Compare.CompareNum(ComNum,UsrNum)){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                System.out.println("게임을 시작하려면 1, 종료하려면 2를 입력하세요.");
                String Restart = Console.readLine();
                return Restart;
            }
        }
    }
}


