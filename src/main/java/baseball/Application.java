package baseball;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        
        final int gameSize = 3;
        boolean repeatGame = true;
        
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (repeatGame) {
            List<Integer> computer = BaseballFunction.generateNumbers();
            
            boolean repeatCalc = true;
            while (repeatCalc) {
                System.out.print("숫자를 입력해주세요 : ");
                List<Integer> userInput = new ArrayList<Integer>();
                userInput = BaseballFunction.getUserInput(gameSize);
                repeatCalc = BaseballFunction.calculateResult(computer, userInput);
                if (repeatCalc == false) {
                    System.out.println(gameSize + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    
                    // 게임이 끝난 경우 1과 2만 입력한다는 요구사항이 있으므로
                    // 3 ~ 9의 입력의 경우 IllegalArgumentException의 예외가 발생하지 않고
                    // 2의 입력과 마찬가지로 게임이 종료되도록 만들었음.
                    if (BaseballFunction.getUserInput(1).get(0) == 1) {
                        repeatGame = true;
                        break;
                    } else {
                        repeatGame = false;
                        break;
                    }
                }
            }
        }
    }
}
