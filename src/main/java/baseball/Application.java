package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static baseball.controller.InputValidator.isNumberOneOrTwo;



public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application();
        application.play();
    }

    public void play() {
        NumberBaseballGame numberBaseballGame = new NumberBaseballGame();
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean isGameOver = false;
        while(isGameOver == false){
            numberBaseballGame.run(); // run
            isGameOver = replay();
        }
        System.out.println("숫자 야구 게임을 종료합니다.");
    }

    public boolean replay() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = readLine();
        //userInput 여부
        isNumberOneOrTwo(userInput);
        if(userInput.charAt(0) == '2') {
            return true;
        }
        return false;
    }
}
