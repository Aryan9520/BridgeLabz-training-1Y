public class RandomValues {

    public static int[] generate4DigitRandomArray(int size) {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = (int)(Math.random() * 9000) + 1000; // Generates 4-digit number (1000–9999)
        }

        return arr;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        double sum = 0;
        int min = numbers[0];
        int max = numbers[0];

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            min = Math.min(min, numbers[i]);
            max = Math.max(max, numbers[i]);
        }

        double average = sum / numbers.length;

        return new double[]{average, min, max};
    }

    public static void main(String[] args) {
        int size = 5;

        int[] randomNumbers = generate4DigitRandomArray(size);

        System.out.println("Generated 4-digit Random Numbers:");
        for (int i = 0; i < randomNumbers.length; i++) {
            System.out.print(randomNumbers[i] + " ");
        }

        double[] result = findAverageMinMax(randomNumbers);

        System.out.println("\nAverage = " + result[0]);
        System.out.println("Minimum = " + (int)result[1]);
        System.out.println("Maximum = " + (int)result[2]);
    }
}
