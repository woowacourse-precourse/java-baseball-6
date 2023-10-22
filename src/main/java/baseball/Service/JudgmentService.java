package baseball.Service;

import baseball.DTO.Computer;
import baseball.DTO.User;

import java.util.Objects;

public class JudgmentService {
    private final User user;
    private final Computer computer;
    public JudgmentService(User user,Computer computer){
        this.user = user;
        this.computer = computer;
    }
    public Integer judgeStrike(){
        Integer strike = 0;
        for (int i = 0; i < user.getUserNumbers().size(); i++){
            if(Objects.equals(user.getUserNumbers().get(i),computer.getComputerNumbers().get(i))){
                user.getUserNumbers().set(i,0);
                strike++;
            }
        }
        return strike;
    }
    public Integer judgeBall(){
        Integer ball = 0;
        for(int i = 0; i < user.getUserNumbers().size(); i++){
            if(computer.getComputerNumbers().contains(user.getUserNumbers().get(i))){
                ball++;
            }
        }
        return ball;
    }

}
