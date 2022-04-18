import input.Reader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Reader reader = new Reader();
        String[] tokens = reader.readStringArray("\\s+");

        double pricePerDay = Double.parseDouble(tokens[0]);
        int days = Integer.parseInt(tokens[0]);
        Season season = Season.valueOf(tokens[2]);
        DiscountType discountType = DiscountType.valueOf(tokens[3]);
        PriceCalculator priceCalculator = new PriceCalculator(pricePerDay, days, season, discountType);

        double result = priceCalculator.calculateHoliday();

        System.out.printf("%.2f", result);

    }
}
