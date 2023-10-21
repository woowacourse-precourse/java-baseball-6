package baseball;

public class Game {
    public int restart(){
        User user = new User();
        int decision = user.userDecision();
        return decision;
    }
}
