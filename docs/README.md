# 기능 구현

- 중복없이 1~9를 사용하여 size가 3인 `List<Integer>` 반환
```java
private List<Integer> getAnswer() {
    List<Integer> answer = new ArrayList<>();
    while (answer.size() < 3) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!answer.contains(randomNumber)) {
            answer.add(randomNumber);
        }
    }
    return answer;
}
```
만약 `getAnswer`의 결과가 `{1, 2, 3}`이라면 `123`인 String type으로 바꾸지 않는다.  
예를 들어 `459`이 입력으로 주어지면 `{4, 5, 9}`로 변환하여 `answer`와 비교할 것이다.  
- `answer`와 `유저입력`의 i번째 값을 비교하여 `strike`, `ball`, `nothing`을 반환한다.
  - i번째 자리의 값이 같은 경우 `strike`
  - 동일한 값을 가지고 있으나 자리 수가 다른 경우 `ball`
  - `0strike 0ball`인 경우 `nothing`  
- 비교한 결과를 텍스트와 함께 출력한다.
  - ex) `1스트라이크`, `2볼`, `낫싱`
- 정답을 맞힐때까지 입력과 비교결과 출력을 반복한다.  
- 맞추면 프로그램을 게임 종료를 출력하고 게임을 계속할 건지 종료할 건지 선택하는 텍스트를 출력한다.
  - `1` : 게임을 계속한다.  
  - `2` : 게임을 종료한다.  
- 규칙에 어긋한 값을 입력하면 `IllegalArgumentException`를 발생시킨다.  
  - 각자리 숫자는 1~9 중 하나이며 0이 포함되는 경우
  - `answer`를 맞출때 3자리 숫자가 아닌 경우, 숫자 이외 값과 숫자를 혼합한 경우
  - `answer`를 맞추고 난 후 게임을 계속할 지 종료할지 선택할 때 `1`과 `2`이외의 값이 입력된 경우