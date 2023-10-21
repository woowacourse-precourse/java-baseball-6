package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computer;
    public Computer(){
        this.computer = new ArrayList<>();
    }

    // 랜덤하게 3자리의 서로 겹치지 않는 숫자(1~9) 고르기
    public void chooseRandomValues() {
        computer.clear();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public int compare(List<Integer> human) {
        int[] sb = {0, 0}; // [strike 수, ball 수]
        human.forEach(v -> {
            // 정답에 v가 존재
            if (computer.contains(v)){
                // 같은 자리에 존재
                if (computer.get(human.indexOf(v)) == v){
                    sb[0]++;
                }else {
                    sb[1]++;
                }
            }
        });

        printResult(sb[0], sb[1]);

        return sb[0];
    }

    private void printResult(int strike, int ball) {
        if (strike == 0 && ball == 0){
            System.out.println("낫싱 ");
        }else {
            if(ball > 0){
                System.out.printf("%d볼 ", ball);
            }
            if(strike > 0){
                System.out.printf("%d스트라이크 ", strike);
            }
        }
        System.out.println();
    }
}
