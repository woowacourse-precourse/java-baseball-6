package baseball.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BaseballApp {

    public Computer computer;
    public User user;

    public BaseballApp() {
        this.user = new User();
        this.computer = new Computer(user);
    }

    public void run() {

        System.out.println("숫자 야구 게임을 시작합니다.");
        startGame();

    }

    public void startGame() {

        boolean power = true;

        while(power) {

            String input = user.getInput();

            if(user.checkInput(input)) {
                Map<String, Integer> compareMap = computer.compare(transToList(input));
                boolean result = computer.showResult(compareMap);

                if(result) {
                    power = computer.gameOver();
                }
            }
        }
    }

    public List<Integer> transToList (String input) {

        List<Integer> numList = new ArrayList<>();

        int wholeNum = Integer.parseInt(input);

        //parseInt + String 처리 vs 숫자 계산, 뭐가 더 좋으려나
        for(int i=100; i>0; i/=10) {
            int nowNum = wholeNum/i;
            numList.add(nowNum);
            wholeNum -= nowNum * i;
        }
        return numList;
    }

}
