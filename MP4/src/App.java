//import java.io.*;
import java.util.Random;
import java.util.Scanner;


public class App extends computerGuess{
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        int attempts = 0;
        Random rand = new Random();   
        int code = rand.nextInt(10000);
        System.out.printf("Secret code generate: %04d%n", code);
        int[] cArr = intToArray(code); 
        
        do{
            if (attempts % 2 == 0){
                do{
                    System.out.print("you guess: ");
                    int guess = scan.nextInt();
                    int[] gArr = intToArray(guess); 
                    if(bullCounter(cArr, gArr) == 4){
                        System.out.printf("\nResult: %d bull and %d cows", bullCounter(cArr, gArr), (cowCounter(cArr, gArr)-bullCounter(cArr, gArr)));
                        System.out.println("\nyou won!\n- - -"); 
                        break;
                    }  
                    else{
                        System.out.printf("Result: %d bull and %d cows", bullCounter(cArr, gArr), (cowCounter(cArr, gArr)-bullCounter(cArr, gArr)));    
                        System.out.print("\n- - -\n"); 
                        attempts++;
                        break;
                    } 
                } while(attempts <= 4); //check
            }
            if(attempts % 2 == 1){
                do{
                    System.out.print("computer guess: ");
                    printGuess();
                    int[] comArr = comGuess();
                    if(bullCounter(cArr, comArr) == 4){
                        System.out.printf("\nResult: %d bull and %d cows", bullCounter(cArr, comArr), (cowCounter(cArr, comArr)-bullCounter(cArr, comArr)));
                        System.out.println("\ncomputer won!\n- - -"); 
                        break;
                    }  
                    else{
                        System.out.printf("\nResult: %d bull and %d cows", bullCounter(cArr, comArr), (cowCounter(cArr, comArr)-bullCounter(cArr, comArr)));    
                        System.out.print("\n- - -\n"); 
                        attempts++;
                        break;
                    } 
                } while(attempts <= 4);
            }
        } while(attempts <= 8);
    }
     
    public static int[] intToArray(int num) {
        int length = String.valueOf(num).length();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = num % 10;
            num /= 10;
        }
        return arr;
    }

    public static int bullCounter(int[] arr1, int[] arr2) {
        int bullCtr = 0;
        int length = Math.min(arr1.length, arr2.length);
        for (int i = 0; i < length; i++) {
            if (arr1[i] == arr2[i]) {
                bullCtr++;
            }
        }
        return bullCtr;
    }

    public static int cowCounter(int[] arr1, int[] arr2) {
        int cowCtr = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    cowCtr++;
                }
            }
        }
        return cowCtr;
    }
}