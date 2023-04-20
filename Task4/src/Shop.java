import java.util.ArrayList;
import java.util.List;

public class Shop {
    private static final Shop instance = new Shop();
    private List<Worker> workers = new ArrayList<>();

    // private constructon to prevent outsede instance
    private Shop() {}

    // get instance of shop
    public static Shop getInstance() {
        return instance;
    }

    // method to add worker
    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    // method to get turnover
    public double getTurnover() {
        double turnover = 0.0;
        for (Worker worker : this.workers) {
            if (worker instanceof  SalesConsultant) {
                turnover += ((SalesConsultant) worker).getMoneyEarned();
            }
 
            if (worker instanceof  MarketingSpecialist) {
                turnover -= ((MarketingSpecialist) worker).getBudgetSpent();
            }
        }
 
        return turnover;
    }
}
