package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    Array arr = new Array();
    Hint hint = new Hint();

    void startGame(){
        arr.getRandomAnswer();
        System.out.println("숫자 야구 게임을 시작합니다.");
        playGame();
    }

    void playGame(){
        while(hint.end != 1) {
            hint.init();

            System.out.print("숫자를 입력해주세요 : ");
            arr.getUserInput();

            hint.compareAnswers(arr.answer, arr.userInput);
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int flag = Integer.parseInt( readLine() );

        if (flag == 1) restartGame();
        else {
            if (flag != 2) throw new IllegalArgumentException();
        }

    }

    void restartGame() {
        arr.getRandomAnswer();
        hint.init();
        playGame();
    }
}