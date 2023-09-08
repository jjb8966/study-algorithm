function solution(participant, completion) {
  const people = new Map();
  let answer;

  [...participant, ...completion].forEach((person) => {
    if (people.get(person)) return people.set(person, people.get(person) + 1);
    people.set(person, 1);
  });

  people.forEach((value, key) => {
    if (value % 2 !== 1) return;
    answer = key;
  });

  return answer;
}

// 아래가 성공한 답, 위가 효율성 테스트에서 실패한 답
// 똑같이 Map을 이용해 key(참여자이름) value 출발, 완주 여부 로 된 해시를 구현했습니다
// 위 아래 답에서 차이는 particpant와 completion 두개의 배열을 합쳐 for문을 돌리냐 participant만 돌리냐 인데 처음에는 그냥 아무생각없이 합쳐 돌려야지 했는데
// participant는 참여자 목록이기에 당연히 completion보다 많기에 그냥 participant로만 for문으로 돌리는 코드로 수정하였습니다

function solution(participant, completion) {
  const people = new Map();
  let answer;

  participant.forEach((person, index) => {
    people.set(person, (people.get(person) || 0) + 1);
    people.set(completion[index], (people.get(completion[index]) || 0) - 1);
  });

  people.forEach((value, key) => {
    if (value % 2 !== 1) return;
    answer = key;
  });

  return answer;
}
