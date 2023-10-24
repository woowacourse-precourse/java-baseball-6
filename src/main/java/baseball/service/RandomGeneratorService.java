package baseball.service;
import baseball.domain.RandomNumber;
import camp.nextstep.edu.missionutils.Randoms;
public class RandomGeneratorService {

    public RandomNumber createRandomNumber(){
        String stringRandomNumber = "";
        int MAX_LENGTH = 3;
        for (int i = 0; i < MAX_LENGTH; i++){
            stringRandomNumber = stringRandomNumber.concat(integerToString(Randoms.pickNumberInRange(1, 9)));
        }
        return new RandomNumber(stringRandomNumber);
    }

    private String integerToString(int number){
        return Integer.toString(number);
    }
}
