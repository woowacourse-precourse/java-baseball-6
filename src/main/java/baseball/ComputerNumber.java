package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerNumber extends Number {

    public ComputerNumber(int n){
        super(n);
    }

    //1. 랜덤한 3개의 수 생성 하기
    public void generateRandomNumber() {
        int n;

        numbers.clear();
        while (numbers.size() < 3) {
            n = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(n))
                numbers.add(n);
        }
        System.out.println("컴퓨터 숫자 확인용: " + numbers);
    }
}
