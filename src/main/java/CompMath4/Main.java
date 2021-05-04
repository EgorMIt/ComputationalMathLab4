package CompMath4;

import CompMath4.Computations.Methods;
import CompMath4.InputOutput.InputConsole;
import CompMath4.InputOutput.InputFile;

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
                outputType = inFile.getOutputType();

                Methods.startCount(points, dataSetChart, outputType);
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден!");
            }
        } else {
            boolean outputType = inConsole.outputType();
            points = inConsole.inputPoints();
            Methods.startCount(points, dataSetChart, outputType);
        }
    }
}