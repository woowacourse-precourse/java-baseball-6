package baseball;

public class Application {

  public static void main(String[] args) {
    ComPuTaService com = new ComPuTaService();
    ComPuTaVO comVO = new ComPuTaVO();


    comVO = com.cOm();
    System.out.println(comVO.getOneValue());


}
}