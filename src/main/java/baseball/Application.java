package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean runFlag = true;

        while(runFlag){
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.play();
            runFlag = askExit();
        }
    }

    public static boolean askExit(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int userInput = Integer.parseInt(readLine());
        Exception.validateOneOrTwo(userInput);
        return userInput == 1;
    }
}