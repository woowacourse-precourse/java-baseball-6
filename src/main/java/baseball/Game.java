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
            throw new IllegalArgumentException("입력값의 길이가 올바르지 않습니다.");
        }
        for(int i=0;i<3;i++){
            if('1'>input.charAt(i) || '9'<input.charAt(i)){
                throw new IllegalArgumentException("숫자가 아닌 값이 존재합니다.");
            }
        }
    }

    public void checkRestartInput(String input){
        if(input.length()!=1){
            throw new IllegalArgumentException("입력값의 길이가 올바르지 않습니다.");
        }
        if(!input.equals("1")&&!input.equals("2")){
            throw new IllegalArgumentException("숫자가 아닌 값이 존재합니다.");
        }
    }

    public List<Integer> stringToList(String input){
        List<Integer> res = new ArrayList<>();
        res.add(input.charAt(0)-'0');
        res.add(input.charAt(1)-'0');
        res.add(input.charAt(2)-'0');
        return res;
    }

    //[0] for strike, [1] for ball
    public List<Integer> compareNumbers(List<Integer> integers){
        List<Integer> res = new ArrayList<>();
        res.add(0);
        res.add(0);
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

    public String compareResultToString(List<Integer> compareResult){
        if(compareResult.get(0)==0 && compareResult.get(1)==0){
            return "낫싱";
        }else if(compareResult.get(0)==0){
            return compareResult.get(1).toString()+"볼";
        }else if(compareResult.get(1)==0){
            return compareResult.get(0).toString()+"스트라이크";
        }else{
            return compareResult.get(1).toString()+"볼 "+compareResult.get(0).toString()+"스트라이크";
        }
    }

}
