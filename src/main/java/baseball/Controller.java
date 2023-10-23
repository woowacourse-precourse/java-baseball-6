package baseball;

import camp.nextstep.edu.missionutils.Console;
public class Controller {
    static final String GAME_START = "1";
    static final String GAME_END = "2";
    static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    public void gameStart() {
        String input = GAME_START;
        while(input.equals(GAME_START)){
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.play();

            System.out.println(RESTART_MESSAGE);
            input = Console.readLine();
            vaildationInput(input);
        }
        System.out.println("게임이 종료되었습니다.");
    }

    public void vaildationInput(String input){
        if(!input.equals(GAME_START) && !input.equals(GAME_END)){
            throw new IllegalArgumentException("입력은 1과 2만 가능합니다.");
        }
    }
}
