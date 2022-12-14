package IPEMResultChecker;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ChooseTaskResults  {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

//        System.out.println("Group number (1-6):");
//        int groupNumber = scanner.nextInt();
//        System.out.println("Row number (1 or 2):");
//        int rowNumber = scanner.nextInt();
//
//        System.out.println("Gr" + groupNumber + " row " + rowNumber);

        //Task 1 result here
        Task1Group1Row1 bep = new Task1Group1Row1();
        System.out.println("BEP in units: " + bep.calculateBEPInUnits());
        System.out.println("BEP in sales value: " + bep.calculateBEPInSalesValue());
        System.out.println("BEP as % of prod. capacity: " + bep.calculateBEPAsPercentOfProductionCapacity());
        System.out.println("Profit or loss for a given prod. capacity: " + bep.profitAtGivenProductionCapacity());
        System.out.println("Minimum price: " + bep.calculateMinimumPrice());
        System.out.println("Safety margin of a price at 75% of demand: " + bep.calculateSafetyMarginOfPrice());
        System.out.println("Maximum unit variable cost allowed: : " + bep.calculateMaxVariableCost());
        System.out.println("Safety margin of a variable cost: " + bep.calculateSafetyMarginOfVariableCost());
        bep.profitIfLowCapacity();
        System.out.println("Safety margin of a  UVC if under reduced demand: " + bep.safetyMarginOfVariableCostUnderLowerDemand());
        System.out.println("Dots for a chart: max revenue and max total costs: " + bep.maxRevenueForChart() + "  " + bep.maxCostsForChart());


        //Task 2 results here
        Task2Results variableCost1 = new VariableCost1();
        System.out.println("Limit of a unit variable cost: " + variableCost1.variableCostLimitResult());
        System.out.println("Limit of a UVC for a desired profit: " + variableCost1.variableCostLimitForAGivenProfitResult());

    }

}

