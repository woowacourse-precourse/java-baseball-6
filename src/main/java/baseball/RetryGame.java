package baseball;

public class RetryGame {
    private StartGame startGame;

    public RetryGame(StartGame startGame) {
        this.startGame = startGame;
    }

    public void retryByRequest(String request) throws IllegalArgumentException{
        if(isRetryGame(request)){
            startGame.updateFlag(true);
        }else {
            startGame.updateFlag(false);
        }
    }

    private boolean isRetryGame(String playNumber) throws IllegalArgumentException{
        switch (playNumber){
            case "1" -> {  return true;}
            case "2" -> {  return false;}
            default ->
                //잘못된 사용자 입력
                    throw new IllegalArgumentException(String.format("입력값 \"%s\"는 잘못된 요청 정보입니다.", playNumber));
        }
    }
}
