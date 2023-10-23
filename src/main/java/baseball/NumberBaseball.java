package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class NumberBaseball {
    public void play(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        new PlayerPartner().startGame();

        while(isContinue()){
            new PlayerPartner().startGame();
        }
    }

    private boolean isContinue() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String command = readLine();

        if(command.equals("1")){
            System.out.println(command);
            return true;
        }

        return endGame();
    }

    private static boolean endGame() {
        System.out.println("게임 종료");
        return false;
    }


}