package baseball.console;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class ConsoleHandler {
    private final String NOTHING = "낫싱";
    private final String STRIKE = "스트라이크";
    private final String BALL = "볼";

    public void playBallMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public Boolean chooseRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String choose = Console.readLine();
        if(choose.equals("1")){
            return true;
        }
        else if(choose.equals("2")){
            return false;
        }
        throw new IllegalArgumentException("잘못된 입력입니다.");
    }

    public String inputNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if(input.length()!=3){
            throw new IllegalArgumentException("자릿수는 3자리입니다.");
        }
        if(!Pattern.matches("^[1-9]*$", input)){
            throw new IllegalArgumentException("숫자 이외는 입력될 수 없습니다.");
        }
        return input;
    }

    public void showNothing() {
        System.out.println(NOTHING);
    }

    public void showResult(int ball, int strike){
        StringBuilder sb = new StringBuilder();
        if(ball!=0){
            sb.append(ball).append(BALL).append(" ");
        }
        if(strike!=0){
            sb.append(strike).append(STRIKE);
        }
        System.out.println(sb);
    }

    public void endMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
