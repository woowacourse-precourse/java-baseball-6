package baseball;

import java.io.PrintStream;

public class Application {
    public static void main(String[] args) {
        PrintStream printStream = System.out;
        boolean isNewGame = true;
        printStream.println("숫자 야구게임을 시작합니다.");
        
        while (isNewGame) {
            BaseballGame game = new BaseballGame();
            boolean isAnswer = false;

            while (!isAnswer) {
                printStream.print("숫자를 입력해주세요 : ");
                game.inputAnswer();
                isAnswer = game.isMatchedAnswer();
            }
    
            printStream.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            printStream.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            isNewGame =  game.selectMode() == 1;
        }
    }
}
