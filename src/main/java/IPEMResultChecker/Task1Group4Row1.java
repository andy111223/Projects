package IPEMResultChecker;

public class Task1Group4Row1 implements Task1Results {

    int price = 73000;
    int demand = 16000;
    int unitVariableCost = 5800;
    int fixedCosts = 13500000;

    double usageOfCapacity = 0.8;
    double dropOfCapacity = 0.42;
    double dropOfDemand = 0.3;

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
        int minimumPriceAtLowerOfDemand = (int) (unitVariableCost + (fixedCosts/(0.75 * demand)));
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
        double profitIfLowCapacity = (1-dropOfCapacity)*((price-unitVariableCost)-fixedCosts);
        if (profitIfLowCapacity < 0) {
            System.out.println(profitIfLowCapacity + " -> project NOT profitable");
        } else if (profitIfLowCapacity >= 0) {
            System.out.println(profitIfLowCapacity + " -> project still profitable");
        }
    }
    public double safetyMarginOfVariableCostUnderLowerDemand() {
        double safetyMarginOfVariableCostUnderLowerDemand = (double) (price - (fixedCosts / (1-dropOfDemand)* demand));
        return  safetyMarginOfVariableCostUnderLowerDemand;
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
