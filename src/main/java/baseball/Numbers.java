package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final static int NUMBER_SIZE = 3; // 뽑는 숫자의 최대 자리수
    private final static int MIN_RANGE_NUM = 1;
    private final static int MAX_RANGE_NUM = 9;

    // 숫자들을 추첨하여 리스트로 반환하는 메소드
    public List<Integer> drawNumber(){
        List<Integer> drawNumbers = new ArrayList<>();
        while (drawNumbers.size() < NUMBER_SIZE) { // 3개의 다른 수가 뽑힐 때까지 반복
            int randomNumber = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(MIN_RANGE_NUM,MAX_RANGE_NUM); // 1~9 사이의 숫자를 랜덤하게 뽑기
            if (!drawNumbers.contains(randomNumber)) {// 뽑은 숫자가 이미 리스트에 있는 숫자가 아닌 경우
                drawNumbers.add(randomNumber);
            }
        }
        return drawNumbers;
    }

    // 리스트의 숫자들을 하나의 세자리 수로 만들어 반환하는 메소드
    public static String listToNumber(List<Integer> drawList) {
        StringBuilder sb = new StringBuilder();
        for (Integer integer : drawList) {
            sb.append(integer);
        }
        return sb.toString();
    }

    //사용자로부터 숫자를 입력받는 메소드
    String getNumber(){
        String line = camp.nextstep.edu.missionutils.Console.readLine();
        if(hasNoError(line)){
            return line;
        }else throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 게임을 자동으로 종료합니다."); // 유효하지 않은 값이면 종료
    }

    // 입력받은 값이 3자리 서로다른 자연수인지 판별하는 메소드
    boolean hasNoError(String stringNumber){
        try {// 숫자로 변환 가능한지 판별
            int number = Integer.parseInt(stringNumber);
            if((100 < number) && (number < 999)){// 3자리 수인지 판별
                if(!hasSameNumber(stringNumber) && !hasZero(stringNumber)) //같은 수가 없고 0이 없으면 에러가 없음
                    return true;
                else throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 게임을 자동으로 종료합니다."); //같은 수가 있거나 0이 포함되어 있으면 종료
            }else {//
                throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 게임을 자동으로 종료합니다."); // 3자리 수가 아니면 종료
            }
        }catch (NumberFormatException e) { // 숫자가 아닌 값을 입력받으면 종료
            throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 게임을 자동으로 종료합니다.");
        }

    }

    // 같은 숫자가 있는지 확인하는 메소드
    boolean hasSameNumber(String number){
        for(int i = 0; i < Game.NumberLength; i++){
            for(int j = 0; j < Game.NumberLength; j++){
                if((i != j) && (number.charAt(i) == number.charAt(j)))
                    return true;
            }
        }
        return false;
    }

    // 0을 포함하는지 확인하는 메소드
    boolean hasZero(String number){
        return ((number.charAt(0) == '0') ||number.charAt(1) == '0') || (number.charAt(2) == '0');
    }

}
