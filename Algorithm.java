public class Algorithm {
    private int[] array;
    private double[][] result;

    public Algorithm(int[] array) {
        this.array = array;
        result = new double[array.length][array.length];
    }

    public void run() {
        for (int k = 0; k < array.length; k++) {
            result[k][k] = array[k];
            for (int i = k - 1; i >= 0; i--) {
                result[i][k] = (result[i+1][k] + array[i]) / 2;
            }
            for (int j = k + 1; j < array.length; j++) {
                result[j][k] += result[k][j] / array.length;
            }
        }
    }
}
