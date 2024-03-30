import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateData {
    public static void main(String[] args) {
        int n = 0;
        for (int i = 0; i < 100; i++) {
            n += 100;
            int[] data = generateData(n);
            try (FileWriter writer = new FileWriter("data.txt", true)) {
                for (int d : data) {
                    writer.write(d + ",");
                }
                writer.write("\n");
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    private static int[] generateData(int n) {
        Random random = new Random();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = random.nextInt();
        }
        return data;
    }
}
