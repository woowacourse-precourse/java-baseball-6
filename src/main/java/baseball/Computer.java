package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {

    private List<Integer> numbers;

    public Computer(){
        numbers = new ArrayList<>();
    }

    public List<Integer> getNumbers() {
        List<Integer> copyList = new ArrayList<>(numbers);
        copyList = Collections.unmodifiableList(copyList);
        return copyList;
    }

    public void setRandomNums() {
        this.numbers = makeRandomNums();
    }

    public boolean compareNums(Player player){
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
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (ball != 0){
            System.out.println(ball + "볼");
        } else if (strike != 0){
            System.out.println(strike + "스트라이크");
        } else System.out.println("낫싱");

        boolean end = false;
        if (strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            end = true;
        }

        return end;
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
