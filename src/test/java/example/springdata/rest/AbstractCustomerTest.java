package example.springdata.rest;

import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractCustomerTest extends AbstractTest {

    @Autowired
    protected CustomerRepository customerRepository;

    @After
    public void cleanup() {
        customerRepository.deleteAll();
    }

}
