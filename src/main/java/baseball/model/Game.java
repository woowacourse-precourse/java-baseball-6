package baseball.model;

import baseball.vo.Numbers;
import baseball.vo.Round;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Game {
    private final Numbers computer;
    private Round round;
    public Game(){
        computer=new Numbers(generateComputerNumbers());
    }

    private String generateComputerNumbers(){
        Set<String> computer=new HashSet<>();
        generate(computer);

        return toString(computer);
    }

    public String playRound(Numbers user){
        round=new Round(computer,user);

        return round.getResultMessage();
    }

    public boolean isFinishGame(){
        if(round==null){
            throw new IllegalArgumentException("round가 진행되지 않았습니다.");
        }
        return round.isFinishGame();
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
