package baseball.view;

import static baseball.view.Message.*;

public class UserOutput {
    static private void consoleOutNewLine(String outputString){
        System.out.println(outputString);
    }

    static private void consoleOutWithoutNewLine(String outputString){
        System.out.print(outputString);
    }

    static public void consoleOutGameStart(){
        consoleOutNewLine(GAME_START);
    }

    static public void consoleOutGameFinish(){
        consoleOutNewLine(GAME_FINISH);
    }

    static public void consoleOutGameResume(){
        consoleOutNewLine(GAME_RE);
    }

    static public void consoleOutUserInput(){
        consoleOutWithoutNewLine(INPUT_NUMBER);
    }

    static public void consoleOutSBStatus(int strike, int ball){
        String result = "";

        /* make output String respond to strike and ball counts */
        switch (ball){
            case 0 :
                result += BALL0;
                break;
            case 1:
                result += BALL1;
                break;
            case 2:
                result += BALL2;
                break;
            case 3:
                result += BALL3;
                break;
        }
        switch (strike){
            case 0 :
                result += STRIKE0;
                break;
            case 1:
                result += STRIKE1;
                break;
            case 2:
                result += STRIKE2;
                break;
            case 3:
                result += STRIKE3;
                break;
        }

        if(result.equals("")){
            result = NOTHING;
        }

        consoleOutNewLine(result);
    }
}
