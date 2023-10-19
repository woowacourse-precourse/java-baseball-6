package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Game {
    public Game(){

    }

    public String generateComValue(){
        Set<String> computer=new HashSet<>();

        while(computer.size()<3){
            int randomNumber= Randoms.pickNumberInRange(1,9);
            computer.add(Integer.toString(randomNumber));
        }

        return String.join("",new ArrayList<>(computer));

    }
}
