import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PerformanceTest {
    private static DecimalFormat formatter = new DecimalFormat("0.000");

    public static void main(String[] args) {
        testPerformance();
    }

    public static void testPerformance() {
        System.out.println("Размер\tВремя (ms)\tИтерации");
        int[][] array = getData();
        long startTime, endTime;
        int iterations;
        for (int i = 0; i < array.length - 1; i++) {
            int[] data = array[i];
            int arraySize = data.length;
            startTime = System.nanoTime();
            Algorithm chanAlgorithm = new Algorithm(data);
            chanAlgorithm.run();
            endTime = System.nanoTime() - startTime;
            iterations = (int) ((int) ((double) arraySize * arraySize) / 2.0);
            System.out.printf("%d\t%s\t%d%n",
                    arraySize,
                    formatter.format(TimeUnit.NANOSECONDS.toMillis(endTime) / 1000d),
                    iterations);
        }
    }

    private static int[][] getData() {
        List<String> dataLines;
        try {
            dataLines = Files.readAllLines(Paths.get("data.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int[][] array = new int[101][];
        for (int i = 0; i < dataLines.size(); i++) {
            String dataLine = dataLines.get(i);
            String[] dataStringArray = dataLine.split(",");
            int[] dataArray = new int[dataStringArray.length];
            for (int j = 0; j < dataStringArray.length; j++) {
                dataArray[j] = Integer.parseInt(dataStringArray[j]);
            }
            array[i] = dataArray;
        }
        return array;
    }
}

