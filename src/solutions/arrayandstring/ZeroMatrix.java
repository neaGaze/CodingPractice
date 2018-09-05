package solutions.arrayandstring;

/**
 * Created by neaGaze on 8/26/18.
 */
public class ZeroMatrix extends BaseClass {

    private int[][] matrix;

    public ZeroMatrix() {}

    public ZeroMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public void run() {

        System.out.println("Before rotation");
        print(matrix);

        boolean hasZeroRow = false, hasZeroCol = false;
        for(int i = 0; i < matrix.length; i++)
            if(matrix[i][0] == 0) hasZeroCol = true;

        for(int i = 0; i < matrix[0].length; i++)
            if(matrix[0][i] == 0) hasZeroRow = true;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        System.out.println("mid rotation");
        print(matrix);

        // now nullify the zero rows
        for(int i = 1; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                for(int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // now nullify the zero cols
        for(int i = 1; i < matrix[0].length; i++) {
            if(matrix[0][i] == 0) {
                for(int j = 1; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        // nullify the first row
        if(hasZeroRow) {
            for(int i = 0; i < matrix[0].length; i++)
                matrix[0][i] = 0;
        }

        // nullify the first col
        if(hasZeroCol) {
            for(int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
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
        ZeroMatrix matrix = new ZeroMatrix(new int[][]{{1, 0, 4, 6}, {1, 1, 0, 8}, {3, 1, 9, 6}, {4, 1, 8, 5}});
        matrix.run();
    }
}
