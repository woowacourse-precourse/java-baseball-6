package baseball;


public class Application {

    static Computer computer;
    static Player player;
    public static void main(String[] args) {
        initGame();
        progressGame();
    }

    private static void initGame(){
        computer = new Computer();
        player = new Player();
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void progressGame(){

        String answer = computer.pickNumber();
        while (true){
            System.out.print("숫자를 입력해주세요 : ");
            String query = player.getInput();

            if (query.length() != 3){
                throw new IllegalArgumentException("Invalid Argument: " + query);
            }
            System.out.println(query);
            String result = computer.check(query, answer);
            System.out.println(result);

            if (result.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String gameStatus = player.restartOrEndGame();

                if (gameStatus.equals("restart")) {
                    answer = computer.pickNumber();
                    continue;
                }
                else if (gameStatus.equals("end")) break;
            }
        }

    }


}