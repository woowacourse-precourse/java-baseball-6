package baseball.service;

public class GameService {

    private final UmpireService umpireService = new UmpireService();
    private final InputService inputService = new InputService();
    private final MessageService message = new MessageService();

    public boolean start(){
        message.gameStart();
        inputService.computerAnswer();

        while(true){
            message.numberInput();
            inputService.userAnswer();

            umpireService.umpire(inputService.userValue(),inputService.computerValue());
            if(umpireService.isThreeStrike()){
                message.gameOver();
                return umpireService.isRestart();
            }
        }
    }
}