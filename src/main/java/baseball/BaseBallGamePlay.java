package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallGamePlay {
    //TODO: 게임진행

    public BaseBallGamePlay() {
        play();
    }

    private void play() {
        output();
        String playerBall = input();
        System.out.println(playerBall);
    }

    private void output() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private String input() {
        return Console.readLine();
    }

}



