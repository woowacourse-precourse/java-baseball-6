package baseball;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Comsball comsball = new Comsball();
        BallCheck ballcheck = new BallCheck();
        StrikeCheck strikecheck = new StrikeCheck();
        Myball myball = new Myball();

        int[] coms_ball = comsball.make_ball();

        myball.input();
        int[] userArr = myball.getNumbers();

        int strikes = strikecheck.check(coms_ball, userArr);
        int balls = ballcheck.check(coms_ball, userArr);

        
        if(balls == 0 && strikes == 0) {
        	System.out.println("낫싱");
        	
        }else
        System.out.println(balls +"볼 "+strikes+"스트라이크");

    	
    }
}
