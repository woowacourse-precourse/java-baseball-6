## 🤖우테코 프리코스 1주차 : 숫자야구🤖

### ⚾숫자야구⚾
  - 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임
  
### 🛠️기능 구현🛠️
1. 1~9 사이의 3자리 상대방(컴퓨터) 숫자를 랜덤으로 선정한다.
2. 게임 시작 메세지를 출력한다.
3. '숫자를 입력해주세요 :' 메세지를 출력한다 
4. 사용자에게 입력을 받는다. 
   1. IllegalArgumentException 발생 후 게임 종료시킬 수 있다.
      1. 1~9 이외의 문자를 입력하는 경우
      2. 3글자가 아닌 문자를 입력하는 경우
5. 상대방 숫자와 사용자 입력값을 비교한 뒤, 힌트를 출력한다.
   2. 같은 숫자, 다른 자리인 경우 '볼'을 출력한다.
   3. 같은 숫자, 같은 자리인 경우 '스트라이크'를 출력한다.
   4. 같은 숫자가 없는 경우 '낫싱'을 출력한다.
6. 3스트라이크가 아닌 경우, 3번으로 돌아가 반복한다.
7. 3스트라이크인 경우 게임 종료 메세지를 출력한다.
   1. 1이 입력되면, 1번으로 돌아간다.
   2. 2이 입력되면 게임을 종료시킨다.
   3. 그 외의 입력값이 입력될 경우, IllegalArgumentException을 발생시키고 종료시킨다.


### 📝 세부 구현 내역 📝

- MVC 패턴으로 구현해보았습니다. 처음으로 구현해보았기 때문에, 미숙한 부분이 있을 수 있습니다. 
  - Model(Domain)
    - Computer : 컴퓨터(상대방)의 3가지 숫자를 생성하는 getComputerNumber 메서드를 구현했습니다.
    - Player : 사용자에게 입력받은 Input을 적절한 타입으로 변환시키는 getPlayerNumbers, getFinishInput 메서드를 구현했습니다.
    - Grade : 컴퓨터와 사용자의 숫자를 비교하여 점수를 반환하는 getScore, 점수를 토대로 결과 String을 반환하는 getResult 메서드를 구현했습니다.
  - View
    - InputView : 사용자에게 입력을 받는 getPlayerInput 메서드를 구현했습니다.
    - OutputView : 게임 내 메세지를 출력하는 메서드들을 구현했습니다.
  - Controller
    - GameController : 게임의 전반적인 진행을 담당하는 start, play 메서드를 구현했으며, View에서 받은 Input의 유효성 검사를 진행하는 코드를 작성했습니다.
  - Utils
    - Constants : 최대 값, 최소 값, 크기, 재실행, 종료 값을 상수로 선언하는 클래스입니다. MVC 계층에서는 Constants의 상수를 사용하여, 코드의 유지보수를 용이하게 구성했습니다.
    - InputValidator : 유효성 검사를 진행하는 메서드를 담은 클래스입니다. 


### 💾 파일구조 💾

```
📦src
┣ 📂main
┃ ┗ 📂java
┃ ┃ ┗ 📂baseball
┃ ┃ ┃ ┣ 📂controller
┃ ┃ ┃ ┃ ┗ 📜GameController.java
┃ ┃ ┃ ┣ 📂domain
┃ ┃ ┃ ┃ ┣ 📜Computer.java
┃ ┃ ┃ ┃ ┣ 📜Grade.java
┃ ┃ ┃ ┃ ┗ 📜Player.java 
┃ ┃ ┃ ┣ 📂utils
┃ ┃ ┃ ┃ ┣ 📜Constants.java
┃ ┃ ┃ ┃ ┗ 📜InputValidator.java
┃ ┃ ┃ ┣ 📂view
┃ ┃ ┃ ┃ ┣ 📜InputView.java
┃ ┃ ┃ ┃ ┗ 📜OutputView.java
┃ ┃ ┃ ┗ 📜Application.java
┗ 📂test
┃ ┗ 📂java
┃ ┃ ┗ 📂baseball
┃ ┃ ┃ ┗ 📜ApplicationTest.java
```
