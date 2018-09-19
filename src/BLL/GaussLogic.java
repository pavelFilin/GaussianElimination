package BLL;

public class GaussLogic {
    public void transformToTriangleMatrix(Double[][] matrix) {
        int x = 0;
        int y = 0;
        while (x < matrix[0].length - 1 && y < matrix.length - 1) {
            if (matrix[y][x] == 0) {
                y++;
                x++;
                continue;
            } else {
                popToUpMaxInColumn(matrix, x, y);
                int tempY = y;
                while (tempY < matrix.length - 1) {
                    double coefficient = matrix[tempY + 1][x] / matrix[y][x];
                    if (tempY < matrix.length - 1) {
                        multiplyRow(matrix, coefficient, y);
                    }
                }
            }
        }
    }

    private void multiplyRow(Double[][] matrix, double coefficient, int y) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[y][i] *= coefficient;
        }
    }

    private void deductRow(Double[][] matrix, int a, int b) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[a][i] -= matrix[b][i];
        }
    }


    private void popToUpMaxInColumn(Double[][] matrix, int x, int y) {
        double max = matrix[y][x];
        int maxRow = y;
        for (int i = y; i < matrix.length; i++) {
            if (max < matrix[i][x]) {
                max = matrix[i][x];
                maxRow = y;
            }
        }
        if (maxRow != y) {
            swapRow(matrix, y, maxRow);
        }
    }

    private void swapRow(Double[][] matrix, int a, int b) {
        double temp = 0d;
        for (int i = 0; i < matrix[0].length; i++) {
            temp = matrix[b][i];
            matrix[b][i] = matrix[a][i];
            matrix[a][i] = temp;
        }
    }
}
