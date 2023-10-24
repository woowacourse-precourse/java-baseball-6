package baseball;

public class Game {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String ANSWER_CHECK_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String ANSWER_MESSAGE = "3스트라이크";
    private static final String REPLAY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String MODE_EXCEPTION_MESSAGE = "1과 2중 선택해야 합니다.";

    private Computer computer;
    private Player player;
    public void run(){
        while(true){
            int n;
            computer = new Computer();
            player = new Player();

            System.out.println(START_MESSAGE);
            while(true){
                // 숫자 입력
                System.out.print(INPUT_MESSAGE);
                n = getPlayerAnswerInputAsInt();

                // 정답 비교
                String result = computer.answerCheck(n);
                System.out.println(result);

                // 게임 종료 여부
                if(checkGameEnd(result)){
                    System.out.println(ANSWER_CHECK_MESSAGE);
                    break;
                }
            } //...게임 한 판 종료

            System.out.println(REPLAY_MESSAGE);
            // 재시작 여부
            int userMode = getPlayerModeInputAsInt();
            switch (userMode){
                case 1:
                    break;
                case 2:
                    return;
                default:
                    new IllegalArgumentException(MODE_EXCEPTION_MESSAGE);
            }
        }
    }

    public int getPlayerModeInputAsInt(){
        String playerModeInput = player.getModeInput();
        return Integer.parseInt(playerModeInput);
    }

    public int getPlayerAnswerInputAsInt(){
        String playerInput = player.getAnswerInput();
        return Integer.parseInt(playerInput);
    }

    /*
        - 게임 종료 여부 확인
        스트라이크이면 true 리턴, 그렇지 않으면 flase 리턴
     */
    public boolean checkGameEnd (String result){
        if(result.equals(ANSWER_MESSAGE)){
            return true;
        }
        else{
            return  false;
        }
    }

}
