package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Game {
    public Numbers computer;
    public Numbers user;

    public Game(){
        generateComputerNumbers();
    }

    private void generateComputerNumbers(){
        Set<String> computer=new HashSet<>();
        generate(computer);

        this.computer=new Numbers(toString(computer));
    }

    public int[] inputAndCompare(String input){
        inputUserNumbers(input);
        return compare();
    }

    private void inputUserNumbers(String input){
        this.user=new Numbers(input);
    }

    private int[] compare(){
        int[] result={0,0};
        int index=0;

        for(String number:user.splitNumbers()){
            int resultIndex=compareEach(number,index++);

            if(resultIndex!=-1){
                result[resultIndex]+=1;
            }
        }

        return result;
    }

    private int compareEach(String number,int index){
        if(computer.isSamePlace(number,index)){
            return 0;
        }
        else if(computer.isExistNumber(number)){
            return 1;
        }

        return -1;
    }

    private String toString(Set<String> computer){
        return String.join("",new ArrayList<>(computer));
    }

    private void generate(Set<String> computer){
        while(computer.size()<3){
            computer.add(Integer.toString(Randoms.pickNumberInRange(1,9)));
        }
    }
}
