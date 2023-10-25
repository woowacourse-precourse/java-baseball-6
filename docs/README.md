# ⚾️ 숫자 야구 게임 ⚾️

## 🚨 게임 진행 방식 🚨

- 숫자 야구 게임이 시작되면, 컴퓨터가 1부터 9 사이 숫자 중 중복되지 않는 숫자 세 개를 고른다.
- 플레이어는 컴퓨터가 고른 세 개의 숫자를 추측해서 입력하며, 입력할 때마다 출력되는 결과는 다음과 같다.
    - Ball: 플레이어가 입력한 숫자가 컴퓨터가 고른 숫자 중 하나지만 위치가 다를 경우
    - Strike: 플레이어가 입력한 숫자가 컴퓨터가 고른 숫자이며 위치까지 같은 경우
    - Nothing: 플레이어가 입력한 숫자가 컴퓨터가 고른 숫자가 아닌 경우
- 플레이어는 각 턴마다 출력되는 결과를 보고 세 수를 예측하며, 모두 맞힌 경우 게임이 종료된다.

## 🎱 게임 진행 예시 🎱

- 컴퓨터가 고른 숫자: 4 2 5
- 1 2 3 제시
    - 1 → Nothing
    - 2 → Strike
    - 3 → Nothing

    ```java
    1스트라이크
    ```

- 4 5 6 제시
    - 4 → Strike
    - 5 → Ball
    - 6 → Nothing

    ```java
    1볼 1스트라이크
    ```

- 7 8 9 제시
    - 7 → Nothing
    - 8 → Nothing
    - 9 → Nothing

    ```java
    낫싱
    ```


## 🚀 기능 요구 사항 🚀

- 게임 진행
    - [x]  사용자가 세 개의 스트라이크를 만들 때까지 게임은 진행된다
    - [x]  게임이 끝난 후 다시 게임을 진행하거나, 완전히 종료할 수 있다
    - [x]  사용자가 잘못된 값을 입력한 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션이 완전히 종료된다
- 입력값
    - [x]  공 번호는 1부터 9 번까지만 존재한다
    - [x]  서로 다른 세 자리 수를 입력해야 한다
    - [x]  게임이 끝난 경우 재시작/종료를 구분하는 것은 1과 2뿐이다
- 게임 로직
    - [x]  Ball: 플레이어가 입력한 숫자가 컴퓨터가 고른 숫자 중 하나지만 위치가 다를 경우
    - [x]  Strike: 플레이어가 입력한 숫자가 컴퓨터가 고른 숫자이며 위치까지 같은 경우
    - [x]  Nothing: 플레이어가 입력한 숫자가 컴퓨터가 고른 숫자가 아닌 경우

## 📂 프로젝트 구조 📂

```
📦src
 ┣ 📂main
 ┃ ┗ 📂java
 ┃ ┃ ┣ 📂baseball
 ┃ ┃ ┃ ┗ 📜Application.java
 ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┗ 📜BaseBallGameController.java
 ┃ ┃ ┣ 📂domain
 ┃ ┃ ┃ ┣ 📜BaseBall.java
 ┃ ┃ ┃ ┣ 📜BaseBallNumbers.java
 ┃ ┃ ┃ ┗ 📜RandomNumbers.java
 ┃ ┃ ┣ 📂exception
 ┃ ┃ ┃ ┣ 📜InvalidBaseBallLengthException.java
 ┃ ┃ ┃ ┣ 📜InvalidBaseBallNumberException.java
 ┃ ┃ ┃ ┗ 📜InvalidContinueMessageException.java
 ┃ ┃ ┗ 📂view
 ┃ ┃ ┃ ┣ 📜inputView.java
 ┃ ┃ ┃ ┗ 📜outputView.java
 ┗ 📂test
 ┃ ┗ 📂java
 ┃ ┃ ┗ 📂baseball
 ┃ ┃ ┃ ┗ 📜ApplicationTest.java
```