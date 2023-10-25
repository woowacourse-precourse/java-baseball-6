package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class NumberControl {
    //static String computerNumber;
    private String computerNumber;

    public void generateComputerNumber() { //컴퓨터 난수 생성
        ArrayList<String> ClearNumberList = new ArrayList<>();
        ClearNumberList.clear(); // 난수 저장할 리스트 초기화
        String randomNumber;
        while (ClearNumberList.size() < 3) {
            randomNumber = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (ClearNumberList.contains(randomNumber)) {
                continue;
            }
            ClearNumberList.add(randomNumber);
        }
        computerNumber = String.join("", ClearNumberList);

    }

    public String getComputerNumber() {
        generateComputerNumber();
        return this.computerNumber;
    }


}
