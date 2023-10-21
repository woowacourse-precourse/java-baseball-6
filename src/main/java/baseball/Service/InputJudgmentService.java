package baseball.Service;

import baseball.DTO.Computer;
import baseball.DTO.User;

import java.util.List;
import java.util.Objects;

public class InputJudgmentService {
    private final User user;
    private final Computer computer;
    private Integer strike = 0;
    private Integer ball;

    public InputJudgmentService(User user,Computer computer){
        this.user = user;
        this.computer = computer;
    }

    public Integer judgeStrike(List<Integer> userNumbers,List<Integer> computerNumbers){
        for (int i=0; i <userNumbers.size(); i++){
            if(Objects.equals(userNumbers.get(i), computerNumbers.get(i))){
                computerNumbers.remove(i);
                userNumbers.remove(i);
                strike++;
            }
        }
        return strike;
    }
    public Integer judgeBall(List<Integer> userNumbers,List<Integer> computerNumbers){
        for(int i=0; i<userNumbers.size(); i++){
            if(computerNumbers.contains(userNumbers.get(i))){
                ball++;
            }
        }
        return ball;
    }
}
