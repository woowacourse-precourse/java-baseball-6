package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean runFlag = true;

        while(runFlag){
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.play();
            runFlag = askExit();
        }
    }
    public static boolean askExit(){
    }
}
}