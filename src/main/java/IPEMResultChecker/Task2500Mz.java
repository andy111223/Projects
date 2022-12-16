package IPEMResultChecker;

public class Task2500Mz implements Task1Results {

    //Group 2 row 2
    int price = 25000;
    int demand = 4600;
    int unitVariableCost = 18500;
    int fixedCosts = 13000000;

    double usageOfCapacity = 0.55;
    double dropOfCapacity = 0.55;
    double dropOfDemand = 0.4;

    int BEPUnits;
    int maxVariableCost;

    @Override
    public void showResultsOfTask1() {
    }

    public int calculateBEPInUnits() {
        BEPUnits = fixedCosts/(price-unitVariableCost);
        return BEPUnits;
    }
    public int calculateBEPInSalesValue() {
        int BEPInSalesValue = BEPUnits * price;
        return BEPInSalesValue;
    }

    public double calculateBEPAsPercentOfProductionCapacity() {
        double BEPAsPercentOfProductionCapacity = (double) BEPUnits / demand;
        return BEPAsPercentOfProductionCapacity;
    }
    public int profitAtGivenProductionCapacity() {
        int profitAtGivenProductionCapacity = (int) (usageOfCapacity*demand*(price-unitVariableCost)-fixedCosts);
        return profitAtGivenProductionCapacity;
    }
    public int calculateMinimumPrice() {
        int minimumPrice = unitVariableCost + (fixedCosts/demand);
        return minimumPrice;
    }
    public double calculateSafetyMarginOfPrice() {
        int minimumPriceAtLowerOfDemand = (int) (unitVariableCost + (fixedCosts/demand));
        double safetyMarginOfPrice = (double) ((price-minimumPriceAtLowerOfDemand)/price);
        return safetyMarginOfPrice;
    }
    public int calculateMaxVariableCost() {
        maxVariableCost = price - (fixedCosts/demand);
        return maxVariableCost;
    }
    public double calculateSafetyMarginOfVariableCost() {
        double safetyMarginOfVariableCost = (double) (maxVariableCost - unitVariableCost)/unitVariableCost;
        return safetyMarginOfVariableCost;
    }
    public void profitIfLowCapacity() {
        double newCapacity = 1-dropOfCapacity;
        int profitMargin = price-unitVariableCost;
        double newCapacityTimesDemand = newCapacity*demand;
        double profitIfLowCapacity = (newCapacityTimesDemand*profitMargin)-fixedCosts;
        if ((int)profitIfLowCapacity < 0) {
            System.out.println(profitIfLowCapacity + " -> project NOT profitable");
        } else if (profitIfLowCapacity >= 0) {
            System.out.println(profitIfLowCapacity + " -> project still profitable");
        }
    }
    public int minimumPriceUnderLowerDemand() {
        int minimumPriceUnderLowerDemand = (int) (unitVariableCost + (fixedCosts/((1-dropOfDemand)*demand)));
        return minimumPriceUnderLowerDemand;
    }


    //Data necessary for a student to draw a graph
    public int maxRevenueForChart() {
        int maxRevenue = demand * price;
        return maxRevenue;
    }
    public int maxCostsForChart() {
        int maxCost = fixedCosts + demand*unitVariableCost;
        return maxCost;
    }
}
