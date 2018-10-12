package BLL;

public class GaussLogic {

    public void transformToTriangleMatrix(Double[][] matrix) {
        int x = 0;
        int y = 0;
        while (x < matrix[0].length - 1 && y < matrix.length - 1) {
            if (matrix[y + 1][x] == 0) {
                y++;
                x++;
                continue;
            } else {
                popToUpMaxInColumn(matrix, x, y);
                int tempY = y;
                while (tempY < matrix.length - 1) {
                    if (matrix[tempY + 1][x] != 0) {
                        Double[][] original = copyArray(matrix);
                        double coefficient = matrix[tempY + 1][x] / matrix[y][x];
                        multiplyRow(matrix, coefficient, y);
                        deductRow(matrix, tempY + 1, y);
                        copyRow(original, matrix, x,y);
                    }
                    tempY++;
                }
            }

            x++;
            y++;
        }
        goToBack(matrix);
        normalize(matrix);
        System.out.println("Get it");
    }

    public void findSolve(Double[][] matrix) {
        for (int i = matrix.length - 1; i >= 0; i--) {

        }
    }

    public void normalize(Double[][] matrix) {
        for (int y = 0, x = 0; y < matrix.length; y++) {
            double coefficient = 1 / matrix[y][x];
            multiplyRow(matrix, coefficient, y);
            x++;
        }
    }

    public void goToBack(Double[][] matrix) {
        for (int y = matrix.length - 1, x = matrix[0].length - 2; y >= 1; y--) {
            Double[][] original = matrix.clone();
            int tempY = y;
            while (tempY >= 1) {
                if (tempY != 0) {
                    double coefficient = matrix[tempY - 1][x] / matrix[y][x];
                    multiplyRow(matrix, coefficient, y);
                    deductRow(matrix, tempY - 1, y);
                    copyRow(original, matrix, x,y);
                }
                tempY--;
            }
            x--;

        }
    }

    private void copyRow(Double[][] original, Double[][] matrix, int x, int y) {
        for (int i = x; i < matrix[0].length; i++) {
            matrix[y][i] = original[y][i];
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

    public static void printMatrix(Double[][] matrix) {
        for (Double[] row : matrix) {
            for (Double el : row) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }

    private Double[][] copyArray(Double[][] array) {
        Double[][] newArray = new Double[array.length][array[0].length];
        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array[0].length; x++) {
                newArray[y][x] = array[y][x];
            }
        }
        return newArray;
    }
}
