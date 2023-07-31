package br.com.back.storestaffmanager.service;

import br.com.back.storestaffmanager.model.Employee;
import br.com.back.storestaffmanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;


    public List<Employee> getAllEmployee(){
        return repository.findAll();
    }

    public Employee createEmployee(Employee employee) {

        return repository.save(employee);
    }

    public void deleteEmployee(Long id){
        repository.deleteById(id);
    }
}
