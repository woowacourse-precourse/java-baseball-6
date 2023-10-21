package baseball.domain;
import camp.nextstep.edu.missionutils.Randoms;
public class Computer {
    private String number;
    public Computer(){
        this.number = "";
    }
    public void randComNumber(){
        number = "";
        while(number.length()!=3){
            int num = Randoms.pickNumberInRange(1,9);
            if(!number.contains(String.valueOf(num))){
                number += num;
            }
        }
    }
    public String getNumber(){
        return number;
    }

}
