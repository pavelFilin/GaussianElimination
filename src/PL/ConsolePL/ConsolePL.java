package PL.ConsolePL;

import BLL.GaussLogic;

import java.util.Scanner;

public class ConsolePL implements Runnable {
    private int rang;
    GaussLogic gaussLogic = new GaussLogic();

    Double[][] originalMatrix = new Double[][]{
        {0.450, 0.030, -0.01, 0.020, -0.111, 2.491},
        {0.020, 0.375, -0.01, 0.010, 0.000, 1.275},
        {0.000, 0.0700, 0.440, 0.000, 0.113, -0.738},
        {-0.03, 0.015, -0.02, 0.41, -0.084, 0.429},
        {0.020, 1.000, 0.000, 0.000, 0.290, -0.16},
    };

    @Override
    public void run() {
        while (true) {
            System.out.println("Gaussian elimination is an algorithm for solving systems of linear equations");
            System.out.println("Enter rang of system");
            //todo enter rang
            rang = 5;
            System.out.println("rang is 5");
            Double[][] matrix = new Double[rang + 1][rang];
            System.out.println("Enter matrix");
            //todo enter matrix
            matrix = new Double[][]{
                    {0.450, 0.030, -0.01, 0.020, -0.111, 2.491},
                    {0.020, 0.375, -0.01, 0.010, 0.000, 1.275},
                    {0.000, 0.0700, 0.440, 0.000, 0.113, -0.738},
                    {-0.03, 0.015, -0.02, 0.41, -0.084, 0.429},
                    {0.020, 1.000, 0.000, 0.000, 0.290, -0.16},
            };

//          matrix = new Double[][]{
//                  {0.450, 0.300, -0.01, 0.020, -0.111, -0.275},
//                  {0.020, 0.375, -0.01, 0.010, 0.000, -0.78},
//                  {0.000, 0.070, 0.440, 0.000, 0.113, 1.750},
//                  {-0.03, 0.015, -0.02, 0.41, -0.84, -2.18},
//                  {0.020, 1.000, 0.000, 0.000, 0.290, 1.450},
//          };
            gaussLogic.transformToTriangleMatrix(matrix);
            GaussLogic.printMatrix(matrix);
            double[] x = getX(matrix);
            double[] residual =getResidual(originalMatrix, x);

            for (int i = 0; i < x.length; i++) {
                System.out.println("x" + i + " " + x[i]);
            }
            System.out.println("невязка");
            double residualOne = 0;
            for (int i = 0; i < x.length; i++) {
                System.out.println("x" + i + " " + residual[i]);
                residualOne += Math.abs(residual[i]);
            }
            System.out.println("невязка = " + residualOne);


            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
        }

    }

    private double[] getX(Double[][] matrix) {
        double[] x = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            x[i] = matrix[i][matrix[0].length-1];
        }
        return x;
    }

    private double[] getResidual(Double[][] matrix, double[] x) {
        double[] residual = new double[x.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                residual[i] += matrix[i][j] * x[j];
            }
            residual[i] -= matrix[i][matrix[0].length-1];
        }

        return residual;
    }

}
