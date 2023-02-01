package IPEMResultChecker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ChooseTaskResults  {
    public static void main(String[] args) throws IOException {


        boolean nextGroup = true;
        Map<String, Student> studentMap = new HashMap<String, Student>();

        while (nextGroup) {


            Scanner scanner = new Scanner(System.in);

            System.out.println("Group number (1-6):");
            int groupNumber = scanner.nextInt();
            System.out.println("Row number (1 or 2):");
            int rowNumber = scanner.nextInt();

            System.out.println("Gr" + groupNumber + " row " + rowNumber);


            boolean gr5Row2 = groupNumber == 5 && rowNumber == 2;
            boolean gr4Row2 = groupNumber == 4 && rowNumber == 2;
            boolean gr1Row2 = groupNumber == 1 && rowNumber == 2;
            boolean gr1Row1 = groupNumber == 1 && rowNumber == 1;
            boolean gr2Row1 = groupNumber == 2 && rowNumber == 1;
            boolean gr3Row1 = groupNumber == 3 && rowNumber == 1;
            boolean gr4Row1 = groupNumber == 4 && rowNumber == 1;
            boolean gr5Row1 = groupNumber == 5 && rowNumber == 1;
            boolean gr2Row2 = groupNumber == 2 && rowNumber == 2;
            boolean gr3Row2 = groupNumber == 3 && rowNumber == 2;

            if (gr5Row2 || gr4Row2 || gr1Row2 || gr1Row1 || gr2Row1 || gr3Row1) {
                FindResultsOfTask1 bep = new FindResultsOfTask1(14000, 4000, 7000, 3850000, 0.4, 0.75,0.85, 0.35);
                printResultsOfTask1(bep);
            }

            if (gr5Row1 || gr4Row1) {
                FindResultsOfTask1 bep2 = new FindResultsOfTask1(7300, 16000, 5800, 13500000, 0.8, 0.75, 0.42, 0.3);
                printResultsOfTask1(bep2);
            }
//
//            if (gr2Row2) {
//                Task2500Mz bep = new Task2500Mz();
//                System.out.println("a) BEP in units: " + bep.calculateBEPInUnits());
//                System.out.println("b) BEP in sales value: " + bep.calculateBEPInSalesValue());
//                System.out.println("c) BEP as % of prod. capacity: " + bep.calculateBEPAsPercentOfProductionCapacity() + " %");
//                System.out.println("d) Profit or loss for a given prod. capacity: " + bep.profitAtGivenProductionCapacity());
//                System.out.println("e) Minimum price: " + bep.calculateMinimumPrice());
//                System.out.println("f) Safety margin of a price at 75% of demand: " + bep.calculateSafetyMarginOfPrice()+ " %");
//                System.out.println("g) Maximum unit variable cost allowed: : " + bep.calculateMaxVariableCost());
//                System.out.println("h) Safety margin of a variable cost: " + bep.calculateSafetyMarginOfVariableCost()+ " %");
//                System.out.println("\ni) Profitability under new situation: "); bep.profitIfLowCapacity();
//                System.out.println("\nj) Safety margin of a  UVC if under reduced demand / Minimum prices under reduced demand: " + bep.parameterUnderLowerDemand()+ " %");
//                System.out.println("GRAPH: max revenue: " +bep.maxRevenueForChart() + " TC: " + bep.maxCostsForChart());
//
//            }

//            if (gr3Row2) {
//                Task3500Mc bep4 = new Task3500Mc();
//                printResultsOfTask1();
//
//            }



            //Task 2 results here
            System.out.println("\n--------------TASK 2 results----------------");

            if (gr2Row1 || gr3Row2 ) {
                showTask2Results1();
            } else if (gr1Row2 || gr4Row2 ||gr5Row2 || gr2Row2) {
                showTask2Results2();
            } else if (gr1Row1 || gr3Row1 ||gr4Row1 || gr5Row1) {
                showTask2Results3();
            } else {
                System.out.println("No group found ----END");
            }




            boolean nextStudent = true;
            while (nextStudent) {
                System.out.println("\nEnter student's surname: ");
                String surname = scanner.next();
                System.out.println("Enter Test 1 grade: ");
                double test1grade = scanner.nextDouble();
                System.out.println("Adding the student to the database.");
                Student student = new Student(surname, groupNumber, test1grade);
                studentMap.put(surname, student);
                //            Collection collection = studentMap.values();
                //            Iterator iterator = collection.iterator();
                //            while (iterator.hasNext() != false) {
                //                student = (Student) iterator.next();
                System.out.println(student.getSurname() + "    " + student.getTest1Grade());
                //            }
                System.out.println("\nEnter next student? y/n");
                String ifEnterNextStudent = scanner.next();
                if (ifEnterNextStudent.equals("n")) {
                    nextStudent = false;
                    System.out.println("\nEnter next group? y/n");
                    String ifEnterNextGroup = scanner.next();
                    if (ifEnterNextGroup.equals("n")) {
                        nextGroup = false;
                    }
                }
            }

        }
        Collection<Student> collection = studentMap.values();
        for (Student o : collection) {
            System.out.println(o.getSurname() + "    " + o.getTest1Grade());
        }
        final String outputFilePath = "/home/andrzej/Development/Projects/IndividualProjects/src/main/resources/studentDB.txt";

        File file = new File(outputFilePath);

        BufferedWriter bf = null;

        try {
            // create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter(file));

            // iterate map entries
            for (Map.Entry<String, Student> entry : studentMap.entrySet()) {
                // put key and value separated by a space
                bf.write(entry.getKey() + "    " + entry.getValue());

                //new line
                bf.newLine();
            }
            bf.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                bf.close();
            } catch (Exception e) {

            }
        }


    }

    public static void showTask2Results1() {
        System.out.println("\n--Variable 1----------------");
        Task2Results variableCost1 = new VariableCost1();
        System.out.println("Limit of a unit variable cost: " + variableCost1.variableCostLimitResult());
        System.out.println("Limit of a UVC for a desired profit: " + variableCost1.variableCostLimitForAGivenProfitResult());
    }

    public static void showTask2Results2() {
        System.out.println("\n--Variable 2----------------");
        Task2Results variableCost2 = new VariableCost2();
        System.out.println("Limit of a unit variable cost: " + variableCost2.variableCostLimitResult());
        System.out.println("Limit of a UVC for a desired profit: " + variableCost2.variableCostLimitForAGivenProfitResult());
    }

    public static void showTask2Results3() {
        System.out.println("\n--Variable 3----------------");
        Task2Results variableCost3 = new VariableCost3();
        System.out.println("Limit of a unit variable cost: " + variableCost3.variableCostLimitResult());
        System.out.println("Limit of a UVC for a desired profit: " + variableCost3.variableCostLimitForAGivenProfitResult());
    }

    public static void printResultsOfTask1 (Task1Results results) {
        System.out.println("a) BEP in units: " + results.calculateBEPInUnits());
        System.out.println("b) BEP in sales value: " + results.calculateBEPInSalesValue());
        System.out.println("c) BEP as % of prod. capacity: " + results.calculateBEPAsPercentOfProductionCapacity() + " %");
        System.out.println("d) Profit or loss for a given prod. capacity: " + results.profitAtGivenProductionCapacity());
        System.out.println("e) Minimum price: " + results.calculateMinimumPrice());
        System.out.println("f) Safety margin of a price at 75% of demand: " + results.calculateSafetyMarginOfPrice()+ " %");
        System.out.println("g) Maximum unit variable cost allowed: : " + results.calculateMaxVariableCost());
        System.out.println("h) Safety margin of a variable cost: " + results.calculateSafetyMarginOfVariableCost()+ " %");
        System.out.println("\ni) Profitability under new situation: "); results.profitIfLowCapacity();
        System.out.println("\nj) Safety margin of a  UVC (or minimum price) under reduced demand: " + results.parameterUnderLowerDemand()+ " %");
        System.out.println("GRAPH: max revenue: " +results.maxRevenueForChart() + " TC: " + results.maxCostsForChart());
    }
}

