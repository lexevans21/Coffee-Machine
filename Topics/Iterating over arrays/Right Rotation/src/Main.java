import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] ourString = scanner.nextLine().split(" ");
        int rotations = scanner.nextInt();

        for(int i=0; i<rotations% ourString.length; i++) {
            rotate(ourString);
        }

        for (String i : ourString){
            System.out.print(i + " ");
        }
    }

    public static void rotate(String[] input) {
        String temp = input[input.length-1];
        for (int i= input.length-1; i>0; i--) {
            input[i] = input[i-1];
        }
        input[0] = temp;

    }
}