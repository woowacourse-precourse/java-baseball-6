# 구현할 기능 목록

## 1. 랜덤하게 숫자 1~9 로 이루어진 3자리 숫자 생성

- 유의점
  - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.

## 2. 숫자 입력

- 유의점
  - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
  - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.