package baseball;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    	
        Comsball comsball = new Comsball();
        int [] coms_ball = comsball.make_ball();
        String myball;

        System.out.print("숫자를 입력해주세요: ");
        myball = Console.readLine();

    	
    }
}
