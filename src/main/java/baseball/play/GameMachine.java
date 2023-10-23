package baseball.play;

import baseball.controller.BaseballController;
import baseball.resolver.BaseballViewResolver;
import baseball.setting.ReadyGame;

public class GameMachine {

    BaseballViewResolver baseballViewResolver = new BaseballViewResolver();
    private int answer;
    public void play(){
        while(true){
            ReadyGame readyGame = new ReadyGame();

            baseballViewResolver.startView();
            BaseballController controller = readyGame.injection();
            engin(controller);
            if(answer ==2){
                break;
            }
        }
    }

    public void engin(BaseballController controller){
        while(true){
            answer = baseballViewResolver.contactViewAndResultController(
                controller.startBaseBall(
                    baseballViewResolver.contactViewAndPlayControl()
                )
            );
            if(answer ==2 || answer==1){
                if(answer==2){
                    System.out.println("게임 종료");
                }
                break;
            }
        }
    }
}