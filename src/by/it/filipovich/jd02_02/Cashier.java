package by.it.filipovich.jd02_02;

public class Cashier implements Runnable {
    private String name;

    public Cashier(int number) {
        name="--Cashier № "+number+" ";
    }

    @Override
    public void run() {
        System.out.println(this+"opened.");
        while (!Dispatcher.marketIsClosed()){
            Buyer buyer = QueueBuyer.extract();
            if (buyer!=null){
                System.out.println(this+"started service "+buyer);
                int timeout = Helper.random(2000, 5000);
                Helper.sleep(timeout);
                System.out.println(this+"finished service "+buyer);
                synchronized (buyer){
                    buyer.notify();
                }
            } else {
                //wait for this??
                Helper.sleep(1);
            }
        }
        System.out.println(this+"closed.");
    }

    @Override
    public String toString() {
        return name;
    }
}
