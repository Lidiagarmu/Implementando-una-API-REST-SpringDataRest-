package com.example.repository;


import com.example.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


/*
 Entrar en http://localhost:8080 para descubrir las urls
*/


@RepositoryRestResource(collectionResourceRel = "customers", path = "customers")
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //este va a ser nuestro Repositorio y nuestro controlador a la vez por ello escribimos aqui los metodos

    // http://localhost:8080/customers/search/findByEmail?email=cust1@gmail.com
    List<Customer> findByEmail(String email);

    //  http://localhost:8080/customers/search/email-starts?email=cust1
    // para customizar su url
    // queda mejor esta notacion separada por guiones que el camelCase
    @RestResource (path ="email-starts", rel = "email-starts" )
    List<Customer> findByEmailStartsWith(String email);

    // si tenemos dos parametros:
    // http://localhost:8080/customers/search/category-dept?category=cat1&dept=dep1
    @RestResource (path ="category-dept", rel = "category-dept" )
    List<Customer> findByCategoryAndDept(String category, String dept);

    // http://localhost:8080/customers/search/category-dept-in?category=cat1&dept=dep1&dept=dep2
    @RestResource (path ="category-dept-in", rel = "category-dept-in" )
    List<Customer> findByCategoryAndDeptIn(String category, List<String> dept);



}
