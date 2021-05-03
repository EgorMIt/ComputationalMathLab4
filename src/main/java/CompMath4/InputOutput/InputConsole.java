package CompMath4.InputOutput;

import java.util.Scanner;

public class InputConsole {
    Scanner inConsole = new Scanner(System.in);

    public double[][] inputPoints() {
        int n = inputN();
        double[][] points = new double[2][n];

        for (int i = 0; i < n; i++) {
            points[0][i] = inPointX(i);
            points[1][i] = inPointY(i);
        }
        return points;
    }

    public boolean inputType() {
        while (true) {
            System.out.print("Введите: 1 - для чтения файла; 2 - для ввода с консоли\n");
            int num = inConsole.nextInt();

            switch (num) {
                case (1) -> {
                    return true;
                }
                case (2) -> {
                    return false;
                }
                default -> {
                    System.out.println("Недопустимое значение!");
                    return inputType();
                }
            }
        }
    }

    public boolean outputType() {
        while (true) {
            System.out.print("Введите: 1 - для вывода каждой функции; 2 - для одной\n");
            int num = inConsole.nextInt();

            switch (num) {
                case (1) -> {
                    return true;
                }
                case (2) -> {
                    return false;
                }
                default -> {
                    System.out.println("Недопустимое значение!");
                    return outputType();
                }
            }
        }
    }

    public void startProgram() {
        System.out.println(">>> Программа начала свою работу <<<");
        System.out.println("""
                Формат входного файла:
                1. Количество точек: N >= 12
                2. Координаты X
                3. Координаты Y
                4. Вывод всех/одной функции: true/false
                """);
    }

    private int inputN() {
        while (true) {
            System.out.print("Введите колиичество точек: ");
            int n = Integer.parseInt(inConsole.next().trim());

            if (n >= 12)
                return n;
            else
                System.out.println("N должно быть >= 12!");
        }
    }

    private double inPointX(int pointNumber) {
        while (true) {
            System.out.print("Для точки " + (pointNumber + 1) + " введите координату X: ");
            try {
                return Double.parseDouble(inConsole.next().trim().replaceAll(",", "\\."));
            } catch (NumberFormatException exception) {
                System.out.println("Ошибка при вводе X!");
            }
        }
    }

    private double inPointY(int pointNumber) {
        while (true) {
            System.out.print("Для точки " + (pointNumber + 1) + " введите координату Y: ");
            try {
                return Double.parseDouble(inConsole.next().trim().replaceAll(",", "\\."));
            } catch (NumberFormatException ignored) {
                System.out.println("Ошибка при вводе Y!");
            }
        }
    }
}
