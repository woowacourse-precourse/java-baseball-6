package baseball;
/*
    클래스 명 : Restart
    설명      : 숫자를 모두 맞힌 뒤 게임 시작/종료 선택
    작성자	  : 김준태
	날짜	  : 2023. 10. 23.
 */
import camp.nextstep.edu.missionutils.Console;

public class Restart {
    public boolean restartGame(){
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
        String input =  Console.readLine();
        int restartNumber = Integer.parseInt(input);// 아래 if문에서 비교를 위해 사용자의 입력을 int로 변경
        if (!(restartNumber == 1|| restartNumber==2)) {
            throw new IllegalArgumentException("옳지 않은 입력입니다. 다시 입력해주세요.");
        }
        if (restartNumber == 2) {
            System.out.println("게임을 종료합니다.");
            return false;
        }
        return true;
    }
}