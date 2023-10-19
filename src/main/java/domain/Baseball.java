package domain;

import camp.nextstep.edu.missionutils.Randoms;
import constant.BaseConst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static constant.BaseConst.COMPLETE;

public class Baseball {

    private final List<Integer> baseNumber; // 랜덤번호 생성
    private int[] myNumber; // 나의 번호

    public Baseball() {
        List<Integer> temp = new ArrayList<>();
        while (temp.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!temp.contains(randomNumber)){
                temp.add(randomNumber);
            }
        }
        this.baseNumber = temp;
    }

    public void setMyNumber(String number) {
        this.myNumber = Arrays.stream(number.split("")).mapToInt(x -> Integer.parseInt(x)).toArray();
    }

    public boolean confirmNumber() {
        int[] result = new int[2]; // result[0] : 스트라이크, result[1] : 볼

        for (int i = 0; i < baseNumber.size(); i++) {

            if (myNumber[i] == baseNumber.get(i)) { // 같은 인덱스에 위치하면 스트라이크++
                result[0]++;
            } else if (baseNumber.contains(myNumber[i])){ // 같은 인덱스에 위치하지않고 존재하기만하면 볼++;
                result[1]++;
            }

        }
        System.out.println(printMessage(result));
        return result[0] == COMPLETE;
    }

    private String printMessage(int[] result) {
        if (result[0] + result[1] == 0) return "낫싱";
        String message = "";
        if (result[1] != 0){
            message += result[1] + "볼 ";
        }
        if (result[0] != 0) {
            message += result[0] + "스트라이크";
        }

        return message.trim();
    }

}
