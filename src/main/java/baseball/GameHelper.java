package baseball;

public class GameHelper {
    public void retryGame() throws IllegalArgumentException{
        String request = RequestChecker.retryRequest();
        if(isRetryGame(request)){
            BaseBall.startGame().run().retryGame();
        }
    }
    private boolean isRetryGame(String playNumber) throws IllegalArgumentException{
        switch (playNumber){
            case "1" -> {return true;}
            case "2" -> {return false;}
            default ->
                    //잘못된 사용자 입력
                    throw new IllegalArgumentException(String.format("입력값 \"%s\"는 잘못된 요청 정보입니다.", playNumber));
        }
    }
}
