public class PriceCalculator {

    private double pricePerDay;

    private int days;
    private Season season;
    private DiscountType discountType;

    public PriceCalculator(double pricePerDay, int days, Season season, DiscountType discountType) {
        this.pricePerDay = pricePerDay;
        this.days = days;
        this.season = season;
        this.discountType = discountType;
    }

    public double calculateHoliday() {
        double result = updatePricePerDay(this.pricePerDay, this.season) * days;

        switch (this.discountType) {
            case VIP -> result -= result * 0.2;
            case SecondVisit ->  result -= result * 0.1;
        }

        return result;
    }

    public double updatePricePerDay(double pricePerDay, Season season){
        switch (season){
            case Autumn -> pricePerDay *=1;
            case Spring -> pricePerDay *=2;
            case Winter -> pricePerDay *=3;
            case Summer -> pricePerDay *=4;
        }

        return pricePerDay;
    }
}
