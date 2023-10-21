package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    static List<Integer> target;

    public void initialize(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        target = computer;
    }

    public void checkInput(String input){
        if(input.length()!=3){
            throw new IllegalStateException();
        }
        for(int i=0;i<3;i++){
            if('1'>input.charAt(i) || '9'<input.charAt(i)){
                throw new IllegalStateException();
            }
        }
    }

    private List<Integer> intToArray(int a){
        List<Integer> res = new ArrayList<>();
        res.add(a/100);
        res.add((a%100)/10);
        res.add(a%10);
        return res;
    }

    //[0] for strike, [1] for ball
    public List<Integer> compareNumbers(int a){
        List<Integer> res = new ArrayList<>();
        res.add(0);
        res.add(0);
        List<Integer> integers = intToArray(a);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(target.get(i).equals(integers.get(j))){
                    if(i==j){
                        res.set(0,res.get(0)+1);
                    }else{
                        res.set(1,res.get(1)+1);
                    }
                }
            }
        }
        return res;
    }

}
