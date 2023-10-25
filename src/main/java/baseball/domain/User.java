package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    public static final int GAMESTART = 1;
    public static final int GAMEEND = 2;

    Number number;
    Integer status;

    public User() {
        this.status = GAMESTART;
    }

    public void start(List<Integer> number) {
        setNumber(number);
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setNumber(List<Integer> number) {
        this.number = new Number(number);
    }

    public List<Integer> getNumber() {
        return number.number;
    }

    public Integer getStatus() {
        return status;
    }
}