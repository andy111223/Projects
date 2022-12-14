package IPEMResultChecker;

public class VariableCost3 implements Task2Results {

    int fixedCost = 2000000;
    int price1 = 10000;
    int price2 = 3000;
    int price3 = 2500;
    int quantity1 = 200;
    int quantity2 = 800;
    int quantity3 = 1200;
    int variableCost1 = 5000;
    int variableCost2 = 2500;
    int variableCost3;

    int assumedProfit = 800000;


    @Override
    public int variableCostLimitResult() {
        int revenue = price1 * quantity1 + price2 * quantity2 + price3 * quantity3;
        int variableCost1and2 = variableCost1 * quantity1 + variableCost2 * quantity2;
        variableCost3 = (revenue - variableCost1and2 - fixedCost)/quantity3;
        return variableCost3;
    }

    @Override
    public int variableCostLimitForAGivenProfitResult() {
        int revenue = price1 * quantity1 + price2 * quantity2 + price3 * quantity3;
        int variableCost1and2 = variableCost1 * quantity1 + variableCost2 * quantity2;
        variableCost3 = (revenue - variableCost1and2 - fixedCost - assumedProfit)/quantity3;
        return variableCost3;
    }
}
