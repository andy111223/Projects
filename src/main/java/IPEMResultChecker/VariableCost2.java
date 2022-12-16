package IPEMResultChecker;

import java.text.NumberFormat;
import java.util.Locale;

public class VariableCost2 implements Task2Results {
    int fixedCost = 2000000;
    int price1 = 10000;
    int price2 = 3000;
    int price3 = 2500;
    int quantity1 = 200;
    int quantity2 = 800;
    int quantity3 = 1200;
    int variableCost1 = 5000;
    int variableCost2;
    int variableCost3 = 2000;

    int assumedProfit = 1300000;

    NumberFormat formatter=NumberFormat.getCurrencyInstance(Locale.FRANCE);
    @Override
    public String variableCostLimitResult() {

        int revenue = price1 * quantity1 + price2 * quantity2 + price3 * quantity3;
        int variableCost1and3 = variableCost1*quantity1 + variableCost3*quantity3;
        variableCost2 = (revenue-variableCost1and3-fixedCost)/quantity2;
        String variableCost2inEUR = formatter.format(variableCost2);
        return  variableCost2inEUR;
    }

    @Override
    public String variableCostLimitForAGivenProfitResult() {
        int revenue = price1 * quantity1 + price2 * quantity2 + price3 * quantity3;
        int variableCost1and3 = variableCost1*quantity1 + variableCost3*quantity3;
        variableCost2 = (revenue-variableCost1and3-fixedCost-assumedProfit)/quantity2;
        String variableCost2inEUR = formatter.format(variableCost2);
        return  variableCost2inEUR;
    }
}
