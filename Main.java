import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("src/in3K.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String firstLine = bufferedReader.readLine();
        int n = Integer.parseInt(firstLine);
        int[][] table = new int[n][n];
        String line;
        for (int i = 0; i < n; i++) {
            line = bufferedReader.readLine();
            String[] elements = line.split(",");
            for (int j = 0; j < n; j++) {
                table[i][j] = Integer.parseInt(elements[j]);
            }
        }
        int mm = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.close();

        long startTime = System.nanoTime();

        int maxDarkPixels = findMaxDarkPixels(n, table, mm);
        System.out.println(maxDarkPixels);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        double durationInSeconds = duration / 1e9;
        System.out.println("Czas wykonania algorytmu: " + durationInSeconds + " sekundy");
    }

    public static int findMaxDarkPixels(int n, int[][] table, int range) {
        int maxDarkPixels = 0;

        for (int i = 0; i <= n - range; i++) {
            for (int j = 0; j <= n - range; j++) {
                int darkPixelsInSubmatrix = 0;
                for (int x = i; x < i + range; x++) {
                    for (int y = j; y < j + range; y++) {
                        darkPixelsInSubmatrix += table[x][y];
                    }
                }
                if (darkPixelsInSubmatrix > maxDarkPixels) {
                    maxDarkPixels = darkPixelsInSubmatrix;
                }
            }
        }

        return maxDarkPixels;
    }
}
