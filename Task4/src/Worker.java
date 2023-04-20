// abstract class to describe all workers
public abstract class Worker {
    // instance of Shop
    private final Shop shop;

    // constuctor for initialization of worker 
    public Worker(Shop shop) {
        this.shop = shop;
        this.shop.addWorker(this);
    }
}