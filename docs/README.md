# 구현할 기능 목록

## 함수의 흐름
- 숫자의 생성 
  - API를 이용한 랜덤 생성
- 숫자의 체크
  - API를 이용한 사용자의 입력
  - 사용자의 입력값과 컴퓨터의 값을 비교
    - 잘못된 값 입력시 에러출력 후 종료
      - 3자리, 중복되지 않은 숫자 만 이용가능
    - 스트라이크와 볼 개수 확인
  - 스트라이크와 볼 개수 출력
  - 정답체크
    - 3스트라이크 시에 루프문 탈출
    - 아니라면 반복 도전
- 재시작 확인
  - API를 이용한 사용자의 입력
  - 재시작 시에는 처음으로 돌아가기
  - 끝내고 싶다면 루프문 탈출

## 사용해야할 라이브러리 및 함수
- 사용자 입력
  - camp.nextstep.edu.missionutils.Console의 readLine()을 활용
- Random값 생성
  - camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용
- 잘못된 입력
  - IllegalArgumentException 활용

## 생각해봐야할 점
- 숫자의 비교
  - 자리 수 마다 비교할 예정
  - ArrayList혹은 List로 값을 저장 후 순환비교
- while문
  - 특정 조건때까지는 반복하기 때문에 조건문과 break 이용