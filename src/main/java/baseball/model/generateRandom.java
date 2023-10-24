package baseball.model;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class generateRandom {

    // 정수형 리스트 값을 문자열로 받아야하므로 초기화
    private String computerNum = "";

    // 생성자
    public generateRandom(){
        randomNumber();
    }

    public String getComputerNum(){
        return computerNum;
    }
    public void randomNumber(){
        List<Integer> generateNumber = new ArrayList<>();

        while(generateNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!generateNumber.contains(randomNumber)) {
                generateNumber.add(randomNumber);
            }
        }

        // 정수형 리스트 값들을 문자열에 문자열로 합치기
        for(int i = 0; i < generateNumber.size(); i++){
            this.computerNum += Integer.toString(generateNumber.get(i));
        }
    }
}
