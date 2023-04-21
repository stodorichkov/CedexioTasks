public class SalesConsultant extends Worker {
    // money witch SalesConsultant will earne
    private double moneyEarned;

    // constuctor for initialization of SalesConsultant
    public SalesConsultant(Shop shop) {
        super(shop);
        this.moneyEarned = 0.0;
    }

    // method for sale product
    public void sellProduct(double price) {
        if(price >= 0) {
            this.moneyEarned += price;
        }
        else {
            System.out.println("You can't have negative price!");
        }
    }

    // method for get earned money
    public double getMoneyEarned() {
        return this.moneyEarned;
    }
}
