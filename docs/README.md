# 기능 요구 사항

# 실행 흐름에 따른 입출력과 예외 처리

1. 프로그램 시작 화면을 출력한다.
2. 숫자 야구 게임을 진행한다.
    1. 서로 다른 3자리의 수를 입력받는다.
        * 1~9로 이루어진 3자리의 정수를 입력받아야 한다.
    2. 힌트 결과를 출력한다.
        * 결과는 낫싱, 볼, 스트라이크로 구분한다.
    3. 힌트 결과가 3스트라이크일 때까지 i, ii 과정을 반복한다.
    4. 게임 종료 화면을 출력한다.
3. 게임을 새로 시작(1)할 지, 종료(2)할 지 입력받는다.
    * 입력받는 값은 1자리 정수 1, 2만 가능하다.
    * 1을 입력받으면 2번으로 돌아간다.
    * 2를 입력받으면 프로그램을 종료한다.

# MVC패턴에 따른 구현해야 할 기능 목록

## 🧑 Model

### ./model/NumberList

야구게임에 사용할 3개의 숫자 데이터를 저장할 용도의 모델

* [x] 두 NumberList 객체 간 비교 기능 구현

### ./model/Computer

컴퓨터 역할을 할 객체

NumberList만을 인스턴스로 가지고 있는 일급 컬렉션(?)

### ./model/User

유저 역할을 할 객체

NumberList만을 인스턴스로 가지고 있는 일급 컬렉션(?)

### ./model/Hint

볼, 스트라이크 개수 정보를 저장하기 위한 모델

## 🔎 View

### ./view/InputView

사용자에게 입력값을 받을 때 출력되는 화면 구현

* [x] 사용자로부터 3자리 정수를 입력받는 화면 출력
* [x] 게임 재시작 혹은 종료를 위한 정수를 입력받는 화면 출력

### ./view/OutputView

사용자에게 일방적으로 결과를 출력해줄 때 사용되는 화면 구현

* [x] 프로그램 시작 화면 출력
* [x] 힌트 결과 출력
* [x] 프로그램 종료 화면 출력

## 🎮 Controller

### ./controller/MainController

전체 프로그램의 흐름을 제어하는 컨트롤러

* [x] GameController를 통해 숫자 야구 게임 진행
* [x] 게임 재시작/종료 여부 처리

### ./controller/MainController.InputController (MainController의 inner class)

MainController 내에서 사용자 입력을 받는 부분에 대한 로직을 처리하는 컨트롤러

* [x] 사용자로부터 게임 재시작 여부 입력 받기 + 예외 처리
* [x] 게임 시작 화면 출력

### ./controller/GameController

숫자 야구 게임을 진행하는 컨트롤러

* [x] 랜덤한 3자리 수를 선택하는 기능
* [x] 사용자로부터 게싱 정보를 받아 컴퓨터의 정답과 비교 후, 힌트 결과 생성 및 출력

### ./controller/GameController.InputController (GameController의 inner class)

GameController 내에서 사용자 입력을 받는 부분에 대한 로직을 처리하는 컨트롤러

* [x] 사용자로부터 3자리 수 입력 받기 + 예외 처리

## 기타 유틸

### ./utils/Convert

임의의 타입을 원하는 다른 타입으로 변경해주는 메소드들을 모아놓을 공간

* [x] 3개의 숫자가 담긴 String을 NumberList 객체로 변환해주는 기능 구현