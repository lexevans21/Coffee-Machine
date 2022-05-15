import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        System.out.println(checkTriples(getUserInput()));
    }

    public static int[] getUserInput() {
        Scanner scanner = new Scanner(System.in);
        int[] input = new int[scanner.nextInt()];

        for (int i=0; i< input.length; i++) {
            input[i] = scanner.nextInt();
        }

        return input;

    }

    public static int checkTriples(int[] input){

        int count = 0;

        for (int i=0; i<input.length-2; i++) {
            if (input[i+1] == input[i] + 1 && input[i+2] == input[i] + 2){
                count++;
            }
        }

        return count;
    }
}