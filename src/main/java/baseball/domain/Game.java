package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Game {
    public Game(){

    }

    public String generateComValue(){
        Set<String> computer=new HashSet<>();
        generate(computer);

        return toString(computer);
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
