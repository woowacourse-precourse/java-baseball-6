package baseball;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        System.out.println(Messages.START_GAME);

        int mode = 1;

        while(mode == 1) {
            Baseball baseball = new Baseball();
            try {
                baseball.play();
                mode = inputMode();
            }catch (IllegalArgumentException e){
                e.printStackTrace();
                break;
            }
        }
    }

    private static int inputMode(){
        System.out.println(Messages.SELECT_MODE);
        return Integer.parseInt(Console.readLine());
    }
}
