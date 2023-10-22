package baseball;



import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {


    public void compareMyInputNumberAndComputerNumber(String myNumber, List<Integer> computerNumber) {
        int strike = 0;
        int ball = 0;

        for (int i =0; i<myNumber.length(); i++){
            if (myNumber.charAt(i) == computerNumber.get(i)){
                strike++;
            }
            else if (computerNumber.contains(myNumber.charAt(i)) && computerNumber.indexOf(myNumber.charAt(i)) != i) {
                ball++;
            }
        }
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String myNumber = Console.readLine();

        List<Integer> computerNumber = new ArrayList<>();

        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computerNumber.contains(randomNumber)){
                computerNumber.add(randomNumber);
            }
        }


    }
}
