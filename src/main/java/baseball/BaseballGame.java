package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballGame {
    private static final int INPUT_NUMBERS_SIZE = 3;
    String inputNumbers;
    int strike;
    int ball;
    List<Integer> computer;


    public void start(){
        computer = createComputerNumbers();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true){
            inputNumbers();
        }
    }

    public void inputNumbers(){
        // check point
        // null인지, size가 3인지, 숫자인지, 서로다른 숫자인지
        System.out.print("숫자를 입력해주세요 : ");
        String temp = readLine();
        validateSize(temp);
        this.inputNumbers = readLine();
    }

    public void validateSize(String numbers){
        if(numbers.length() != INPUT_NUMBERS_SIZE){
            throw new IllegalArgumentException("숫자는 3개만 입력 가능합니다");
        }
    }

    public List<Integer> createComputerNumbers(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

}
