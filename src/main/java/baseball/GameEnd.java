package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameEnd {

    String gameReplay = "1";
    String gameEnd = "2";
    
    public void AskReplay() throws IllegalArgumentException{
        Application application = new Application();
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputValue = Console.readLine();
        
        exception_InvaildInputValue(inputValue);
        
        if (inputValue.equals(gameReplay)) {
            Application.baseballGame();
        } else if (inputValue.equals(gameEnd)) {
            return;
        }
    }

    public void exception_InvaildInputValue(String inputValue) {
        if (!inputValue.equals("1") && !inputValue.equals("2")) {
            throw new IllegalArgumentException("입력된 값이 올바르지 않습니다.");
        }
    }

}
