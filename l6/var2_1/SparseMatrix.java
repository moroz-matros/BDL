package l6.var2_1;

import java.util.ArrayList;

class SparseMatrix {
    private int m, n;
    public ArrayList<Node> nodeHeads;

    class Node {
        int row;
        int col;
        int value;

        Node next;

        public Node(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
            this.next = null;
        }
    }

    public SparseMatrix(int[][] mtx) {
        n = mtx.length;
        m = mtx[0].length;

        nodeHeads = new ArrayList<Node>(n);
        for (int i = 0; i < mtx.length; i++) {
            Node head = new Node(-1, -1, 0);
            Node tail = head;
            for (int j = 0; j < mtx[i].length; j++) {
                if (mtx[i][j] != 0) {
                    Node tmp = new Node(i, j, mtx[i][j]);
                    tail.next = tmp;
                    tail = tmp;
                }
            }
            nodeHeads.add(i, head.next);
        }
    }

    public SparseMatrix sum(SparseMatrix mtx) {
        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            // get heads
            int idxj = 0, val = 0;
            Node node1 = nodeHeads.get(i), node2 = mtx.nodeHeads.get(i);
            while (node1 != null || node2 != null) {
                if (node1 != null && node2 != null && node1.col == node2.col) {
                    idxj = node1.col;
                    val = node1.value + node2.value;
                    node1 = node1.next;
                    node2 = node2.next;
                }
                // met zero elems
                else if (node1 == null || (node2 != null && node2.col < node1.col)) {
                    idxj = node2.col;
                    val = node2.value;
                    node2 = node2.next;
                } else if (node2 == null || (node1 != null && node1.col < node2.col)) {
                    idxj = node1.col;
                    val = node1.value;
                    node1 = node1.next;
                }
                matrix[i][idxj] = val;
            }
        }
        return new SparseMatrix(matrix);
    }

    public SparseMatrix transpose() {
        int[][] matrix = new int[m][n];

        for (int i = 0; i < n; i++) {
            Node node = nodeHeads.get(i);

            while (node != null) {
                int j = node.col;
                matrix[j][i] = node.value;
                node = node.next;
            }
        }
        return new SparseMatrix(matrix);
    }

    public SparseMatrix multiply(SparseMatrix mtx) {
        int[][] matrix = new int[n][mtx.m];

        for (int i = 0; i < n; i++) {
            Node node1 = nodeHeads.get(i);

            while (node1 != null) {
                Node node2 = mtx.nodeHeads.get(node1.col);

                while (node2 != null) {
                    matrix[i][node2.col] += node1.value * node2.value;
                    node2 = node2.next;
                }

                node1 = node1.next;
            }
        }
        return new SparseMatrix(matrix);
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            Node node = nodeHeads.get(i);
            for (int j = 0; j < m; j++) {
                if (node.row == i && node.col == j) {
                    System.out.printf("%d ", node.value);
                    node = node.next;
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}