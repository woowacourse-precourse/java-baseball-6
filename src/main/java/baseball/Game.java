package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    static final int NUMBER = 3;
    static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final int RETRY = 1;
    private static final int EXIT = 2;
    private static final String GET_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String QUESTION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    Array arr = new Array();
    Hint hint = new Hint();

    void startGame(){
        arr.getRandomAnswer();
        playGame();
    }

    void playGame(){
        while(hint.end != Hint.FINISH) {
            hint.init();

            System.out.print(GET_NUMBER_MESSAGE);
            arr.getUserInput();

            hint.compareAnswers(arr.answer, arr.userInput);
        }

        System.out.println(SUCCESS_MESSAGE);

        System.out.println(QUESTION_MESSAGE);
        int flag = Integer.parseInt( readLine() );

        if (flag == RETRY) restartGame();
        if (flag != RETRY && flag != EXIT) throw new IllegalArgumentException();

    }

    void restartGame() {
        Game newGame = new Game();
        newGame.startGame();
    }
}