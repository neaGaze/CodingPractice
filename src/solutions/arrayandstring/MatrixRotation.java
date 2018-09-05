package solutions.arrayandstring;

/**
 * Created by neaGaze on 8/25/18.
 */
public class MatrixRotation extends BaseClass {

    private int[][] matrix;

    public MatrixRotation() {}

    public MatrixRotation(int[][] matrix) {
        this.matrix = matrix;
    }

    public void run() {
        if(matrix.length == 0 || matrix.length != matrix[0].length) return;
        
        System.out.println("Before rotation");
        print(matrix);
        for(int layer = 0; layer < (matrix.length / 2); layer++) {
            int start = layer;
            int end = matrix.length - 1 - layer;
            for(int i = start; i < end; i++) {
                int offset = matrix.length - 1 - i;
                int tmp = matrix[start][i];
                matrix[start][i] = matrix[offset][start];
                matrix[offset][start] = matrix[end][offset];
                matrix[end][offset] = matrix[i][end];
                matrix[i][end] = tmp;
            }
        }
        System.out.println("After rotation");
        print(matrix);
    }

    public void print(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(this.matrix[i][j]+" ");
            }
            System.out.println("\n");
        }
    }

    @Override
    public void test() {
        super.test();
        MatrixRotation mat1 = new MatrixRotation(new int[][]{{1, 2 ,3}, {4, 5, 6}, {7, 8, 9}});
        mat1.run();

        MatrixRotation mat2 = new MatrixRotation(new int[][]{{1, 2 ,3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
        mat2.run();
    }
}
