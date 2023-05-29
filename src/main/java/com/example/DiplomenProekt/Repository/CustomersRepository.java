package com.example.DiplomenProekt.Repository;

import com.example.DiplomenProekt.Entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customers, Long> {

}