package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> numbers;

    public Computer(){
        numbers = new ArrayList<>();
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public void setRandomNums() {
        this.numbers = makeRandomNums();
    }

    public void compareNums(Player player){
        int ball = 0;
        int strike = 0;
        List<Integer> playerNums = player.getNumbers();
        for(Integer num : playerNums) {
            if (this.numbers.contains(num)) {
                if (this.numbers.indexOf(num) == playerNums.indexOf(num)) {
                    strike += 1;
                } else ball += 1;
            }
        }
        if(ball != 0 && strike != 0) {
            System.out.print(ball + "볼 " + strike + "스트라이크");
        } else if (ball != 0){
            System.out.println(ball + "볼");
        } else if (strike != 0){
            System.out.println(strike + "스트라이크");
        } else System.out.println("낫싱");
    }

    private static List<Integer> makeRandomNums(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) { // 서로 다른 숫자들로만 구성하게하는 부분.
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
