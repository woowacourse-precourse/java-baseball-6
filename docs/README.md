# 📋기능 요구 사항

# 실행 흐름에 따른 기능 목록

## ⏳ 순서1 - 프로그램 시작 [✅]

프로그램을 시작합니다.

시작 화면을 출력합니다.

## ⏳ 순서2 - 정답 생성 [✅]

게임의 정답을 생성합니다.

* `camp.nextstep.edu.missionutils.Console.Randoms`를 사용하여 랜덤한 숫자를 생성해야 합니다.

* 정답 조건
    * 3개의 숫자여야 합니다.
    * 숫자의 범위는 1~9여야 합니다.
    * 중복된 숫자가 없어야 합니다.

## ⏳ 순서3 - player 추측 입력 받기 [✅]

player로부터 값을 입력 받습니다.

* `camp.nextstep.edu.missionutils.Console.readLine`을 사용하여 입력 받아야 합니다.

* 입력 조건
    * 길이가 3인 문자열이여야 합니다.
    * 숫자로 변환 후 정답의 조건과 동일해야 합니다.
    * 잘못된 값을 입력한 경우 `IllegalArgumentException`을 발생시킨 후 앱을 종료해야 합니다.

## ⏳ 순서4 - 힌트 생성 및 출력 [✅]

게임의 정답과 player의 추측 값을 비교한 결과로 힌트를 생성합니다.
힌트 결과를 출력합니다.

* `낫싱`, `X볼`, `X스트라이크`, `X볼 X스트라이크` 중 하나로 출력
* ex) 게임의 정답이 123인 경우
    * player가 789로 추측 : `낫싱`
    * player가 235로 추측 : `2볼`
    * player가 145로 추측 : `1스트라이크`
    * player가 321로 추측 : `2볼 1스트라이크`

* 힌트 결과에 따른 분기
    * `3스트라이크` : 순서5로 넘어갑니다.
    * `3스트라이크`가 아닌 경우 : 순서2로 돌아갑니다.

## ⏳ 순서5 - 게임 종료 [✅]

게임 종료 화면을 출력합니다.

## ⏳ 순서6 - 재시작 여부 확인 [✅]

player로부터 게임을 재시작 여부를 입력받습니다.

* `camp.nextstep.edu.missionutils.Console.readLine`을 사용하여 입력 받아야 합니다.
* 입력 조건
    * 길이가 1인 문자열이어야 합니다.
    * 숫자로 변환 후 1 또는 2여야 합니다.
    * 잘못된 값을 입력한 경우 `IllegalArgumentException`을 발생시킨 후 앱을 종료합니다.

* 입력 값에 따른 분기
    * 1 : 순서2로 돌아갑니다.
    * 2 : 숫자 야구 게임을 종료합니다.

---

# MVC패턴에 따른 기능 목록

## 🧑 Model

### ./model/NumberList

숫자 야구 게임에 사용되는 3개의 숫자를 관리하는 객체

* 생성자에서 숫자 야구 게임 규칙에 위배되지 않는지 검증
* 두 NumberList 객체 간 비교 기능 구현

### ./model/Computer

컴퓨터 역할을 할 객체

* 정답을 랜덤하게 생성하는 기능 구현
* player의 추측 값과 정답을 비교하여 힌트 생성하는 기능 구현

### ./model/Hint

힌트 데이터를 저장하기 위한 객체

### ./model/Restart

재시작 여부 데이터를 저장하기 위한 객체

## 🔎 View

### ./view/InputView

player가 입력할 때 출력되는 화면 구현

* player가 추측 값 입력 하는 화면 출력 기능
* player가 게임 재시작 여부를 입력 하는 화면 출력 기능

### ./view/OutputView

player에게 일방적으로 결과를 출력해줄 때 사용되는 화면 구현

* 프로그램 시작 화면 출력 기능
* 힌트 결과 출력 기능
* 게임 종료 화면 출력 기능

## 🎮 Controller

### ./controller/MainController

전체 프로그램의 흐름을 제어하는 컨트롤러

* 게임 시작 화면 출력
* BaseballGameController를 통해 숫자 야구 게임 진행

### ./controller/BaseballGameController

숫자 야구 게임을 진행하는 컨트롤러

### ./controller/BaseballGameController.InputController

BaseballGameController에서 player 입력을 받는 부분에 대한 로직을 처리하는 컨트롤러

* player로부터 추측 값 입력 받는 기능 구현
* player로부터 게임 재시작 여부 입력 받는 기능 구현

## 기타

### ./utils/Convert

임의의 타입을 원하는 다른 타입으로 변경해주는 메소드들을 구현할 공간

* 3개의 숫자가 담긴 String을 NumberList 객체로 변환해주는 기능 구현

### ./Validator/Validator

범용적으로 사용할 수 있는 검증 함수들을 구현할 공간