package algorithm.lab_hw_0502;

import java.util.Scanner;

public class Hw8_1 {
    public static void main(String[] args) {
        System.out.println("hw8_1: 이윤하");
        Scanner input = new Scanner(System.in);

        // 사용자가 원하는 갯수의 원소를 갖는 상호배타적 집합 MySet 객체를 생성(set)
        int n = input.nextInt();
        MySet set = new MySet(n);

        // 사용자가 원하는 횟수의 union 연산을 수행
        int numberOfUnions = input.nextInt();
        for (int i = 0; i < numberOfUnions; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            set.union(x, y);
        }

        // 트리 구현을 확인하기 위해 모든 원소에 대해 각 원소의 부모를 출력
        set.printParent();

        // 모든 원소에 대해 findSet 연산을 수행
        for(int x = 0; x < n; x++) {
            set.findSet(x);
        }

        // 트리 구현을 확인하기 위해 모든 원소에 대해 각 원소의 부모를 출력
        set.printParent();

        input.close();
    }
}

class MySet {
    // 각 원소의 부모를 나타내는 배열 parent
    private final int[] parent;

    public MySet(int n) {
        // 각 원소의 부모를 저장하는 배열 parent를 생성
        parent = new int[n];
        makeSet(n);
    }

    public void printParent() {
        // 각 원소의 부모를 출력
        for (int i : parent) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private void makeSet(int n) {
        // 각 원소의 부모를 자기 자신으로 초기화
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int findSet(int x) {
        // 경로 압축을 사용한 findSet 연산
        if (x != parent[x]) {
            parent[x] = findSet(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        x = findSet(x);
        y = findSet(y);

        // 노드 x가 속한 집합에 노드 y가 속한 집합을 합친다.
        if (x != y) {
            parent[y] = x;
        }
    }
}
