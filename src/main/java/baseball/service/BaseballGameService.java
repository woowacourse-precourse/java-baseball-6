package baseball.service;


import baseball.handler.BaseballGameEventHandler;


/**
 * 야구게임 서비스 - 게임 서비스 인터페이스를 구현함
 */
public class BaseballGameService implements GameServce{

    // 야구게임 이벤트 핸들러 사용을 위한 필드
    BaseballGameEventHandler baseballGameEventHandler;


    // 생성자 - 객체 생성 시, 해당 필드 객체를 생성한다
    public BaseballGameService() {
        baseballGameEventHandler = new BaseballGameEventHandler();
    }

    // 게임 시작을 위한 초기 컴퓨터 값 설정 메소드
    public void GameMaker(){
        baseballGameEventHandler.setComputerNumber();
    }

    // 게임을 진행하는 메소드
    public void GameProgressor(){

        baseballGameEventHandler.reset();
        while(baseballGameEventHandler.score() != 3){
            baseballGameEventHandler.reset();
            baseballGameEventHandler.progressGame();
            baseballGameEventHandler.validate();
        }
        baseballGameEventHandler.gameRestart();
    }

    // 컨트롤러에서 게임 종료 여부를 판단할 수 있도록 해당 필드 값을 반환하는 메소드
    public boolean GameEnd(){
        return baseballGameEventHandler.end();
    }


}
