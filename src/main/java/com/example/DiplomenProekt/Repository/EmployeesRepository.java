package com.example.DiplomenProekt.Repository;

import com.example.DiplomenProekt.Entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeesRepository extends JpaRepository<Employees, Long> {
    @Query("SELECT u FROM Employees u WHERE u.email = ?1")
    public Employees findByEmail(String email);
}
