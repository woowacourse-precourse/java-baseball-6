package baseball.domain;

public class User {
    private final String value;
    public Point point;


    public User(String value){
        this.value=value;
        this.point=new Point(0,0);
    }

    public void compare(String value){
        int[] result={0,0,0};
        for(int i=0;i<value.length();i++){
            char word=value.charAt(i);
            int resultIndex=compareEach(Character.toString(word),i);
            result[resultIndex]+=1;
        }

        this.point=new Point(result[0],result[1]);
    }

    private int compareEach(String word,int index){
        if(this.value.indexOf(word)==index){
            return 0;
        }

        if(this.value.contains(word)){
            return 1;
        }

        return 2;
    }

    public boolean equalsPoint(Point comparePoint){
        return point.equals(comparePoint);
    }

    public boolean isThreeStrike() {
        return this.point.equalsStrike(3);
    }

}
