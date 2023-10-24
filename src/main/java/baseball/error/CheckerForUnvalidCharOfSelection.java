package baseball.error;
public class CheckerForUnvalidCharOfSelection {
    public void check(String gameContinueSelection) {
        try{
            Integer.parseInt(gameContinueSelection);
        }
        catch (Exception e){
            throw new IllegalArgumentException();
        }
    }
}
