package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    List<Integer> numbers;
    public Computer(){
        numbers = new ArrayList<>();
        putNumbers();
    }
    private void putNumbers() {
        while (numbers.size() < 3) { //만약 컴퓨터 배열의 크기가 3이상이 아니면,
            int randomNum = Randoms.pickNumberInRange(1, 9); //랜덤 넘버를 뽑는다.
            if (!numbers.contains(randomNum)) { //만약 뽑힌 랜덤넘버가 컴퓨터 리스트 안에 없으면,
                numbers.add(randomNum); //랜덤 넘버를 집어넣는다.
            }
        }
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
    public void compareTo(Computer other){

    }
}
