package CompMath4.Computations;

import CompMath4.InputOutput.OutputConsole;

public class Methods {
    public static void startCount(double[][] points, double[][] dataSetChart, boolean outputType) {
        OutputConsole outputConsole = new OutputConsole();
        GaussMethod gaussMethod = new GaussMethod();
        Functions functions = new Functions();

        double sum_x_1 = sum_x_1(points), sum_x_2 = sum_x_2(points), sum_x_y = sum_x_y(points), sum_y_1 = sum_y_1(points);
        double sum_x_ln = sum_x_ln(points), sum_x_2_ln = sum_x_2_ln(points), sum_x_y_ln = sum_x_y_ln(points);
        double sum_y_ln = sum_y_ln(points), sum_y_ln_x = sum_y_ln_x(points), sum_x_ln_y = sum_x_ln_y(points);
        double sum_x_3 = sum_x_3(points), sum_x_4 = sum_x_4(points), sum_x_2_y = sum_x_2_y(points);

        double[][] matrix = new double[][]{{points[0].length, sum_x_1, sum_x_2, sum_y_1},
                {sum_x_1, sum_x_2, sum_x_3, sum_x_y},
                {sum_x_2, sum_x_3, sum_x_4, sum_x_2_y}};

        int nMatrix = 3;

        double[] paramsSqrF = gaussMethod.startMethod(matrix, nMatrix);

        if (outputType) {
            //Первая функция
            System.out.println("Sum X = " + sum_x_1 + " Sum XX = " +
                    sum_x_2 + " Sum Y = " + sum_y_1 + " Sum XY = " + sum_x_y);

            dataSetChart[0][0] = functions.getA(sum_x_1, sum_x_2, sum_y_1, sum_x_y, sum_x_ln, sum_y_ln, sum_x_2_ln,
                    sum_x_y_ln, sum_y_ln_x, sum_x_ln_y, points[0].length, 1);
            dataSetChart[0][1] = functions.getB(sum_x_1, sum_x_2, sum_y_1, sum_x_y, sum_x_ln, sum_y_ln, sum_x_2_ln,
                    sum_x_y_ln, sum_y_ln_x, sum_x_ln_y, points[0].length, 1);

            outputConsole.printTableAll(points, dataSetChart[0][0], dataSetChart[0][1], 0, 1);

            //Вторая функция
            if (functions.checkMinus(points)) {
                System.out.println("Sum ln(x) = " + sum_x_ln + " Sum ln(y) = " + sum_y_ln +
                        " Sum (ln(x))^2 = " + sum_x_2_ln + " Sum ln(x)*ln(y) = " + sum_x_y_ln);

                dataSetChart[1][0] = functions.getA(sum_x_1, sum_x_2, sum_y_1, sum_x_y, sum_x_ln, sum_y_ln, sum_x_2_ln,
                        sum_x_y_ln, sum_y_ln_x, sum_x_ln_y, points[0].length, 2);
                dataSetChart[1][1] = functions.getB(sum_x_1, sum_x_2, sum_y_1, sum_x_y, sum_x_ln, sum_y_ln, sum_x_2_ln,
                        sum_x_y_ln, sum_y_ln_x, sum_x_ln_y, points[0].length, 2);
                outputConsole.printTableAll(points, dataSetChart[1][0], dataSetChart[1][1], 0, 2);
            }

            //Третья функция
            if (functions.checkMinus(points)) {
                System.out.println("Sum x = " + sum_x_1 + " Sum ln(y) = " + sum_y_ln +
                        " Sum x^2 = " + sum_x_2 + " Sum ln(y)*x = " + sum_y_ln_x);
                dataSetChart[2][0] = functions.getA(sum_x_1, sum_x_2, sum_y_1, sum_x_y, sum_x_ln, sum_y_ln, sum_x_2_ln,
                        sum_x_y_ln, sum_y_ln_x, sum_x_ln_y, points[0].length, 3);
                dataSetChart[2][1] = functions.getB(sum_x_1, sum_x_2, sum_y_1, sum_x_y, sum_x_ln, sum_y_ln, sum_x_2_ln,
                        sum_x_y_ln, sum_y_ln_x, sum_x_ln_y, points[0].length, 3);

                outputConsole.printTableAll(points, dataSetChart[2][0], dataSetChart[2][1], 0, 3);
            }

            //Четвертая
            if (functions.checkMinus(points)) {
                System.out.println("Sum ln(x) = " + sum_x_ln + " Sum y = " + sum_y_1 +
                        " Sum (ln(x))^2 = " + sum_x_2_ln + " Sum ln(x)*y = " + sum_x_ln_y);
                dataSetChart[3][0] = functions.getA(sum_x_1, sum_x_2, sum_y_1, sum_x_y, sum_x_ln, sum_y_ln, sum_x_2_ln,
                        sum_x_y_ln, sum_y_ln_x, sum_x_ln_y, points[0].length, 4);
                dataSetChart[3][1] = functions.getB(sum_x_1, sum_x_2, sum_y_1, sum_x_y, sum_x_ln, sum_y_ln, sum_x_2_ln,
                        sum_x_y_ln, sum_y_ln_x, sum_x_ln_y, points[0].length, 4);

                outputConsole.printTableAll(points, dataSetChart[3][0], dataSetChart[3][1], 0, 4);
            }

            //Пятая функция
            System.out.println("Sum x = " + sum_x_1 + " Sum y = " + sum_y_1 +
                    " Sum x*y = " + sum_x_y + " Sum y*x^2= " + sum_x_2_y +
                    " Sum x^2 = " + sum_x_2 + " Sum x^3 = " + sum_x_3 + " Sum x^4 = " + sum_x_4);
            dataSetChart[4][0] = paramsSqrF[2];
            dataSetChart[4][1] = paramsSqrF[1];
            dataSetChart[4][2] = paramsSqrF[0];
            outputConsole.printTableAll(points, paramsSqrF[2], paramsSqrF[1], paramsSqrF[0], 5);

        } else {
            dataSetChart[0][0] = functions.getA(sum_x_1, sum_x_2, sum_y_1, sum_x_y, sum_x_ln, sum_y_ln, sum_x_2_ln,
                    sum_x_y_ln, sum_y_ln_x, sum_x_ln_y, points[0].length, 1);
            dataSetChart[0][1] = functions.getB(sum_x_1, sum_x_2, sum_y_1, sum_x_y, sum_x_ln, sum_y_ln, sum_x_2_ln,
                    sum_x_y_ln, sum_y_ln_x, sum_x_ln_y, points[0].length, 1);

            outputConsole.printTableShort(points, dataSetChart[0][0], dataSetChart[0][1], 0, 1);

            if (functions.checkMinus(points)) {
                dataSetChart[1][0] = functions.getA(sum_x_1, sum_x_2, sum_y_1, sum_x_y, sum_x_ln, sum_y_ln, sum_x_2_ln,
                        sum_x_y_ln, sum_y_ln_x, sum_x_ln_y, points[0].length, 2);
                dataSetChart[1][1] = functions.getB(sum_x_1, sum_x_2, sum_y_1, sum_x_y, sum_x_ln, sum_y_ln, sum_x_2_ln,
                        sum_x_y_ln, sum_y_ln_x, sum_x_ln_y, points[0].length, 2);

                outputConsole.printTableShort(points, dataSetChart[1][0], dataSetChart[1][1], 0, 2);
            }

            if (functions.checkMinus(points)) {
                dataSetChart[2][0] = functions.getA(sum_x_1, sum_x_2, sum_y_1, sum_x_y, sum_x_ln, sum_y_ln, sum_x_2_ln,
                        sum_x_y_ln, sum_y_ln_x, sum_x_ln_y, points[0].length, 3);
                dataSetChart[2][1] = functions.getB(sum_x_1, sum_x_2, sum_y_1, sum_x_y, sum_x_ln, sum_y_ln, sum_x_2_ln,
                        sum_x_y_ln, sum_y_ln_x, sum_x_ln_y, points[0].length, 3);

                outputConsole.printTableShort(points, dataSetChart[2][0], dataSetChart[2][1], 0, 3);
            }

            if (functions.checkMinus(points)) {
                dataSetChart[3][0] = functions.getA(sum_x_1, sum_x_2, sum_y_1, sum_x_y, sum_x_ln, sum_y_ln, sum_x_2_ln,
                        sum_x_y_ln, sum_y_ln_x, sum_x_ln_y, points[0].length, 4);
                dataSetChart[3][1] = functions.getB(sum_x_1, sum_x_2, sum_y_1, sum_x_y, sum_x_ln, sum_y_ln, sum_x_2_ln,
                        sum_x_y_ln, sum_y_ln_x, sum_x_ln_y, points[0].length, 4);

                outputConsole.printTableShort(points, dataSetChart[3][0], dataSetChart[3][1], 0, 4);
            }

            dataSetChart[4][0] = paramsSqrF[2];
            dataSetChart[4][1] = paramsSqrF[1];
            dataSetChart[4][2] = paramsSqrF[0];
            outputConsole.printTableShort(points, paramsSqrF[2], paramsSqrF[1], paramsSqrF[0], 5);
        }
        functions.selectedFunction(points, dataSetChart);
        outputConsole.drawCharts(points, dataSetChart);
    }

    private static double sum_x_1(double[][] points) {
        double sum = 0;
        for (int i = 0; i < points[0].length; i++) {
            sum += points[0][i];
        }
        return sum;
    }

    private static double sum_x_2(double[][] points) {
        double sum = 0;
        for (int i = 0; i < points[0].length; i++) {
            sum += Math.pow(points[0][i], 2);
        }
        return sum;
    }

    private static double sum_x_3(double[][] points) {
        double sum = 0;
        for (int i = 0; i < points[0].length; i++) {
            sum += Math.pow(points[0][i], 3);
        }
        return sum;
    }

    private static double sum_x_4(double[][] points) {
        double sum = 0;
        for (int i = 0; i < points[0].length; i++) {
            sum += Math.pow(points[0][i], 4);
        }
        return sum;
    }

    private static double sum_x_y(double[][] points) {
        double sum = 0;
        for (int i = 0; i < points[0].length; i++) {
            sum += points[0][i] * points[1][i];
        }
        return sum;
    }

    private static double sum_x_2_y(double[][] points) {
        double sum = 0;
        for (int i = 0; i < points[0].length; i++) {
            sum += Math.pow(points[0][i], 2) * points[1][i];
        }
        return sum;
    }


    private static double sum_y_1(double[][] points) {
        double sum = 0;
        for (int i = 0; i < points[0].length; i++) {
            sum += points[1][i];
        }
        return sum;
    }

    private static double sum_x_ln(double[][] points) {
        double sum = 0;
        for (int i = 0; i < points[0].length; i++) {
            if (points[0][i] != 0)
                sum += Math.log(points[0][i]);
        }
        return sum;
    }

    private static double sum_x_2_ln(double[][] points) {
        double sum = 0;
        for (int i = 0; i < points[0].length; i++) {
            if (points[0][i] != 0)
                sum += Math.pow(Math.log(points[0][i]), 2);
        }
        return sum;
    }

    private static double sum_x_y_ln(double[][] points) {
        double sum = 0;
        for (int i = 0; i < points[0].length; i++) {
            if (points[0][i] != 0 && points[1][i] != 0)
                sum += Math.log(points[0][i]) * Math.log(points[1][i]);
        }
        return sum;
    }

    private static double sum_y_ln(double[][] points) {
        double sum = 0;
        for (int i = 0; i < points[0].length; i++) {
            if (points[1][i] != 0)
                sum += Math.log(points[1][i]);
        }
        return sum;
    }

    private static double sum_y_ln_x(double[][] points) {
        double sum = 0;
        for (int i = 0; i < points[0].length; i++) {
            if (points[1][i] != 0)
                sum += Math.log(points[1][i]) * points[0][i];
        }
        return sum;
    }

    private static double sum_x_ln_y(double[][] points) {
        double sum = 0;
        for (int i = 0; i < points[0].length; i++) {
            if (points[0][i] != 0)
                sum += Math.log(points[0][i]) * points[1][i];
        }
        return sum;
    }
}