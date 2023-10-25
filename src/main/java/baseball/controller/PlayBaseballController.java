package baseball.controller;

import baseball.domain.PlayBaseball;
import baseball.service.PlayBaseballService;

public class PlayBaseballController {
    private final PlayBaseballService playBaseballService;
    public PlayBaseballController(PlayBaseballService playBaseballService, PlayBaseball playBaseball){
        this.playBaseballService = playBaseballService;
        this.playBaseballService.getPlayBaseball() =
    }

    public void play(){
        do{
            playBaseballService.getInitComment();
            playBaseballService.getChoiceComment();

        }while(true);

    }
}
