## 주의사항

1. java 17 버전 사용할 것
2. build.gradle 변경 불가
3. java 코드 컨벤션 참고
4. 종료 시 System.exit() 호출 X
5. test 모두 성공해야함
6. 라이브러리
    - camp.nextstep.edu.missionutils API 사용
        - Randoms - pickNumberInRange()
        - Console - readLine()

## 기능 요구사항

1. 게임 시작 문구 출력
2. 3자리 숫자 만들기 (random)
3. 사용자 입력받기
    - 잘못된 값 입력 시 IllegalArgumentException 발생, 종료
4. 게임 결과 확인
    - 같은 수 같은 자리 → 스트라이크
    - 같은 수 다른 자리 → 볼
    - 같은 수 없음 → 낫싱
    - 3개 숫자 모두 맞춤 → 3스트라이크 + 게임 종료 문구
5. 재시작 여부 확인
    - 사용자 입력 1/2 (재시작/종료)

## 구현 기능 목록

- [x] num - int 변수 3개,
    - [x] compareNum()
- [x] baseballGameService
    - [x] initNum : user, computer num 생성
    - [x] compareNum : user, computer num 비교
    - [x] reInputUserNum : user num 입력받기
    - [x] inputRestart : 재시작 여부 입력받기
    - [x] game : 게임 진행
    - [x] exitGame : 게임 종료

