package baseball.domain;

public class User {
    public String value;
    public int strike;
    public int ball;


    public User(String value){
        this.value=value;
        this.strike=0;
        this.ball=0;
    }

    public void compare(String value){
        for(int i=0;i<this.value.length();i++){
            String userNum=Character.toString(this.value.charAt(i));

            if(value.contains(userNum)){
                if(value.indexOf(userNum)==i){
                    this.strike+=1;
                }
                else{
                    this.ball+=1;
                }
            }
        }
    }

    public boolean isThreeStrike(){
        return this.strike==3;
    }

}
