public class SalesConsultant extends Worker {
    // money witch SalesConsultant will earne
    private double moneyEarned = 0.0;

    // constuctor for initialization of SalesConsultant
    public SalesConsultant(Shop shop) {
        super(shop);
    }

    // method for sale product
    public void sellProduct(double price) {
        this.moneyEarned += price;
    }

    // method for get earned money
    public double getMoneyEarned() {
        return this.moneyEarned;
    }
}
