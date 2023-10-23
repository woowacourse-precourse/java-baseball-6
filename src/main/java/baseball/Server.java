package baseball;


public class Server {
    private int gameStatusCode=1;
    private Computer computer;
    private Player player;
    private Validator validator;
    private static final int digitalCount = Config.DEFAULT_DIGIT_COUNT;
    private static final int minimumCanCreatedValue = Config.DEFAULT_MINIMUM_CAN_CREATED_VALUE;
    private static final int maximumCanCreatedValue= Config.DEFAULT_MAXIMUM_CAN_CREATED_VALUE;


    Server(){
        this.computer = new Computer(
            digitalCount,
            minimumCanCreatedValue,
            maximumCanCreatedValue
        );
        this.validator = new Validator(
            digitalCount,
            minimumCanCreatedValue,
            maximumCanCreatedValue
        );

        this.player = new Player();
    }
    public void start(){
        while(gameStatusCode==1){
            while(true){
                System.out.print("숫자를 입력해주세요 : ");
                var playerInput = player.getPlayerInput();
                validator.validatePlayerInput(playerInput);

                var playerNumber = Integer.parseInt(playerInput);
                var isPlayerWin = computer.checkUserNumberAndResponse(playerNumber);
                if (isPlayerWin == true){
                    break;
                }
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            var playerInput = player.getPlayerInput();
            validator.validatePlayerInputCommand(playerInput);

            var userCommand = Integer.parseInt(playerInput);
            if (userCommand == 1) {
                restart();
            }
            if (userCommand == 2) {
                quit();
            }
        }
    }

    private void restart(){
        computer.numberList = computer.generateRandomNumberListWithNotRepeating();
        gameStatusCode = 1;
        return;
    }
    private void quit(){
        gameStatusCode = 0;
        return;
    }

    public int getGameStatusCode(){
        return gameStatusCode;
    }

}
