package baseball.Model;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameModel {
    private List<Integer> computerNumbers;
    //랜덤 숫자 생성하기
    public void createRandomNumbers(){
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        computerNumbers = numbers;
    }

    //숫자 판단
    public void calculateResult(String userInput){
        int strike = 0;
        int ball = 0;

        List<Integer> userNumbers = convertStringToIntergerList(userInput);

        for(int i=0; i<3; i++){
            int computerNumber = computerNumbers.get(i);
            int userNumber = userNumbers.get(i);
            if(computerNumber == userNumber){
                strike++;
            }else if(computerNumbers.contains(userNumber)){
                ball++;
            }
        }
    }

    //userInput을 int 리스트로 변환
    private List<Integer> convertStringToIntergerList(String userInput){
        List<Integer> integerList = new ArrayList<>();

        for(char c : userInput.toCharArray()){
            integerList.add(Character.getNumericValue(c));
        }
        return integerList;
    }
}
