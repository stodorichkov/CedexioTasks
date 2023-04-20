public class MarketingSpecialist extends Worker {
    // spent budget
    private double budgetSpent = 0.0;
    
    // limit of budget
    private final double budgetLimit;

    // constuctor for initialization of MarketingSpecialist
    public MarketingSpecialist(Shop shop, double budgetLimit) {
        super(shop);
        this.budgetLimit = budgetLimit;
    }

    // method for spend budget
    public void spendBudget(double amount) {
        amount = Math.max(amount, 0);
        if(budgetSpent + amount <= budgetLimit) {
            budgetSpent += amount;
        }
        else {
            System.out.println("You can't spend money over budget!");
        }
    }

    public double getBudgetSpent() {
        return this.budgetSpent;
    }
}
