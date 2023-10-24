package baseball;

import baseball.view.UserInput;
import baseball.view.Result;

public class Application {
    private static Result resultView;
    private static UserInput userInput;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        resultView.result();


        while(askRetry()){
            resultView.result();
        }

    }
    public static boolean askRetry() {
        int num= userInput.reGame();
        if (num==1) {
            return true;
        }

        return false;
    }


}
