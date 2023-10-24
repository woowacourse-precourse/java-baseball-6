package baseball;

public class BaseballGame {

    private final int NUM_COUNT=3;
    private final int STRIKE=2;
    private final int BALL=1;
    private final int NOTHING=0;
    private int[] playerAnswer;
    private int[] computerAnswer;
    Game game;

    public BaseballGame(){
        game=new Game();
    }

    public void startBaseballGame(){
        GameInstructions.startInstruction();
        game.setComputerAnswer();
        computerAnswer= game.getComputerAnswer();

        while(game.getStrike()!=3){
            playerAnswer=GameInstructions.makeInput();
            game.reset();
            checkAnswer(playerAnswer,computerAnswer);
            GameInstructions.printTurnResult(game.getStrike(),game.getBall());
        }
        GameInstructions.printWinningMessage();
    }

    public void checkAnswer(int[] playerAnswer, int[] computerAnswer){
        for(int i=0;i<NUM_COUNT;i++){
            int result=strikeOrBall(playerAnswer[i],i);

            if(result==STRIKE){
                game.increaseStrike();
                continue;
            }
            if(result==BALL){
                game.increaseBall();
            }
        }
    }

    public int strikeOrBall(int playerNumber,int index){
        for(int i=0;i<NUM_COUNT;i++){
            if(playerNumber==computerAnswer[i] && index==i){
                return STRIKE;
            }
            if(playerNumber==computerAnswer[i] && index!=i){
                return BALL;
            }
        }
        return NOTHING;
    }
}
