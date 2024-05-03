import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class random {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long input;
        long counter = 0;
        Random random = new Random();
        int randomnumber = random.nextInt();
        System.out.println(randomnumber);
        ArrayList<Long> userAttempts = new ArrayList<>();
        do {
            System.out.println("enter number : ");
            input = scanner.nextLong();
            userAttempts.add(input);
            counter++;
        } while (input != randomnumber);
        if (input == randomnumber) {
            System.out.println("Congratulations");
        } else if (input < randomnumber) {
            System.out.println("enter a bigger number");
        } else {
            System.out.println("enter a smaller number");
        }
        System.out.println("enter your user name: ");
        Scanner scanner1 = new Scanner(System.in);
        String username = scanner1.next();
        try {
            FileWriter fileWriter = new FileWriter("report.txt");
            fileWriter.write("The user name is: " + username + "\n");
            fileWriter.write("The number of attempts = " + counter + "\n");
            double mean = calculateMean(userAttempts);
            double sd = calculateStandardDeviation(userAttempts, mean);
            fileWriter.write("Standard deviation = " + sd + "\n");
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static double calculateMean(ArrayList<Long> userAttempts) {
        long sum = 0;
        for (long num : userAttempts) {
            sum += num;
        }
        return (double) sum / userAttempts.size();
    }
    private static double calculateStandardDeviation(ArrayList<Long> userAttempts, double mean) {
        double sumOfSquaredDifferences = 0;
        for (long num : userAttempts) {
            sumOfSquaredDifferences += Math.pow(num - mean, 2);
        }
        return Math.sqrt(sumOfSquaredDifferences / userAttempts.size());
    }
}
