package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class RandomNumber {

    public String makeRandomNum(){
        ArrayList<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        String randomNum="";

        for(int i=0; i<computer.size(); i++){
            randomNum+=String.valueOf(computer.get(i));
        }
        return randomNum;
    }

}