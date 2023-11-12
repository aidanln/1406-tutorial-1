/*
 * tutorial 1, problem 2, calculates tax + other factors
 * by Aidan Lalonde-Novales
 */

// import package for scanner
import java.util.Scanner;
public class TaxProgram {
    public static void main(String[] args) {
        // initialize variables
        double income, fedTax, provTax;
        int dependants;

        // listen for input using scanner
        Scanner input = new Scanner(System.in);

        // get taxable income, store under 'income' variable
        System.out.println("Enter your taxable income: ");
        income = input.nextDouble();
        System.out.println("");

        // get number of dependants, store under 'dependants' variable
        System.out.println("Enter the number of dependants: ");
        dependants = input.nextInt();
        System.out.println("");

        // initialize tax variables
        fedTax = 0.0;
        provTax = 0.0;

        // determine federal tax, based on income
        if (income <= 29590) {
            fedTax = 0.17 * income;
        } else if (income <= 59179.99) {
            fedTax = (0.17 * 29590) + (0.26 * (income - 29590));
        } else {
            fedTax = (0.17 * 29590) + (0.26 * (29590)) + (0.29 * (income - 59180));
        }

        // determine provincial tax, based on dependants
        provTax = (fedTax * 0.425) - (160.5 + (328 * dependants));
        if (provTax < 0.0) {
            provTax = 0.0;
        }

        // determine total tax
        double totalTax = fedTax + provTax;

        // print values for the user (and so i can see if this is working right)
        System.out.println("Here is your tax breakdown: \n");
        System.out.println(String.format("%-16s%10.2f", "Income", income));
        System.out.println(String.format("%-16s%10d", "Dependants ", dependants));
        System.out.println("--------------------------");
        System.out.println(String.format("%-16s%10.2f", "Federal Tax", fedTax));
        System.out.println(String.format("%-16s%10.2f", "Provincial Tax", provTax));
        System.out.println("==========================");
        System.out.println(String.format("%-16s%10.2f", "Total Tax", totalTax));
    }
}