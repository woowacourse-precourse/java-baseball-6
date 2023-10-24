package baseball;

public class StartBaseball {
    public static void GameStart(){

        int[] comNum = ComputerNumGenerator.ComNumGen();
        int[] playerNum = new int[3];

        while(true) {
            int strike = 0;
            int ball = 0;
            String playerStrNum = PlayerNumInput.PlayerNumInput();

            for (int i = 0; i < 3; i++) {
                playerNum[i] = playerStrNum.charAt(i) - 48;
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (comNum[i] != playerNum[i] && comNum[i] == playerNum[j]) ball++;
                }
            }

            for (int j = 0; j < 3; j++) {
                if (comNum[j] == playerNum[j]) {
                    strike++;
                }
            }

            if(strike == 3){
                String set = EndGame.EndGame();
                if (set.equals("2")){
                    break;
                }
                else{
                    comNum = ComputerNumGenerator.ComNumGen();
                }
            }
            else if(strike>0 && ball>0) System.out.println(ball + "볼 "+ strike+"스트라이크");
            else if(strike==0 && ball>0) System.out.println(ball + "볼");
            else if(strike>0 && ball==0) System.out.println(strike+"스트라이크");
            else System.out.println("낫싱");

            }

        }
    }