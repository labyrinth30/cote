package algorithm.lab_hw_0523;

import java.util.*;

public class Main_201911016 {
    public static void main(String[] args) {
        System.out.println("hw10_1: 이윤하");
        ArrayList<Edge> edges = new ArrayList<>(); // 간선을 저장할 리스트
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(); // 정점의 수
        int E = sc.nextInt(); // 간선의 수

        for (int i = 0; i < E; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            edges.add(new Edge(src, dest, weight));
        }

        new Main_201911016().Kruskal(edges, V);
        sc.close();
    }
    int find(Subset subsets[], int i) { // 부모 노드를 찾는 find 함수
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    void union(Subset subsets[], int x, int y) { // 두 집합을 합치는 union 함수
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank) // rank가 작은 집합을 rank가 큰 집합에 붙임
            subsets[xroot].parent = yroot;
        if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    void Kruskal(ArrayList<Edge> edges, int V) {
        Edge result[] = new Edge[V - 1]; // 최소신장트리를 저장할 배열

        Collections.sort(edges); // 간선들을 가중치 순으로 정렬함

        Subset subsets[] = new Subset[V]; // 부모 노드와 rank를 저장할 배열

        for (int v = 0; v < V; v++) { // 부모 노드와 rank를 초기화함
            subsets[v] = new Subset(v, 0);
        }

        int e = 0; // 최소신장트리에 들어가는 간선의 수 초기화
        int i = 0; // 간선의 인덱스를 초기화

        while (e < V - 1) { // 최소신장트리에 들어가는 간선의 수가 V-1이 될 때까지 반복하는 코드
            Edge nextEdge = edges.get(i++); // 가중치가 작은 간선부터 선택

            int x = find(subsets, nextEdge.src); // 간선의 출발지의 부모 노드를 찾음
            int y = find(subsets, nextEdge.dest); // 간선의 도착지의 부모 노드를 찾음

            if (x != y) { // 두 정점이 같은 집합에 속하지 않는 상황, 즉 사이클이 발생하지 않는 상황이면
                result[e++] = nextEdge; // 최소신장트리에 간선을 추가함
                union(subsets, x, y); // 두 집합을 합침
            }
        }

        for (i = 0; i < e; i++) { // 결과 출력
            System.out.print("(" + result[i].src + "," + result[i].dest + "," + result[i].weight + ") ");
        }
    }
}


class Edge implements Comparable<Edge> {
    int src; // 출발하는 곳
    int dest; // 도착하는 지점
    int weight; // 간선의 가중치

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge compareEdge) { // 가중치를 기준으로 정렬
        return this.weight - compareEdge.weight;
    }
}

class Subset { // 부모 노드와 rank를 저장하는 클래스
    int parent;
    int rank;

    public Subset(int parent, int rank) {
        this.parent = parent;
        this.rank = rank;
    }
}