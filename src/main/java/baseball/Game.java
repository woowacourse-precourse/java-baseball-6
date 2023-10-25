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
        Result result =  resultFactory.getResult(answer.getHintsWithUserPrediction(
                new UserPrediction(
                        Integer.parseInt(String.valueOf(userPrediction.charAt(0))),
                        Integer.parseInt(String.valueOf(userPrediction.charAt(1))),
                        Integer.parseInt(String.valueOf(userPrediction.charAt(2))))
                )
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

