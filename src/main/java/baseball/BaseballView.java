package baseball;


import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballView {

    BaseballView(){}

    public void displayStartMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void displayRoundEnd(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    public void displayResult(String result){
        System.out.println(result);
    }
    public String getPlayerGuess(){
        System.out.print("숫자를 입력해주세요 : ");
        return readLine();
    }

    public String getContinuity(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return readLine();
    }
}
