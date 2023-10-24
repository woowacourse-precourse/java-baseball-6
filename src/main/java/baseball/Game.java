package baseball;

import java.util.List;
import java.util.Map;

public class Game {
    private Random random = new Random();
    private User user = new User();
    private Compare compare = new Compare();
    private Output output = new Output();
    private boolean quit = true;
    private boolean randomCreate = true;
    public void start(){
        output.startPrint();
        List<Integer> randomNumber = null;
        while (quit) {

            //랜덤숫자 생성
            if (randomCreate) {
                randomNumber = random.createNumber();
                System.out.println(randomNumber);
                randomCreate = false;
            }
            //사용자 숫자 입력
            output.inputPrint();
            List<Integer> userNumber = user.inputNumber();
            System.out.println(userNumber);
            //숫자비교
            Map<String, Integer> result = compare.compareNumber(randomNumber, userNumber);
            System.out.println(result.toString());
            //종료여부파악
            if (!output.resultPrint(result)) {
                if (!user.inputRestart()) {
                    quit = false;
                }
                randomCreate = true;
            }
            ;

        }
    }
}
