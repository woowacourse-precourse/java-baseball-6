package baseball.service;

import baseball.dto.GameStateDto;

public class BaseballService {



    public void caculate(String userNumber, String nowComNumber) {
        GameStateDto gameStateDto = new GameStateDto();
        calculateStrike(userNumber, nowComNumber, gameStateDto);


    }

    private void calculateStrike(String userNumber, String nowComNumber,
        GameStateDto gameStateDto) {
        for(int i=0; i<3; i++){
            if(userNumber.charAt(i) == nowComNumber.charAt(i)) {
                gameStateDto.addStrike();
             }
        }
    }
}
