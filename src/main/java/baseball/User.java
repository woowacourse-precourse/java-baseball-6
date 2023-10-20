package baseball;

public class User {
    private UserNumber userNumber;

    public void setUserNumber(String number){
        this.userNumber = new UserNumber(number);
    }

    public String getUserNumber() {
        return userNumber.getUserNumber();
    }
}
