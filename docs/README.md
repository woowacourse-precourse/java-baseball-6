# 숫자 야구
<hr>

## 기능 요구 사항
- 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
- 같은 수가 같은 자리에 있으면 **스트라이크**
- 같은 수가 다른 자리에 있으면 **볼**
- 같은 수가 전혀 없으면 **낫싱**이란 문구를 출력한다. 

<hr>

## 라이브러리
- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하였습니다.
- Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용히였습니다.
- 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용하였습니다.

<hr>

# 구현 기능 목록
## Random 값 추출기능
-  1부터 9사이의 3개의 난수 발생
- pickNumberInRange()를 활용
- computer 
- 메서드로 처리 getNewRandomNumber

## 입력기능 
- 중복 없는 세 자리 숫자 입력
- 게임 종료 및 재시작 의사결정을 위한 1, 2 입력
- readLine()을 활용
- inputNumber(String)에 저장


## 비교
- 랜덤값과 사용자 입력한 숫자 비교

## 출력
- 게임 시작을 위한 안내문 출력
- 사용자가 입력한 값에 해당하는 스트라이크 볼 낫싱값 출력
- 게임 종료 안내문 출력
- 게임 종료 및 재시작에 관한 안내문 출력 


## 입력 검증 기능 
- 잘못 된 입력시 IllegalArgumentException을 발생시켜 프로그램을 종료
- 사용자가 입력하는 3개의 숫자 검증
- 문자, 중복된 숫자, 0을 포함한 숫자, 3자리가 아닌 숫자일 경우의 오류 발생
- 프로그램 재시작 및 종료 결정을 위한 숫자 1, 2 값 외의 숫자 입력시 오류 발생
- 매서드로 처리 rightNumber()



