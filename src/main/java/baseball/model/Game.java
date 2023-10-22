package baseball.model;

import baseball.vo.Numbers;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Game {
    private final Numbers computer;

    public Game(){
        computer=new Numbers(generateComputerNumbers());
    }

    private String generateComputerNumbers(){
        Set<String> computer=new HashSet<>();
        generate(computer);

        return toString(computer);
    }

    public Result calculateResult(Numbers user){
        return new Result(computer,user);
    }

    private String toString(Set<String> computer){
        return String.join("",new ArrayList<>(computer));
    }

    private void generate(Set<String> computer){
        while(computer.size()<3){
            computer.add(toString(pickRandom()));
        }
    }

    private String toString(int number){
        return Integer.toString(number);
    }

    private int pickRandom(){
        return Randoms.pickNumberInRange(1,9);
    }
}
