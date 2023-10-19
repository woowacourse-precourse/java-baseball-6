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
        for(int i=0;i<value.length();i++){
            char word=value.charAt(i);
            compareEach(Character.toString(word),i);
        }
    }

    private void compareEach(String word,int index){
        if(this.value.indexOf(word)==index){
            this.strike+=1;
            return;
        }

        if(this.value.contains(word)){
            this.ball+=1;
        }
    }

    public boolean isThreeStrike(){
        return this.strike==3;
    }

}
