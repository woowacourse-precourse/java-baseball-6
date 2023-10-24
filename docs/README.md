<p align="center">
    <img src="./woowacourse_logo.jpg" alt="우아한테크코스" width="600px">
</p>

# ⚾ 프리코스 미션 1주차 - 숫자 야구 게임 <span align="center"><img height="32" width="32" src="https://cdn.jsdelivr.net/npm/simple-icons@v9/icons/mlb.svg" /></span>

숫자 야구 게임은 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임입니다.

---

# 🌲폴더 구조

```
main
└─java
└─baseball
│  Application.java
│
├─dto
│      AnswerNumber.java
│      BallScore.java
│      GameNumber.java
│      Hint.java
│      StrikeScore.java
│
├─repository
│      AnswerInput.java
│      GameNumberMaker.java
│      GameScore.java
│
└─services
Constants.java
Game.java
InputExceptionError.java

```

---

# 📋 기능 목록

## 💻 기능 1 - 게임 생성 [✅]

* Game.java - createGame()


* 야구 숫자 게임 생성하고 전체적인 게임 사이클을 컨트롤합니다.


* 게임 시작 -> 게임 진행 -> 게임 종료 -> 게임 재시작 여부 반환


## 💻 기능 2 - 게임 시작 [✅]

* Game.java - startGame()


* 야구 숫자 게임 시작합니다.


* 시작 문구를 띄우고 게임 문제 생성 기능을 호출합니다.

## 💻 기능 3 - 게임 문제 생성 [✅]

* GameNumberMaker.java - generateAndSetGameNumber()


* 야구 숫자 게임 문제를 생성합니다.


* 문제 생성 조건

    * 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 생성합니다.


* camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용하여 게임 문제를 생성합니다.

## 💻 기능 4 - 게임 진행 [✅]

* Game.java - playGame()


* 야구 숫자 게임을 진행합니다.


* 정답 입력, 정답 채점, 힌트 생성 기능을 게임 종료 조건에 부합할 때 까지 반복해서 진행합니다.

## 💻 기능 5 - 정답 입력 [✅]

* AnswerInput.java - inputNumber()


* player에게 정답을 입력 받습니다.


* player는 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 입력합니다.


* camp.nextstep.edu.missionutils.Console의 readLine()을 사용하여 player가 입력하는 값을 처리합니다.


* [입력 값 예외처리]


* player가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료됩니다.


* Error Message - [ERROR] 숫자가 잘못된 형식입니다.


* 입력 값의 길이가 3이 아니거나 문자를 포함한 경우

    - ex) 12e, r4r, wee, 1, 23, 1424 ...


* 입력 값에 중복된 수가 있는 경우

    - ex) 111, 113, 144 ...

## 💻 기능 6 - 정답 채점 [✅]

* GameScore.java - checkGameScore()


* 문제와 입력한 값을 비교하여 정답을 채점합니다.

    * ex) 문제의 정답이 425일 때

        - player가 123을 제시한 경우 : 스트라이크 + 1

        - player가 456을 제시한 경우 : 볼 + 1, 스트라이크 + 1

        - player가 789를 제시한 경우 : 볼 0, 스트라이크 0


* strike와 ball를 따로 체크하고 각각의 DTO에 점수를 저장합니다.

## 💻 기능 7 - 힌트 생성 [✅]

* Game.java - provideHint()


* strikeCount, ballCount DTO에 저장된 채점 결과를 바탕으로 힌트를 생성합니다.

    * ex) 문제의 정답이 425일 때

        - player가 123을 제시한 경우 힌트 : 1스트라이크

        - player가 456을 제시한 경우 힌트 : 1볼 1스트라이크

        - player가 789를 제시한 경우 힌트 : 낫싱

## 💻 기능 8 - 게임 종료 [✅]

* Game.java - isEndGame()


* strikeCount가 3이면 게임 종료 메세지를 보내고 게임을 종료합니다.

## 💻 기능 9 - 게임 재시작 [✅]

* Game.java - isRestartGame()


* 게임 재시작 또는 종료여부를 player로 부터 입력받고 재시작 여부를 반환합니다.


* camp.nextstep.edu.missionutils.Console의 readLine()을 사용하여 player가 입력하는 값을 처리합니다.


* 게임 재시작은 1, 게임 종료는 2를 입력받습니다.

    * 1 -> true

    * 2 -> false


* [입력 값 예외처리]

    * player가 1 또는 2가 아닌 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료됩니다.

        - Error Message - [ERROR] 숫자가 잘못된 형식입니다.
  