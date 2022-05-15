import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputArray = new int[scanner.nextInt()];

        int counter = 0;
        while (scanner.hasNext()){
            inputArray[counter] = scanner.nextInt();
            counter++;
        }

        int max = 0;
        for (int i=0; i< inputArray.length-1; i++) {
            max = Math.max(max, inputArray[i] * inputArray[i+1]);
        }

        System.out.println(max);

    }
}