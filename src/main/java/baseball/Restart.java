package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Restart {
    public char RESTART_CHAR = '1';
    public char END_CHAR = '2';
    public boolean restart(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String s = Console.readLine();
        char answer = s.charAt(0);
        if(answer!=RESTART_CHAR && answer !=END_CHAR) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }

        if(answer == RESTART_CHAR){
            return true;
        }
        return false;
    }
}
