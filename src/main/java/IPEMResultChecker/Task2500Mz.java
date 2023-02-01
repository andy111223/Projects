package IPEMResultChecker;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Task2500Mz implements Task1Results {

    //Group 2 row 2
    int price = 25000;
    int demand = 4600;
    int unitVariableCost = 18500;
    int fixedCosts = 13000000;

    double usageOfCapacity = 0.55;

    double percentageOfDemand = 1;
    double dropOfCapacity = 0.55;
    double dropOfDemand = 0.4;

    int BEPUnits;
    int maxVariableCost;

//    NumberFormat formatter=NumberFormat.getCurrencyInstance(Locale.FRANCE);
//    private static final DecimalFormat df = new DecimalFormat("0.00");



    public int calculateBEPInUnits() {
        BEPUnits = fixedCosts/(price-unitVariableCost);
        return BEPUnits;
    }
    public String calculateBEPInSalesValue() {
        int BEPInSalesValue = BEPUnits * price;
        String BEPInEUR = formatter.format(BEPInSalesValue);
        return BEPInEUR;
    }

    public String calculateBEPAsPercentOfProductionCapacity() {
        double BEPAsPercentOfProductionCapacity = (double) BEPUnits / demand;
        return df.format(BEPAsPercentOfProductionCapacity*100);
    }
    public String profitAtGivenProductionCapacity() {
        int profitAtGivenProductionCapacity = (int) (usageOfCapacity*demand*(price-unitVariableCost)-fixedCosts);
        String profitAtGivenProductionCapacityInEUR = formatter.format(profitAtGivenProductionCapacity);
        return profitAtGivenProductionCapacityInEUR;
    }
    public String calculateMinimumPrice() {
        int minimumPrice = unitVariableCost + (fixedCosts/demand);
        String minimumPriceInEUR = formatter.format(minimumPrice);
        return minimumPriceInEUR;
    }
    public String calculateSafetyMarginOfPrice() {
        double minimumPriceAtLowerOfDemand = (double) (unitVariableCost + (fixedCosts/(percentageOfDemand * demand)));
        double safetyMarginOfPrice = (double) ((price-minimumPriceAtLowerOfDemand)/price);
        return df.format(safetyMarginOfPrice*100);
    }
    public String calculateMaxVariableCost() {
        maxVariableCost = price - (fixedCosts/demand);
        String maxVariableCostinEUR = formatter.format(maxVariableCost);
        return maxVariableCostinEUR;
    }
    public String calculateSafetyMarginOfVariableCost() {
        double safetyMarginOfVariableCost = (double) (maxVariableCost - unitVariableCost)/unitVariableCost;
        return df.format(safetyMarginOfVariableCost*100);
    }
    public void profitIfLowCapacity() {
        double newCapacity = 1-dropOfCapacity;
        int profitMargin = price-unitVariableCost;
        double newCapacityTimesDemand = newCapacity*demand;
        double profitIfLowCapacity = (newCapacityTimesDemand*profitMargin)-fixedCosts;
        String profitIfLowCapacityInEUR = formatter.format(profitIfLowCapacity);
        if ((int)profitIfLowCapacity < 0) {
            System.out.println(profitIfLowCapacityInEUR + " -> project NOT profitable");
        } else if (profitIfLowCapacity >= 0) {
            System.out.println(profitIfLowCapacityInEUR + " -> project still profitable");
        }
    }


    public String parameterUnderLowerDemand() {
        int minimumPriceUnderLowerDemand = (int) (unitVariableCost + (fixedCosts/((1-dropOfDemand)*demand)));
        return df.format(minimumPriceUnderLowerDemand);
    }


    //Data necessary for a student to draw a graph
    public String maxRevenueForChart() {
        int maxRevenue = demand * price;
        String maxRevenueInEUR = formatter.format(maxRevenue);
        return maxRevenueInEUR;
    }
    public String maxCostsForChart() {
        int maxCost = fixedCosts + demand*unitVariableCost;
        String maxCostInEUR = formatter.format(maxCost);
        return maxCostInEUR;
    }
}
