package CompMath4;

public class OutputConsole {
    Functions functions = new Functions();

    public void print_table_all(double[][] points, double a, double b, double c, int functionNumber) {
        double sym_for_x = 0;
        double sym_for_y = 0;

        switch (functionNumber) {
            case (1) -> System.out.println("Линайная функция");
            case (2) -> System.out.println("Полиномиальная функция 2-й степени");
            case (3) -> System.out.println("Экспоненциальная функция");
            case (4) -> System.out.println("Логорифмическая функция");
            default -> System.out.println("Степенная функция");
        }

        System.out.printf("|%-14s", "№");
        for (int i = 1; i <= points[0].length; i++) {
            System.out.printf("|%-12d", i);
        }
        System.out.println("|");

        System.out.printf("|%-14s", "X");
        for (int i = 0; i < points[0].length; i++) {
            sym_for_x += points[0][i];
            System.out.printf("|%-12f", points[0][i]);
        }
        System.out.println("|");

        System.out.printf("|%-14s", "Y");
        for (int i = 0; i < points[0].length; i++) {
            sym_for_y += points[1][i];
            System.out.printf("|%-12f", points[1][i]);
        }
        System.out.println("|");

        double x_ = sym_for_x / points[0].length;
        double y_ = sym_for_y / points[0].length;
        double sum_up_r = 0, sum_down_r_x = 0, sum_down_r_y = 0;

        switch (functionNumber) {
            case (1) -> System.out.printf("|%-14s", "Fi=ax+b");
            case (2) -> System.out.printf("|%-14s", "Fi=ax^b");
            case (3) -> System.out.printf("|%-14s", "Fi=ae^bx");
            case (4) -> System.out.printf("|%-14s", "Fi=a*ln(x)+b");
            default -> System.out.printf("|%-14s", "Fi=ax^2+bx^2+c");
        }

        for (int i = 0; i < points[0].length; i++) {
            sum_up_r += (points[0][i] - x_) * (points[1][i] - y_);
            sum_down_r_x += Math.pow(points[0][i] - x_, 2);
            sum_down_r_y += Math.pow(points[1][i] - y_, 2);

            System.out.printf("|%-12f", functions.f(points[0][i], a, b, c, functionNumber));
        }
        System.out.println("|");


        System.out.printf("|%-14s", "Eps");
        for (int i = 0; i < points[0].length; i++) {
            System.out.printf("|%-12f", functions.f(points[0][i], a, b, c, functionNumber) - points[1][i]);
        }
        System.out.println("|");

        System.out.println("A = " + a);
        System.out.println("B = " + b);

        double sum_for_S = functions.deviationMeasure(points, a, b, c, functionNumber);

        System.out.println("Мера отклонения = " + sum_for_S);

        if (functionNumber == 1) {
            double r = sum_up_r / Math.sqrt(sum_down_r_x * sum_down_r_y);
            System.out.println("Коэффициент корреляции = " + r);
            r = Math.abs(r);
            if (r == 0)
                System.out.println("Связь между переменными отсутствует");
            else if (r > 0 && r < 0.3)
                System.out.println("Связь слабая");
            else if (r >= 0.3 && r < 0.5)
                System.out.println("Связь умеренная");
            else if (r >= 0.5 && r < 0.7)
                System.out.println("Связь заметная");
            else if (r >= 0.7 && r < 0.9)
                System.out.println("Связь высокая");
            else if (r >= 0.9)
                System.out.println("Связь очень высокая");
        }

        System.out.println("Среднеквадратичное отклонение = " + functions.squareDeviation(points, a, b, c, functionNumber));
        System.out.println("Достоверность аппроксимации = " + functions.getR(points, a, b, c, functionNumber));
        System.out.println("-------------------------------------------------------------------------\n");
    }

    public void print_table_short(double[][] points, double a, double b, double c, int functionNumber) {
        if (functionNumber == 1) {
            System.out.printf("|%-18s|%-15s|%-15s|%-15s|%-17s|%-32s|%-32s|\n",
                    "Вид функции", "a", "b", "c", "Мера отклонения S", "Среднеквадратичное отклонение q",
                    "Достоверность аппроксимации");
        }

        switch (functionNumber) {
            case (1) -> System.out.printf("|%-18s|%-15f|%-15f|%-15s|%-17f|%-32f|%-32s|\n",
                    "Fi = ax+b", a, b, "-", functions.deviationMeasure(points, a, b, 0, functionNumber),
                    functions.squareDeviation(points, a, b, 0, functionNumber), functions.getR(points, a, b, 0, functionNumber));
            case (2) -> System.out.printf("|%-18s|%-15f|%-15f|%-15s|%-17f|%-32f|%-32s|\n",
                    "Fi = ax^b", a, b, "-", functions.deviationMeasure(points, a, b, 0, functionNumber),
                    functions.squareDeviation(points, a, b, 0, functionNumber), functions.getR(points, a, b, 0, functionNumber));
            case (3) -> System.out.printf("|%-18s|%-15f|%-15f|%-15s|%-17f|%-32f|%-32s|\n",
                    "Fi = ae^bx", a, b, "-", functions.deviationMeasure(points, a, b, 0, functionNumber),
                    functions.squareDeviation(points, a, b, 0, functionNumber), functions.getR(points, a, b, 0, functionNumber));
            case (4) -> System.out.printf("|%-18s|%-15f|%-15f|%-15s|%-17f|%-32f|%-32s|\n",
                    "Fi = a*ln(x)+b", a, b, "-", functions.deviationMeasure(points, a, b, 0, functionNumber),
                    functions.squareDeviation(points, a, b, 0, functionNumber), functions.getR(points, a, b, 0, functionNumber));
            default -> System.out.printf("|%-18s|%-15f|%-15f|%-15f|%-17f|%-32f|%-32s|\n",
                    "Fi = ax^2+bx^2+c", a, b, c, functions.deviationMeasure(points, a, b, c, functionNumber),
                    functions.squareDeviation(points, a, b, c, functionNumber), functions.getR(points, a, b, c, functionNumber));
        }
    }

    public void drawCharts(double[][] points, double[][] dataSetChart) {
        DrawChart draw = new DrawChart();
        draw.draw(points, dataSetChart);
    }
}