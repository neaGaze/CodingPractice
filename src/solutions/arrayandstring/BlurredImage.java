package solutions.arrayandstring;

public class BlurredImage {


    /**
     * Time: O(row-3 * col-3) or O(n^2), Space: O(row-3 * col-2)   or O(n^2)
     ***/
    public int[][] blurBox(int[][] image) {
        if(image.length < 3 || image[0].length < 3) return new int[][]{{0}};
        int[][] blurredImg = new int[image.length - 2][image[0].length - 2];
        for(int r = 0; r < image.length - 2; r++) {
            for(int c =0; c < image[0].length - 2; c++) {
                int sum = 0;
                sum += (image[r][c] + image[r][c + 1] + image[r][c + 2] + image[r + 1][c] + image[r + 1][c + 1] + image[r + 1][c + 2] + image[r + 2][c] + image[r + 2][c + 1] + image[r + 2][c + 2]);
                blurredImg[r][c] = sum / 9;
            }
        }
        return blurredImg;
    }

    public static void test() {
        BlurredImage a = new BlurredImage();
        int[][] result = a.blurBox(new int[][] {{7, 4, 0, 1}, {5, 6, 2, 2}, {6, 10, 7, 8}, {1, 4, 2, 1}});
        System.out.println("The output is");
        //System.out.println(result.toString());
    }
}
