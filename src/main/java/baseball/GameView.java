package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameView {

    private ErrorHandler errorHandler = new ErrorHandler();
    public void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String getUserInput(){
        System.out.print("숫자를 입력해주세요 : ");
        String userNumber = Console.readLine();
        errorHandler.checkErrorUserNumber(userNumber);
        return userNumber;
    }

    public boolean showResult(Game model){
        if(model.getStrikes() == 3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        else {
            if(model.getBalls() != 0){
                System.out.print(model.getBalls() + "볼 ");
            }
            if(model.getStrikes() != 0){
                System.out.print(model.getStrikes() + "스트라이크 ");
            }
            if(model.getBalls() == 0 && model.getStrikes() == 0){
                System.out.print("낫싱");
            }
            System.out.println();
        }
        return false;
    }

    public boolean playAgain(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String againNumber = Console.readLine();
        errorHandler.checkErrorAgainNumber(againNumber);
        if(againNumber.equals("1")) return true;
        return false;
    }
}
