package IPEMResultChecker;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class FindResultsOfTask1 implements Task1Results {
    //gr 5 row 2; gr 4 row 2; gr 1 row 2; gr 1 row 1; gr 2 row 1; gr 3 row 1


    int price; //14000
    int demand; //4000
    int unitVariableCost; //7000
    int fixedCosts; //3850000

    double usageOfCapacity; //0.4
    double dropOfCapacity; //0.85
    double dropOfDemand; //0.35

    int BEPUnits;
    int maxVariableCost;

    public FindResultsOfTask1(int price, int demand, int unitVariableCost, int fixedCosts, double usageOfCapacity, double dropOfCapacity, double dropOfDemand) {
        this.price = price;
        this.demand = demand;
        this.unitVariableCost = unitVariableCost;
        this.fixedCosts = fixedCosts;
        this.usageOfCapacity = usageOfCapacity;
        this.dropOfCapacity = dropOfCapacity;
        this.dropOfDemand = dropOfDemand;
    }

    @Override
    public void showResultsOfTask1() {
    }


    NumberFormat formatter=NumberFormat.getCurrencyInstance(Locale.FRANCE);
    private static final DecimalFormat df = new DecimalFormat("0.00");


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
        double minimumPriceAtLowerOfDemand = (double) (unitVariableCost + (fixedCosts/(0.75 * demand)));
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
    public String safetyMarginOfVariableCostUnderLowerDemand() {
        double newDemandPercentage = 1-dropOfDemand;
        double maxVariableCostUnderLowerDemand = (double) (price - (fixedCosts / (newDemandPercentage * demand)));
        double safetyMarginOfVariableCostUnderLowerDemand = (maxVariableCostUnderLowerDemand - unitVariableCost)/unitVariableCost;
        return df.format(safetyMarginOfVariableCostUnderLowerDemand*100);
    }
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
