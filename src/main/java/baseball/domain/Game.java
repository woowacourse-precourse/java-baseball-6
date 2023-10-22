package baseball.domain;

import java.util.ArrayList;

public class Game {
    private Long id;
    private Long userId;
    private ArrayList<Integer> computerNumber;
    private Long questionCount;

    public Game(Long id, Long userId, ArrayList<Integer> computerNumber, Long questionCount) {
        this.id = id;
        this.userId = userId;
        this.computerNumber = computerNumber;
        this.questionCount = questionCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public ArrayList<Integer> getComputerNumber() {
        return computerNumber;
    }

    public void setComputerNumber(ArrayList<Integer> computerNumber) {
        this.computerNumber = computerNumber;
    }

    public Long getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(Long questionCount) {
        this.questionCount = questionCount;
    }
}
