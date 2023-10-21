<p align="center">
    <img src="./woowacourse_logo.jpg" alt="우아한테크코스" width="600px">
</p>

# 프리코스 미션 1주차 - 숫자 야구 게임 <span align="center"><img height="32" width="32" src="https://cdn.jsdelivr.net/npm/simple-icons@v9/icons/mlb.svg" /></span>

숫자 야구 게임은 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임입니다.

---

# 📋 기능 목록 📋

## 💻 기능 1 - 게임 생성

* 야구 숫자 게임 시작합니다.


* Application main()에서 game 인스턴스를 생성합니다.


* Application main()에서 game.startGame()호출 -> 게임을 실행합니다.

## 💻 기능 2 - 게임 문제 생성

* 야구 숫자 게임 문제를 생성합니다.


* 문제 생성 조건

    * 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 생성합니다.


* camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용하여 게임 문제를 생성합니다.


* Game 인스턴스 생성 -> GameNumberMaker 인스턴스 생성 -> GameNumber 인스턴스 생성합니다.


* Game startGame()에서 makeGameNumber() 호출하여 gameNumber DTO에 gameNumber(문제) 생성 및 저장 후 return 받습니다.

## 💻 기능 3 - 정답 입력

* player에게 정답을 입력 받습니다.

    * player는 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 입력합니다.

    * camp.nextstep.edu.missionutils.Console의 readLine()을 사용하여 player가 입력하는 값을 처리합니다.


* [입력 값 예외처리]

    * player가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료됩니다.

        - Error Message - [ERROR] 숫자가 잘못된 형식입니다.

    * 입력 값에 문자가 들어 있는 경우

        - ex) 12e, r4r, wee ...

    * 입력 값이 3자리가 아닌 경우

        - ex) 1, 32, 1234, 123123 ...

    * 입력 값에 중복된 수가 있는 경우

        - ex) 111, 113, 144 ...

## 💻 기능 4 - 정답 채점

* 문제와 입력한 값을 비교하여 정답을 채점합니다.

    * ex) 문제의 정답이 425일 때

        - player가 123을 제시한 경우 : 스트라이크 + 1

        - player가 456을 제시한 경우 : 볼 + 1, 스트라이크 + 1

        - player가 789를 제시한 경우 : 볼 0, 스트라이크 0


* 채점이 완료되면 결과를 [기능 5 - 힌트 생성] 에 전달합니다.

## 💻 기능 5 - 힌트 생성

* 전달받은 채점 결과를 바탕으로 힌트를 생성합니다.

    * ex) 문제의 정답이 425일 때

        - player가 123을 제시한 경우 힌트 : 1스트라이크

        - player가 456을 제시한 경우 힌트 : 1볼 1스트라이크

        - player가 789를 제시한 경우 힌트 : 낫싱


* 힌트 전달 후 [기능 3 - 정답 입력]으로 돌아가 정답을 맞출 때 까지 반복합니다.


* 3스트라이크가 발생 했을 시에는 [기능 6 - 게임 종료]를 실행합니다.

## 💻 기능 6 - 게임 종료

* 3스트라이크로 정답을 맞추었기 때문에 게임을 종료합니다.


* 게임 종료 후 재시작 여부를 확인하기 위하여 [기능 7 -게임 재시작]을 실행합니다.

## 💻 기능 7 - 게임 재시작

* 게임 재시작 & 종료여부를 player로 부터 입력받습니다.


* camp.nextstep.edu.missionutils.Console의 readLine()을 사용하여 player가 입력하는 값을 처리합니다.


* 게임 재시작은 1, 게임 종료는 2를 입력받습니다.

    * 1 -> [기능 1 - 게임 생성]

    * 2 -> 프로그램을 완전히 종료합니다.


* [입력 값 예외처리]

    * player가 1 또는 2가 아닌 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료됩니다.

        - Error Message - [ERROR] 숫자가 잘못된 형식입니다.
  