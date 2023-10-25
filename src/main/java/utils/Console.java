package utils;

/*
* 기존에 Game.java에 만들어둔 print 메소드를 Console.java Class로 따로 분리하였다.
*  print 메소드의 기능은 그저 매개변수로 받은 String을 출력해주기만 하는 기능으로,
* Game Class와 밀접한 관련이 없기 때문에 utils package를 생성해서 그 아래에
* Console Class 를 생성하여 따로 분리하였다.
* */
public class Console {
    Console() {}
    public static void print(String content) {
        System.out.print(content);
    }
}
