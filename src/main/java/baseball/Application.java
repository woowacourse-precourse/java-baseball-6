package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean result=false;
        String ifOver;
        ShootBall randomBall = new ShootBall();
        ShootBall inputBall = new ShootBall();

        while(true) {
            randomBall.randomNumGenerator();
            while (!result) {
                inputBall.inputNumGenerator();
                result = randomBall.baseballReferee(inputBall);
            }
            System.out.print("게임을 종료하시겠습니까? (yes: y /no: any key)");
            ifOver = Console.readLine();
            if(ifOver=="y") break;
        }
    }
}
