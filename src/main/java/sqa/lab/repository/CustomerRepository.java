package sqa.lab.repository;

public interface CustomerRepository {
    public boolean isCustomerValidByCustomerId(int id);

    public void AddCustomerPointByCustomerId(int id);
}
