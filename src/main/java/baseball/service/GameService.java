package baseball.service;

import baseball.domain.User;

public class GameService {
    private final User user;

    public GameService() {
        user = new User();
    }

    public void setUserbaseballNumber(String input){
        user.setUserBasebsallNumber(input);
    }
}
