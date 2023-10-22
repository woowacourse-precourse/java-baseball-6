package baseball;

public class Game {
    private PlayStatus playStatus;
    private Answer answer;
    private RandomAnswerFactory answerFactory;
    private ResultFactory resultFactory;

    public Game(RandomAnswerFactory answerFactory, ResultFactory resultFactory) {
        this.answerFactory = answerFactory;
        this.resultFactory = resultFactory;
    }

    public void setUpForNewGame(){
        answer = answerFactory.getRandomAnswer();
        playStatus = PlayStatus.PROCEEDING;
    }

    public Result play(String userPrediction){
        Result result =  resultFactory.compareAndGetResult(
                new UserPrediction(
                        userPrediction.charAt(0),
                        userPrediction.charAt(1),
                        userPrediction.charAt(2)),
                answer
        );
        if (isThreeStrikes(result)){
            playStatus = PlayStatus.FINISHED;
        }
        return result;
    }

    private boolean isThreeStrikes(Result result){
        return result.getNumberOfStrikes() == 3;
    }
}

enum PlayStatus{
    FINISHED, PROCEEDING
}
