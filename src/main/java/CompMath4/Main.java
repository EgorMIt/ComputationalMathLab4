package CompMath4;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

    public static void main(String[] arg) {
        InputConsole inConsole = new InputConsole();
        InputFile inFile = new InputFile();

        double[][] points;
        double[][] dataSetChart = new double[5][3];

        inConsole.startProgram();

        if (inConsole.inputType()) {
            boolean outputType;
            try {
                FileReader fileReader = new FileReader("src/main/resources/input");
                points = inFile.getDataSet(fileReader);
                outputType = inFile.outputType();

                Computations.startCount(points, dataSetChart, outputType);
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден!");
            }
        } else {
            boolean outputType = inConsole.outputType();
            points = inConsole.inputPoints();
            Computations.startCount(points, dataSetChart, outputType);
        }
    }
}