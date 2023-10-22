package baseball;

public class Game {
    private boolean isGameFinished;
    private Answer answer;
    private RandomAnswerFactory answerFactory;
    private ResultFactory resultFactory;

    public Game(RandomAnswerFactory answerFactory, ResultFactory resultFactory) {
        this.answerFactory = answerFactory;
        this.resultFactory = resultFactory;
    }

    public void setUpForNewGame(){
        answer = answerFactory.getRandomAnswer();
        isGameFinished = false;
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
            isGameFinished = true;
        }
        return result;
    }

    public boolean isGameFinished() {
        return isGameFinished;
    }

    private boolean isThreeStrikes(Result result){
        return result.getNumberOfStrikes() == 3;
    }
}

