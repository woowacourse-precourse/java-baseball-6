package baseball.game;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BaseballApp {

    public Computer computer;

    public BaseballApp() {
        this.computer = new Computer();
    }

    public void run() {

        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.genNumbers();
        startGame();

    }

    public void startGame() {

        boolean power = true;

        while(power) {

            String input = getInput();

            if(checkInput(input)) {
                Map<String, Integer> compareMap = computer.compare(transToList(input));
                boolean result = computer.showResult(compareMap);

                if(result) {
                    power = computer.gameOver();
                }
            }
        }
    }

    public String getInput() {

        System.out.print("숫자를 입력해주세요 : ");

        return Console.readLine();
    }

    public boolean checkInput(String input) {

        if(input.length() != 3) {
            throw new IllegalArgumentException("3자리의 숫자가 입력되어야 합니다.");
        }

        try {
            Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
        }

        return true;
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
