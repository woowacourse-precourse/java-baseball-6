package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberManager {
    private final static int LENGTH = 3;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public List<Integer> createRandomNumber() {
        List<Integer> number = new ArrayList<>();
        while (number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }
        return number;
    }

    public List<Integer> receiveNumber() throws IOException{
        String number = br.readLine();
        if(!isVaildNumber(number)){
            throw new IllegalArgumentException();
        }
        return convertToList(number);
    }

    public boolean isVaildNumber(String number){
        if(number.length()!=LENGTH)
            return false;
        if(number.contains("0"))
            return false;
        for(int i=0;i<3;i++){
            if(number.charAt(i)<'1' || number.charAt(i)>'9')
                return false;
        }
        return true;

    }

    public List<Integer> convertToList(String number){
        List<Integer> numberList = new ArrayList<Integer>();
        for(int i=0;i<number.length();i++){
            numberList.add(number.charAt(0)-'0');
        }
        return numberList;
    }

    
}
