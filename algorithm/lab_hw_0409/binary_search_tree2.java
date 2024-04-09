package algorithm.lab_hw_0409;
public class binary_search_tree2 {
    public static void main(String[] args) {
        System.out.println("hw6_1:이윤하");

        // (1) 연산에 사용할 키값 배열 초기화
        int[] addList = {13, 6, 2, 10, 1, 5, 7, 11, 4, 3, 8, 9, 3, 6, 10, 13};
        int[] searchList = {12, 3, 6, 10, 13};
        int[] removeList = {12, 3, 6, 10, 13, 2, 1, 5, 4, 7, 8, 9, 11};

        // (2) 정수 키값을 저장할 공백 이진검색트리 tree를 생성
        MyBinarySearchTree tree = new MyBinarySearchTree();

        // (3) addList에 저장된 키값들을 차례대로 트리에 삽입
        for(int i = 0; i < addList.length; i++) {
            tree.add((addList[i]));
        }

        // (4) tree를 중순위 순회하여 키값을 출력
        tree.inorder();

        // (5) searchList에 저장된 키값들을 차례대로 트리에서 검색하여 결과 출력
        for(int i = 0; i < searchList.length; i++) {
            System.out.print(tree.contains(searchList[i]) + " ");
        }
        System.out.println();

        // (6) tree의 키값 합을 구하여 출력
        System.out.println(tree.sum());

        // (7) removeList에 저장된 키값들을 차례대로 트리에서 삭제 **** 선택 과제
        for(int i = 0; i < removeList.length; i++) {
            tree.remove((removeList[i]));
        }

        // (8) tree를 중순위 순회하여 키값을 출력 **** 선택 과제
        tree.inorder();

        // (9) tree의 키값 합을 구하여 출력 **** 선택 과제
        System.out.println(tree.sum());
    }
}

// 정수 키값을 갖는 이진검색트리를 구현하는 클래스
class MyBinarySearchTree {
    private Node root = null;    // 루트 노드를 가리키는 인스턴스 변수

    // 노드의 구조를 정의하는 클래스
    private class Node {
        int key;
        Node left;
        Node right;
    }

    // 트리를 중순위 순회하는 public 메소드 - 구현 세부사항을 알지 못해도 호출할 수 있음
    public void inorder() {
        System.out.print("( ");
        inorder(root);
        System.out.println(")");
    }

    // t를 루트로 하는 트리를 중순위 순회하여 키값 출력 - 매개변수(루트노드 t)로 인해 구현 세부사항을 알아야 호출할 수 있으므로 private 메소드로 따로 두었음
    private void inorder(Node t) {
        if (t != null) {
            inorder(t.left);
            System.out.print(t.key + " ");
            inorder(t.right);
        }
    }

    // 매개변수로 받은 키값을 트리에 삽입 - 구현 세부사항을 알지 못해도 호출할 수 있음
    public void add(int key) {
        root = treeInsert(root, key);
    }

    // t를 루트로 하는 트리에 key를 삽입하고 삽입 후 루트 노드를 리턴 - 매개변수(루트노드 t)로 인해 구현 세부사항을 알아야 호출할 수 있으므로 private 메소드로 따로 두었음
    private Node treeInsert(Node t, int key) {
        if (t == null) {
            Node r = new Node();
            r.key = key;
            return r;
        } else if (key < t.key) {
            t.left = treeInsert(t.left, key);
            return t;
        } else if (key > t.key) {
            t.right = treeInsert(t.right, key);
            return t;
        } else {
            return t;  // 이미 존재하는 키값인 경우
        }
    }

    // 키 값을 매개변수로 받아 그 키값 존재 여부를 리턴
    public boolean contains(int key) {
        Node t = root;
        if (t == null) { // 공백 트리인 경우
            return false;
        }
        while (t != null) {
            if (key < t.key) { // 검색하는 키값이 현재 노드의 키값보다 작은 경우
                t = t.left; // 왼쪽 서브트리로 이동
            } else if (key > t.key) { // 검색하는 키값이 현재 노드의 키값보다 큰 경우
                t = t.right; // 오른쪽 서브트리로 이동
            } else {
                return true; // 검색하는 키값이 현재 노드의 키값과 같은 경우 검색 성공
            }
        }
        return false; // 검색하는 키값이 트리에 존재하지 않는 경우
    }

    // 트리의 키값 합을 구하여 리턴
    public int sum() {
        return sum(root);
    }

    // t를 루트로 하는 트리의 키값 합을 구하여 리턴
    private int sum(Node t) {
        if(t == null) { // 공백 트리인 경우
            return 0;
        }
        else { // 공백 트리가 아닌 경우
            return t.key + sum(t.left) + sum(t.right); // 현재 노드의 키값과 왼쪽과 오른쪽 서브트리의 키값의 합을 리턴함
        }
    }

    // 매개변수로 받은 키값을 트리에서 삭제. 키값이 없으면 삭제하지 않으면 됨 **** 선택 과제
    public void remove(int key) {
        Node parent = null; // 삭제하려는 노드의 부모 노드를 가리키는 변수
        Node current = root; // 삭제하려는 노드를 가리키는 변수
        while (current != null) { // 삭제하려는 노드를 찾을 때까지 반복
            if (key < current.key) { // 삭제하려는 노드가 현재 노드의 키값보다 작은 경우
                parent = current; // 부모 노드를 현재 노드로 설정
                current = current.left; // 왼쪽 자식 노드로 이동
            } else if (key > current.key) { // 오른쪽도 동일하게 처리
                parent = current;
                current = current.right;
            } else {
                // 삭제하려는 노드를 찾으면 treeDelete를 호출
                treeDelete(current, parent);
                return; // 삭제 후 함수 종료
            }
        }
    }

    // 부모 노드가 p인 노드 r을 트리에서 삭제 **** 선택 과제
    private void treeDelete(Node r, Node p) {
        // 삭제하려는 노드가 루트 노드인 경우
        if (r == root) {
            root = deleteNode(r);
        }
        // 삭제하려는 노드가 루트 노드가 아닌 경우
        else {
            if (p.left == r) { // r이 p의 왼쪽 자식인 경우
                p.left = deleteNode(r); // p의 왼쪽 자식을 삭제
            } else { // r이 p의 오른쪽 자식인 경우
                p.right = deleteNode(r); // p의 오른쪽 자식을 삭제
            }
        }
    }

    // 노드 r을 삭제하고 r을 대신할 노드를 리턴 **** 선택 과제
    private Node deleteNode(Node r) {
        // 노드 r의 자식이 없는 경우
        if (r.left == null && r.right == null) {
            return null;
        }
        // 노드 r의 자식이 하나인 경우
        if (r.left == null || r.right == null) {
            // 노드 r의 자식이 왼쪽이 남은 경우 경우 r.right를 리턴하고
            // 오른쪽이 남은 경우 r.left를 리턴함
            return r.left == null ? r.right : r.left;
        }
        // 노드 r의 자식이 둘 다 있는 경우
        // 오른쪽 서브트리에서 가장 작은 노드(후속자)를 찾음
        Node successor = r.right;
        while (successor.left != null) {
            successor = successor.left;
        }
        // 후속자 노드의 키값을 삭제하려는 노드의 키값으로 변경
        r.key = successor.key;
        // 후속자 노드를 삭제하고 후속자 노드의 오른쪽 자식을 리턴
        r.right = deleteNode(successor);
        return r;
    }
}