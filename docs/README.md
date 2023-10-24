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
