package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Game {
    private final Numbers computer;

    public Game(){
        generateComputerNumbers();

        this.computer=new Numbers(generateComputerNumbers());
    }

    private String generateComputerNumbers(){
        Set<String> computer=new HashSet<>();
        generate(computer);

        return toString(computer);
    }

    public int[] compare(Numbers user){
        int[] result={0,0};

        for(String number:user.splitNumbers()){
            addResult(result,compareEach(number,user.index(number)));
        }

        return result;
    }

    private void addResult(int[] result,int resultIndex){
        if(resultIndex==-1){
            return;
        }

        result[resultIndex]+=1;
    }

    private int compareEach(String number,int index){
        if(computer.isSamePlace(number,index)){
            return 0;
        }

        if(computer.isExistNumber(number)){
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
