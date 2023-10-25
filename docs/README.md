# 📖 구현할 기능 목록

### ✔ 숫자 야구 게임 점수 산정 기능

- [x] 스트라이크 개수 카운트: `int countStrike()`
- [x] 컴퓨터의 수와 유저의 수 중 같은 숫자의 개수 카운트: `int countSameNumber()`

### ✔ 숫자 생성 기능

- [x] 컴퓨터의 숫자를 생성: `int generateComputerNumber()`
- [x] 사용자의 숫자를 입력: `int generateUserNumber()`

### ✔ 사용자의 입력 검증

- [x] 사용자의 입력이 조건에 맞는 입력인지 검증: `int isValidateNumber()`
  - [x] `Integer.parseInt()`가 되지 않는 입력인 경우 예외 처리
  - [x] 3자리 숫자가 아닌 경우 예외 처리
  - [x] 사용자의 입력에 0이 포함된 경우 예외 처리
  - [x] 사용자의 입력에 중복된 숫자가 포함된 경우 예외 처리
- [x] 사용자가 입력한 문자열 안에 중복된 숫자가 있는 검사: `boolean isDuplicate`
- [x] 게임을 계속할지 중단할지 결정하기 위해 입력하는 숫자에 대한 검증: `int getOptionNumber()`

### ✔ UI 출력

- [x] 게임을 새로 시작할지 중단할지 사용자의 입력을 받는 기능: `String selectOption()`
- [x] 사용자의 숫자를 입력 받는 기능: `String userInput()`
- [x] 게임 시작을 알리는 멘트를 출력하는 기능: `void startGame()`

### ✔ 사용자의 입력에 따른 힌트 출력

- [x] 사용자의 입력에 따라서 스트라이크와 볼, 또는 낫싱을 출력하는 기능: `void printHint()`
