# 숫자 야구

## 기능 목록

- [ ] 컴퓨터 숫자 3개 생성 기능
- [ ] 플레이어가 숫자 입력 기능
    - [ ] 예외 처리
- [ ] 스트라이크 / 볼 판별 기능
    같은 수 같은 자리 -> 스트라이크, 다른 자리 -> 볼, 없으면 낫싱
- [ ] 입력한 숫자에 대한 결과 출력 기능
  - [ ] 모두 맞출 경우 게임 종료
  - [ ] 하나도 못 맞출 경우 낫싱 출력
  - [ ] 몇 스트라이크 몇 볼인지 출력
- [ ] 게임 종료 시 사용자 입력 받기
    - [ ] 재시작 또는 프로그램 종료
    - [ ] 예외 처리

## 주의점

- [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 준수
- System.exit() 가 아닌 로직으로 프로그램 종료하기
- `camp.nextstep.edu.missionutils.*` 제공 라이브러리 사용하기
  - pickNumberInRange() : 랜덤 값 추출
  - readLine() : 사용자 입력 받기

    
