# 구현할 기능 목록 정리

1. `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 이용하여 1~9로 이뤄진 서로 다른 세 자리 숫자를 생성한다.
2. 사용자의 입력은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`로 입력받는다.
3. `try-catch`문으로 감싸서 1~9가 아니거나(숫자로 형변환 후 범위 검사) 서로 다른 세 숫자가 아닐 경우 `IllegalArgumentException`을 발생시킨다.
4. 위 입력은 while문으로 게임이 종료될 때까지 반복한다.
5. 배열의 인덱스를 이용해 같은 수가 같은 자리에 있으면 스트라이크에 대한 카운트 strikeCnt를 늘린다.
6. 다른 자리에 있으면 볼에 대한 카운트 ballCnt를 늘린다.
7. 결과 출력 시 ballCnt나 strikeCnt가 0이 아니면 스트라이크나 볼의 점수를 출력한다.
8. ballCnt와 strikeCnt이 모두 0이면 (혹은 else) 낫싱을 출력한다.
9. strikeCnt이 3이면 "3개의 숫자를 모두 맞히셨습니다! 게임 종료"를 출력한다.
10. 이어서 "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."를 출력한 뒤 사용자에게 숫자를 위의 2, 3과 같은 방식으로 입력받는다. 새로 시작하려면 숫자 생성을 새로 하여 게임을 재시작하고, 종료 시 프로그램을 종료한다.
11. strikeCnt이 3이 아니면 결과 출력 후 다시 while문의 초기로 돌아가서 사용자에게 숫자를 입력받는다.