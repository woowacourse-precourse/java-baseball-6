package baseball.View;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameView {
    public void gameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public String getUserInput(){
        System.out.print("숫자를 입력해주세요 :");
        return Console.readLine();
    }
    public void print(String result){
        System.out.println(result);
    }
    public void endPrint(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    public String endUserInput(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
}
