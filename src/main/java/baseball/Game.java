package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game { //게임 진행에 필요한 로직이 들어있는 클래스
    private List<Integer> input;
    private List<Integer> answer;
    private static IO io;

    public Game(IO io) {
        this.io=io;
    }

    public String judgeGame(int num){
        int strike = 0;
        int ball = 0;

        input = new ArrayList<>();
        input.add(num/100);
        input.add((num/10)%10);
        input.add(num%10);

        for(int i=0; i<answer.size(); i++) {
            if (answer.get(i).equals(input.get(i))) strike++;
            else if (input.contains(answer.get(i))) ball++;
        }

        io.BallStrikePrint(strike,ball);

        String result = (strike==3) ? "SUCCESS" : "FAIL";
        return result;
    }

    public void createAnswer() {
        answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

}
