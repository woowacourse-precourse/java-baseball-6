# 숫자 야구 게임

## 기능 구현 목록


- 컴퓨터의 난수 생성
  - Randoms API를 이용해서 난수를 answerNumbers에 저장
  - ``Randoms.pickNumberInRange``로 1~9 범위에 있는 정수를 무작위로 가져옵니다.
  - 그 후에 answerNumbers에 정수가 있는지 확인하고 없으면 add합니다.
  - 위 동작을 answerNumbers의 크기가 3이 될 때까지 반복합니다.
