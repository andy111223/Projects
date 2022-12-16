package IPEMResultChecker;

import java.text.NumberFormat;
import java.util.Locale;

public class VariableCost1 implements Task2Results {

    int fixedCost = 2000000;
    int price1 = 10000;
    int price2 = 3000;
    int price3 = 2500;
    int quantity1 = 200;
    int quantity2 = 800;
    int quantity3 = 1200;
    int variableCost1;
    int variableCost2 = 2500;
    int variableCost3 = 2000;

    int assumedProfit = 1300000;

    NumberFormat formatter=NumberFormat.getCurrencyInstance(Locale.FRANCE);

    @Override
    public String variableCostLimitResult() {

        int revenue = price1 * quantity1 + price2 * quantity2 + price3 * quantity3;
        int variableCost2And3 = variableCost2*quantity2 + variableCost3*quantity3;
        variableCost1 = (revenue - variableCost2And3 - fixedCost)/quantity1;
        String variableCost1inEUR = formatter.format(variableCost1);
        return variableCost1inEUR;
    }

    @Override
    public String variableCostLimitForAGivenProfitResult() {

        int revenue = price1 * quantity1 + price2 * quantity2 + price3 * quantity3;
        int variableCost2And3 = variableCost2*quantity2 + variableCost3*quantity3;
        variableCost1 = (revenue - variableCost2And3 - fixedCost - assumedProfit)/quantity1;
        String variableCost1inEUR = formatter.format(variableCost1);
        return variableCost1inEUR;
    }
}
