package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean result=false;
        ShootBall randomBall = new ShootBall();
        ShootBall inputBall = new ShootBall();

        while(1) {
            randomBall.randomNumGenerator();
            while (!result) {
                inputBall.inputNumGenerator();
                result = randomBall.baseballReferee(inputBall);
            }
            system
        }
    }
}
