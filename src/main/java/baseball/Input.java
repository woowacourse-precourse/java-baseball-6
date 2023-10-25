package baseball;

public class Input {
    User user = new User();
    Text text = new Text();

    public String userNum() {
        text.inputNum();
        return user.getNum();
    }

    public boolean restartOrEndOption() {
        text.restartOrEnd();
        int optionNum = user.getOptionNum();
        return user.option(optionNum);
    }
}
