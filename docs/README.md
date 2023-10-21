# 숫자 야구 구현 기능 목록

## 시작 문구 출력
 - 게임 시작시 시작 문구를 출력

## 컴퓨터 숫자 생성
 - 각 자릿수가 다르고, random하게 세 자리 숫자 생성
 - camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 사용하여 random한 number를 생성
 - 1~9 사이의 수인지 여부와 중복된 숫자가 존재하는지 검증 후에 생성

## 사용자의 정답 예측값 입력
 - camp.nextstep.edu.missionutils.Console의 readLine()으로 사용자가 값을 입력
 - isValidNumber 메서드로 입력값의 유효 여부를 판단
   - isNumberNaturalDigit 메서드로 입력된 숫자가 1~9사이의 숫자인지 여부를 확인
   - isValidLength 메서드로 입력된 숫자가 유효한 길이인지 여부를 확인
   - sameNumberCheck 메서드로 입력된 숫자 안의 중복 여부를 확인
 - stringToIntegerList 메서드로 숫자 문자열을 입력 받아 각 자릿수를 int 타입으로 가지는 리스트로 반환
 - 유효하지 않은 숫자일 경우 IllegalArgumentException을 발생시킨 후 애플리케이션을 종료
 

## 게임 결과 출력
 - printGameResult 메서드를 통하여 입력값에 따른 결과를 출력
   - 스트라이크, 볼, 낫싱 여부를 확인하여 출력
     - 스트라이크 개수가 3이면 스트라이크 개수를 출력하고 게임 종료
     - 스트라이크와 볼 개수가 모두 0이면 낫싱을 출력
     - 스트라이크와 볼 개수가 모두 1 이상이면 스트라이크와 볼 개수 출력
     - 스트라이크 개수가 1 이상이고 볼 개수가 0이면 스트라이크 개수만 출력
     - 볼 개수가 1 이상이고 스트라이크 개수가 0이면 볼 개수만 출력

## 스트라이크 개수 count
 - countStrike 메서드를 활용하여 스트라이크의 개수를 count

## 볼 개수 count
 - countBall 메서드를 활용하여 볼 개수를 count
   - sameCount 메서드와 countStrike 메서드를 활용하여 볼 개수 산출

## 게임 종료 기능
 - 스트라이크 수가 3개면 true 값을 리턴하고 종료 문구 출력
 - 스트라이크 수가 3개가 아닌 경우 false 값 리턴
 - true 값이 리턴되기 전까지 게임 진행
 - 잘못된 값을 입력할 경우 프로그램 종료

## 게임 종료 후 재시작 or 프로그램 종료 여부 선택
 - 게임이 종료되면 질문 문구 출력
 - camp.nextstep.edu.missionutils.Console의 readLine()으로 사용자가 값을 입력
 - 숫자 1을 입력시 재시작
 - 숫자 2를 입력시 프로그램 종료
 - 숫자 1,2 이외의 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 프로그램을 종료

## 예외상황 처리
 - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 예외 문구를 출력한 후, 애플리케이션을 종료
   - 사용자의 정답 예측값 입력 로직과 게임 종료 후 값 입력 로직에서 벗어나는 값을 사용자가 입력했을 경우에 적용
