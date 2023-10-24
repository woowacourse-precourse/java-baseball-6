package baseball;

public class AnswerBox {
    private Integer strike;
    private Integer ball;
    private String message;
    
    public AnswerBox() {
        this.strike = 0;
        this.ball = 0;
        this.message = "낫싱";
    }
    
    public AnswerBox setScore(Integer strike, Integer ball) {
        this.strike = strike;
        this.ball = ball;
        return this;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return this.message;
    }

    public void updateMessage() {

        if (this.strike.equals(0) && this.ball.equals(0)) {
            this.message = "낫싱";
        } else if (this.strike.equals(0)) {
            this.message = this.ball + "볼";
        } else if (this.ball.equals(0)) {
            this.message = this.strike + "스트라이크";
        } else {
            this.message = this.ball + "볼 " + this.strike + "스트라이크";    
        }
    }
    
}
