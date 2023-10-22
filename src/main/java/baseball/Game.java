package baseball;

import java.util.List;

public class Game {
    private Random random = new Random();
    private User user = new User();
    public void start(){

        while (true) {

            //랜덤숫자 생성
            List<Integer> randomNumber=random.createNumber();
            //사용자 숫자 입력
            List<Integer> userNumber= user.inputNumber();
            //숫자비교

            //종료여부파악
        }
    }
}
