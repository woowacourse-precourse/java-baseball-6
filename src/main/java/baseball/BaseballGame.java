package baseball;

public class BaseballGame {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    private Computer computer = new Computer();
    private Player player = new Player();
    private boolean isGameEnd = false;
    private String playerInput;
    private String resultMessage;

    public BaseballGame(){
    }

    public void start(){
        System.out.println(START_MESSAGE);
        computer.makeRandomAnswer();

        while(!isGameEnd){
            progress();
        }
    }

    private void progress(){
        System.out.println(INPUT_MESSAGE);
        setPlayerInput();

        computer.calculateScore(playerInput);
        setResultMessage();
        System.out.println(resultMessage);

        if(computer.isPlayerWin()){
            System.out.println(WIN_MESSAGE);
            System.out.println(RESTART_OR_END_MESSAGE);

            player.setEndInput();
            restartOrEndGame();
        }
    }

    private void setPlayerInput(){
        player.setInput();
        playerInput = player.getInput();
    }

    private void setResultMessage(){
        resultMessage = computer.makeResultMessage();
    }

    private void restartOrEndGame(){
        if(player.isEnd()){
           isGameEnd = true;
           return;
        }

        computer.makeRandomAnswer();
    }
}
