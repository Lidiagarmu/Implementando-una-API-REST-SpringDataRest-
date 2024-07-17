package com.example;

import com.example.model.Address;
import com.example.model.Customer;
import com.example.repository.AddressRepository;
import com.example.repository.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
      ApplicationContext context =  SpringApplication.run(App.class, args);

       var customerRepo =  context.getBean(CustomerRepository.class); //para sacar el Repositorio de Customer
       var addresRepo =  context.getBean(AddressRepository.class); //para sacar el Repositorio Address

        var addr1 = new Address(null, "madrid");
        var addr2 = new Address(null, "barcelona");
        var addr3 = new Address(null, "gijón");
        addresRepo.saveAll(List.of(addr1, addr2, addr3));

        var cust1 = new Customer(null, "cust1@gmail.com", "dep1", "cat1", addr1);
        var cust2 = new Customer(null, "cust2@gmail.com", "dep2", "cat2", addr2);
        var cust3 = new Customer(null, "cust3@gmail.com", "dep3", "cat3", addr3);
        customerRepo.saveAll(List.of(cust1, cust2, cust3));





    }

}
