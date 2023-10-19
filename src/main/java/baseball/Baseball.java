package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        numberValidation(number);
        this.myNumber = Arrays.stream(number.split("")).mapToInt(x -> Integer.parseInt(x)).toArray();
    }

    private void numberValidation(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("문자는 사용할 수 없음");
        }
        if (number.length() != 3) throw new IllegalArgumentException("3개의 숫자를 입력할 수 있음");
        if (number.contains("0")) throw new IllegalArgumentException("0은 사용할 수 없음");
        
        for (int i = 0; i < number.length()-1; i++) {
            for (int j = i + 1; j < number.length(); j++) {
                 if (number.charAt(i) == number.charAt(j)){
                     throw new IllegalArgumentException("중복된 숫자는 사용할 수 없음");
                 }
            }
        }
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
        return result[0] == 3;
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
