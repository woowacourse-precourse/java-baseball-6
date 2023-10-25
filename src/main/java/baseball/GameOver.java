package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameOver {
    //게임이 종료되었을 때 실행, 사용자의 입력 수를 받아서 1,2과 아니면 에러 발생, 맞으면 int로 변환하여 수 반환
    public static int checkRestart(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String s = Console.readLine();
        ValidCheck.typeCheck(s);
        ValidCheck.restartCheck(s);
        return Integer.parseInt(s);
    }
}