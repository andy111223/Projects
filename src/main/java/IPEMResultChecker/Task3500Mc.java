package IPEMResultChecker;

public class Task3500Mc {
    //Group 3 row 2
    int price = 3500;
    int demand = 15000;
    int unitVariableCost = 2200;
    int fixedCosts = 7800000;

    double usageOfCapacity = 1.00;
    double dropOfCapacity = 0.55;
    double dropOfDemand = 0.5;

    int BEPUnits;
    int maxVariableCost;


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
        int maxVariableCost2 = price - (fixedCosts/(demand/3));
        double safetyMarginOfVariableCost = (double) (maxVariableCost2 - unitVariableCost)/unitVariableCost;
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
