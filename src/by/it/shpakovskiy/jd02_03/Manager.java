package by.it.shpakovskiy.jd02_03;

public class Manager implements Runnable {
    private BulbaStore store;
    private boolean alive;
    private boolean endWork;

    Manager(BulbaStore store) {
        this.store = store;
        new Thread(this, "Manager").start();
    }

    public boolean isAlive() {
        return alive;
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                wait();
                alive = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (!endWork) {
            Helper.sleep(1);
            store.checkForCashiers(this);
            if (store.isClosedStore()) {
                store.freePersonal(this);
                break;
            }
        }
        if (ShopRunner.IN_A_TABLE) {
            String s = "│ Total buyers count: " + String.format("%4d", store.getTotalBuyersCount()) +
                    ". Total revenue: $" + String.format("%6.2f", store.getRevenue()) + "." +
                    " ".repeat(116) + "│\n" +
                    "└" + "─".repeat(167) + "┘";
            System.out.println(s);
        } else
            System.out.println("Total buyers count: " + store.getTotalBuyersCount()
                    + ". Total revenue: $" + store.getRevenue());
        System.out.println("########################## BulbaStore closed! Buy! ##########################");
    }

    void endOfWorkingDay() {
        endWork = true;
    }
}
