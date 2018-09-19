package PL.ConsolePL;

public class ConsolePL implements Runnable {
    private int rang;

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
                    {0.450, 0.030, -0.01, 0.020, 0.111, 2.491},
                    {0.020, 0.375, -0.01, 0.010, 0.000, 1.273},
                    {0.000, 0.700, 0.440, 0.000, 0.113, -0.738},
                    {-0.03, 0.015, -0.02, 0.41, -0.084, 0.429},
                    {0.020, 1.000, 0.000, 0.000, 0.290, -0.16},
            };


        }
    }


}
