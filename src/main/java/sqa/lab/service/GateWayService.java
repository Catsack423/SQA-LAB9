package sqa.lab.service;

public class GateWayService {
    private CustomerCounterService counter;

    public GateWayService(CustomerCounterService counterService){
        this.counter = counterService;
    }
}
