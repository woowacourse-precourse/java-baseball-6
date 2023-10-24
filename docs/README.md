# 숫자 야구 게임

## 기능 목록:
- 컴퓨터의 세 자리 난수 발생
- 사용자의 세 자리 수 입력
- 컴퓨터와 사용자의 숫자 비교 후 결과 출력
- 잘못된 값을 입력했을 때의 예외처리
- 게임 시작과 종료 관리

## Class ComNumberGenetator : 컴퓨터의 세 자리 난수 발생
| 이름 | 구분 | 역할 |
|:--:|:--:|:--|
|  comGenerateNum           | method | 컴퓨터 세 자리 난수 발생 |
|  getComGenerateNumList    | method | 컴퓨터 발생 숫자 리스트 반환                                | 
|  comGenerateNumList       | 변수(List)   | 컴퓨터 발생 숫자 Int 형식의 리스트로 저장                    | 
|  stringComGenerateNumList | 변수(List)   | Int형 리스트인 comGenerateNumList를 String 형식으로 저장    | 
---
## Class UserNumInputManager : 사용자의 세 자리 수 입력
| 이름 | 구분 | 역할 |
|:--:|:--:|:--:|
|  inputUserNum           | method | 사용자에게 숫자를 입력 받은 후 리스트에 저장  |
|  getUserInputNumList    | method | 사용자가 입력한 숫자 리스트를 반환           | 
|  userInputNum        | 변수(Int)   | 사용자가 입력한 수를 저장        | 
|  userInputNumList | List<String> | userInputNum을 리스트로 저장  | 
---
## Class ResultPrinter : 컴퓨터와 사용자의 숫자 비교 후 결과 출력
| 이름 | 구분 | 역할 |
|:--:|:--:|:--:|
|  printGameResult  | method | 컴퓨터의 숫자와 사용자가 입력한 숫자를 비교하여 strike ball 결과 출력 |         
---
## Class ExceptionHandler : 잘못된 값을 입력했을 때의 예외처리
| 이름 | 구분 | 역할 |
|:--:|:--:|:--:|
|  cautionLength       | method | 입력한 숫자가 세 자리가 아닐 때 예외처리 |
|  cautionDuplicate    | method | 중복된 숫자가 입력됐을 때 예외처리    | 
|  cautionNotNumber    | method | 숫자가 아닌 값이 입력됐을 때 예외처리 | 
---
## Class GamestartManager : 게임 시작과 종료 관리
| 이름 | 구분 | 역할 |
|:--:|:--:|:--:|
|  startGame  | method | 게임 시작 메세지 출력 + 게임 종료 후 사용자의 선택에 따라 재시작 여부 결정  |
---
