package CompMath4.InputOutput;

import java.io.FileReader;
import java.util.Scanner;

public class InputFile {

    boolean outputType;

    public double[][] getDataSet(FileReader fileReader) {
        Scanner scanner = new Scanner(fileReader);
        int lineNumber = 0;
        double[][] points = new double[2][0];
        int n = 0;

        while (scanner.hasNextLine()) {
            switch (lineNumber) {
                case (0) -> {
                    try {
                        n = scanner.nextInt();
                        points = new double[2][n];
                        lineNumber++;
                    } catch (NumberFormatException exception) {
                        System.out.println("Ошибка при получении количества точек!");
                    }
                }
                case (1) -> {
                    for (int i = 0; i < n; i++) {
                        try {
                            points[0][i] = scanner.nextDouble();
                        } catch (NumberFormatException exception) {
                            System.out.println("Ошибка при чтении координат X!");
                            break;
                        }
                    }
                    lineNumber++;
                }
                case (2) -> {
                    for (int i = 0; i < n; i++) {
                        try {
                            points[1][i] = scanner.nextDouble();
                        } catch (NumberFormatException exception) {
                            System.out.println("Ошибка при чтении координат Y!");
                            break;
                        }
                    }
                    lineNumber++;
                }
                case (3) -> {
                    String str = scanner.nextLine();
                    outputType = str.equals("true");
                }
                case (4) -> {
                    return points;
                }
            }
        }
        return points;
    }

    public boolean getOutputType() {
        return outputType;
    }
}