package sqa.lab.service;

public class CustomerCounterService {
    private int numberCustomer=0;

    public CustomerCounterService(int numberCustomer) {
        this.numberCustomer = numberCustomer;
    }

    public int getNumberCustomer() {
        return numberCustomer;
    }

    public void setNumberCustomer(int numberCustomer) {
        this.numberCustomer = numberCustomer;
    }

    public void increaseCounter() {
        setNumberCustomer(getNumberCustomer() + 1);
    }

    public void resetCounter() {
        setNumberCustomer(0);
    }

}
