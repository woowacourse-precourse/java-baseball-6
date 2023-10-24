package baseball;


public class Server {
    private GameStatus gameStatusCode;
    private Computer computer;
    private Player player;
    private Validator validator;
    private static final int digitCount = Config.DEFAULT_DIGIT_COUNT;
    private static final int minimumCanCreatedValue = Config.DEFAULT_CAN_CREATED_MINIMUM_VALUE;
    private static final int maximumCanCreatedValue= Config.DEFAULT_CAN_CREATED_MAXIMUM_VALUE;

    private enum GameStatus{
        RUNNING(1),
        STOPPED(2);
        private final int code;
        GameStatus(int code){
            this.code = code;
        }
        public static GameStatus fromCommand(int command){
            for (GameStatus status : GameStatus.values()){
                if (status.code == command){
                    return status;
                }
            }
            throw new IllegalArgumentException("없는 명령입니다!");
        }
    }

    Server(){
        this.computer = new Computer(
            digitCount,
            minimumCanCreatedValue,
            maximumCanCreatedValue
        );
        this.validator = new Validator(
            digitCount,
            minimumCanCreatedValue,
            maximumCanCreatedValue
        );

        this.player = new Player();
        this.gameStatusCode = GameStatus.RUNNING;
    }
    public void run(){
        while (gameStatusCode ==GameStatus.RUNNING){
            start();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            var playerInput = player.getPlayerInput();
            validator.validatePlayerInputCommand(playerInput);

            var userCommand = Integer.parseInt(playerInput);
            if (GameStatus.fromCommand(userCommand) == GameStatus.RUNNING) {
                restart();
            }
            if (GameStatus.fromCommand(userCommand) == GameStatus.STOPPED) {
                quit();
            }
        }
    }
    private void start(){
        while(true) {
            System.out.print("숫자를 입력해주세요 : ");
            var playerInput = player.getPlayerInput();
            validator.validatePlayerInput(playerInput);

            var playerNumber = Integer.parseInt(playerInput);
            var isPlayerWin = computer.checkUserNumberAndResponse(playerNumber);
            if (isPlayerWin == true) {
                break;
            }
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    private void restart(){
        computer.reGenerateNumberList();
    }
    private void quit(){
        gameStatusCode = GameStatus.STOPPED;
    }

    public GameStatus getGameStatusCode(){
        return gameStatusCode;
    }

}
