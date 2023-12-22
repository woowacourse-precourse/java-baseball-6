package baseball.controller;

import baseball.service.GameService;
import baseball.service.InputService;
import baseball.service.OutputService;

import java.util.List;

public class GameController {
    InputService inputService;
    GameService gameService;
    private boolean progress;
    public GameController(){
        inputService = new InputService();
        gameService = new GameService();
        progress = true;
    }
    private void restartGame() {
        inputService = new InputService();
        gameService = new GameService();
        progress = true;
    }
    public void start(){
        while(progress){
            this.game();
        }
    }
    private void game(){
        List<Integer> computers = gameService.putComputerNumbers(); //시작하자마자 컴퓨터 용 숫자 생성
        for(Integer i: computers){
            System.out.print(i);
        }
        List<Integer> users = gameService.numberConverter(inputService.getInputNumber()); //사용자 숫자 입력받고 생성
        OutputService outputService = new OutputService(gameService.compareNumbers(users,computers)); //비교한 결과가 들어있는 값을 print 해야 하는 OutputService에 전달.
        int num = outputService.print();
        if(num == 2){
            this.progress= false;
        }
        if(num == 1){
            this.progress = true;
            restartGame();
        }
    }
}
