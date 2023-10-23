package baseball;

import baseball.utils.Utils;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Application application = new Application();
        // TODO: 프로그램 구현
        boolean exitFlag = false;
        while (!exitFlag){
            System.out.println("숫자 야구게임을 시작합니다.");
            BaseBallGame.run();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            exitFlag = application.exitFlagCheck();
        }

    }

    private boolean exitFlagCheck(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String exitOrRestartNumber = Console.readLine();
        Utils.validateRestartNumber(exitOrRestartNumber);
        if (exitOrRestartNumber.equals("1")){
            return false;
        }else {return true;}
    }
}
