public class MarketingSpecialist extends Worker {
    // spent budget
    private double budgetSpent;
    
    // limit of budget
    private final double budgetLimit;

    // constuctor for initialization of MarketingSpecialist
    public MarketingSpecialist(Shop shop, double budgetLimit) {
        super(shop);
        this.budgetLimit = budgetLimit;
        this.budgetSpent = 0.0;
    }

    // method for spend budget
    public void spendBudget(double marketingCampaignCost) {
        if(budgetSpent + marketingCampaignCost <= budgetLimit && marketingCampaignCost >= 0) {
            budgetSpent += marketingCampaignCost;
        }
        else if(marketingCampaignCost < 0) {
            System.out.println("You can't have negative marketing campaign cost!");
        }
        else {
            System.out.println("You can't spend money over budget!");
        }
    }

    public double getBudgetSpent() {
        return this.budgetSpent;
    }
}
