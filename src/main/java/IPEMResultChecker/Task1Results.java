package IPEMResultChecker;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public interface Task1Results {

    NumberFormat formatter=NumberFormat.getCurrencyInstance(Locale.FRANCE);
    static final DecimalFormat df = new DecimalFormat("0.00");

    int calculateBEPInUnits();
    String calculateBEPInSalesValue();
    String calculateBEPAsPercentOfProductionCapacity();
    String profitAtGivenProductionCapacity();
    String calculateMinimumPrice();
    String calculateSafetyMarginOfPrice();
    String calculateMaxVariableCost();
    String calculateSafetyMarginOfVariableCost();
    void profitIfLowCapacity();
    String parameterUnderLowerDemand();
    String maxRevenueForChart();
    String maxCostsForChart();

}
