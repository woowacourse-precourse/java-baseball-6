package baseball;

import java.util.ArrayList;
import java.util.List;

public class ComPuTaService {

  public ComPuTaService(){}

  /*
      설명서 :
      1. cOm 을 만들기 위하여 부품들을 모음
      2. newComPuTa()는  빈 객체 하나와 List<String> 을 받아서 파싱 하고 리턴함
      2-1. 파싱 과정에서 랜덤Integer List가 필요해서 Random에서 만들어 넘겨받음
      3. 즉, Com-Service는 새로운 컴퓨터를 만드는 과정.
   */


  private List<String> changeCharList(List<Integer> RandomList) {
    List<String> stringList = new ArrayList<>();
    for(Integer num : RandomList) {
      stringList.add(num.toString());
    }
    return stringList;
  }

  private ComPuTaVO newComPuTa(ComPuTaVO com, List<String> listS){
    if(listS.size() >= 1) com.setOneValue(listS.get(0));
    if(listS.size() >= 2) com.setOneValue(listS.get(1));
    if(listS.size() >= 3) com.setOneValue(listS.get(2));
    return com;
  }

  public ComPuTaVO cOm(){
    ComPuTaVO comcom = new ComPuTaVO();
    return newComPuTa(comcom,changeCharList(RandomService.randomValue(3)));
  }





}
