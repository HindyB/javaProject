import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner myInput = new Scanner(System.in); // Setting up a SCANNER
        ArrayList<Double> convertHistory = new ArrayList<Double>();
        boolean flag = true;
        int choice;
        String answer;
        boolean answerFlag = true;

        System.out.println("Welcome to currency converter");
        // The program will run as long as the user wants to continue
        while (flag) {
            do {
                System.out.println("Please choose an option (Enter 1 or 2):\n" +
                        "1. Dollars to Shekels\n" +
                        "2. Shekels to Dollars");

                try { //Only digits 1 or 2 can be entered
                    choice = myInput.nextInt();
                    // 1/2 validation
                    if (choice != 1 && choice != 2) {
                        throw new IOException("Invalid input");
                    }
                } catch (NumberFormatException e) { //Only INT entries can be entered
                    System.err.println("Enter only number");
                    choice = 0;

                }

            } while (choice != 1 && choice != 2);
            do {
                    System.out.println("Please enter an amount to convert:");
                    input = myInput.nextDouble();

                    if (choice == 1) { // in case user enters value 1 - Convert Dollar to Shekel
                        Coin usdValue = CoinsFactory.getCoinInstance(Coins.USD);
                        double value = usdValue.calculate(input);
                        System.out.println("Currency is: " + value + " Shekels");
                        convertHistory.add(value);

                    } else if (choice == 2) { // in case user enters value 2
                        Coin ilsValue = CoinsFactory.getCoinInstance(Coins.ILS);
                        double value = ilsValue.calculate(input);
                        System.out.println("Currency is: " + value + " Dollars");
                        convertHistory.add(value);

                    } else { // in case user enters a different value than 1/2
                        throw new IOException("Invalid input");
                    }
                } while (answerFlag == true) {//Check if the user entered only Y or N values
                System.out.println("Would you like to continue converting more values?\nWrite Y or N");
                answer = myInput.next();
                if (answer.equalsIgnoreCase("Y")) {//In case the user entered Y
                    flag = true;
                    break;
                } else if (answer.equalsIgnoreCase("N")) {//In case the user entered N
                    flag = false;
                    answerFlag = false;
                    System.out.println("Thanks for using our currency converter");

                    for (int i = 0; i < convertHistory.size(); i++) {//Array printing
                        System.out.println(convertHistory.get(i));
                    }

                    //Create a file with a file name that contains the time and date
                    Date date = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
                    FileWriter conversionHistoryFile = new FileWriter(dateFormat.format(date) + ".txt");
                    for (int i = 0; i < convertHistory.size(); i++) {//Print the array into the created file
                        conversionHistoryFile.write(convertHistory.get(i) + "\n");
                    }
                    conversionHistoryFile.close();

                } else {//In case the user entered a value other than Y or N
                    System.err.println("You can enter only Y or N");
                    flag = true;
                    }
                }
            }
        }
    }
}