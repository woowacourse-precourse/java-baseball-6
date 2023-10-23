package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Computer {

    private final List<Integer> numbers;
    private final int STRIKE_INDEX = 0;
    private final int BALL_INDEX = 1;
    private final int OUT_INDEX = 2;

    private Computer(List<Integer> numbers){
        this.numbers = numbers;
    }

//    랜덤한 숫자 3개 생성
    public static Computer create(){
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return new Computer(numbers);
    }

//  사용자가 입력한 숫자가 컴퓨터와 숫자와 몇 개 일치하는지 확인
    public List<Integer> compareNumbers(List<Integer> playerNumbers){
        Integer[] resultArr = {0,0,0};
        for (int i = 0; i <playerNumbers.size() ; i++) {
            if(!this.numbers.contains(playerNumbers.get(i))){
                resultArr[OUT_INDEX]++;
                continue;
            }
            if(this.numbers.get(i) == playerNumbers.get(i)){
                resultArr[STRIKE_INDEX]++;
                continue;
            }
            resultArr[BALL_INDEX]++;
        }
        return Arrays.stream(resultArr).collect(Collectors.toList());
    }








}
