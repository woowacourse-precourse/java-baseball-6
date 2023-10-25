package baseball;
public class InputContinueOrEnd {
    public boolean error(String continueOrEnd){
        if(continueOrEnd.length()!=1)return true;
        return (continueOrEnd.charAt(0)!='1' && continueOrEnd.charAt(0)!='2');
    }

    public boolean quit(String continueOrEnd){
        return continueOrEnd.charAt(0)=='2';
    }
}
