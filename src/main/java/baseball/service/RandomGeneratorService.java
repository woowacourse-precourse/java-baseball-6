package baseball.service;
import baseball.domain.RandomNumber;
import camp.nextstep.edu.missionutils.Randoms;
public class RandomGeneratorService {

    public RandomNumber createRandomNumber(){
        String stringRandomNumber = "";
        int MAX_LENGTH = 3;
        while(stringRandomNumber.length() < 3){
            stringRandomNumber = concatString(stringRandomNumber, Integer.toString(Randoms.pickNumberInRange(1, 9)));
        }
        System.out.println(stringRandomNumber);
        return new RandomNumber(stringRandomNumber);
    }

    private String integerToString(int number){
        return Integer.toString(number);
    }

    private String concatString(String a, String b){
        if (a.contains(b))return a;
        return a.concat(b);
    }
}
