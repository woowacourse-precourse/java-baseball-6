package baseball.service;

import baseball.domain.Ball;
import baseball.domain.Referee;
import baseball.domain.Strike;
import baseball.repository.BaseballRepository;

public class BaseballService {

    private final int[] answer;
    private final boolean[] visited;
    private Strike strike;
    private Ball ball;

    public BaseballService(BaseballRepository baseballRepository){
        baseballRepository.createAnswer();
        answer = baseballRepository.getAnswer();
        visited = baseballRepository.getNumberVisit();
    }

    public void scoreReset(){
        strike = new Strike();
        ball = new Ball();
    }

    public void userAnswerCheck(int[] userAnswer){
       for(int i =0; i<userAnswer.length; i++){
           if(visited[userAnswer[i]]){
              baseballReferee(userAnswer[i], i);
           }
       }
    }

    public void baseballReferee(int userAnswer, int count){
        if (answer[count] == userAnswer) {
            strike.plusStrikeCount();
        } else {
            ball.plusBallCount();
        }
    }

    public Referee decision(){
        return new Referee(strike, ball);
    }
}