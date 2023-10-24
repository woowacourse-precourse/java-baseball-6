package baseball.Model;

public class DataOfGame {
    private String computerInput;
    private String userInput;

    public void setCom(String cmpinput){
        this.computerInput = cmpinput;
    }

    public void setUser(String userinput){
        this.userInput = userinput;
    }
    
    public String getCom(){
        return computerInput;
    }
    public String getUser(){
        return userInput;
    }
}
