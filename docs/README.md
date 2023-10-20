# 숫자 야구 요구사항

## 시작 문구 출력
 - 게임 시작시 시작 문구를 출력

## 컴퓨터 숫자 생성
 - 각 자릿수가 다르고, random하게 세 자리 숫자 생성
 - camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 사용 random한 number를 생성

## 사용자의 정답값 입력
 - isValidNumber 

## 게임 결과 출력

## 스트라이크 개수 count

## 볼 개수 count

## 게임 종료 기능
 - 스트라이크 수가 3개면 true 값 리턴, 아니면 false 값 리턴
 - true 값이 리턴되기 전까지 게임 진행
 - 잘못된 값을 입력할 경우 프로그램 종료

## 게임 종료 후 재시작 or 프로그램 종료 여부 선택
 - 게임이 종료되면 질문 문구 출력
 - camp.nextstep.edu.missionutils.Console의 readLine()으로 사용자가 값을 입력
 - 숫자 1을 입력시 재시작
 - 숫자 2를 입력시 프로그램 종료
 - 잘못된 값을 입력할 경우 프로그램 종료

## 예외상황 처리

 - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션을 종료
