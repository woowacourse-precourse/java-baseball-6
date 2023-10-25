package baseball.event;

import baseball.domain.Computer;
import baseball.domain.User;

public class EventContext {

    private Computer computer;
    private User user;

    public void initializeComputer(Computer computer) {
        this.computer = computer;
    }

    public void initializeUser(User user) {
        this.user = user;
    }


    public Computer getComputer() {
        return computer;
    }

    public User getUser() {
        return user;
    }
}

