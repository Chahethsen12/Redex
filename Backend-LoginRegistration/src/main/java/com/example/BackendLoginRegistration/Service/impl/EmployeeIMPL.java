package com.example.BackendLoginRegistration.Service.impl;

import com.example.BackendLoginRegistration.Dto.EmployeeDTO;
import com.example.BackendLoginRegistration.Dto.LoginDTO;
import com.example.BackendLoginRegistration.Entity.Employee;
import com.example.BackendLoginRegistration.Repo.EmployeeRepo;
import com.example.BackendLoginRegistration.Response.LoginResponse;
import com.example.BackendLoginRegistration.Service.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeIMPL implements EmployeeServices {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addEmplyee(EmployeeDTO employeeDTO) {

        Employee employee = new Employee(

                employeeDTO.getEmployeeid(),
                employeeDTO.getEmployeename(),
                employeeDTO.getEmail(),

                this.passwordEncoder.encode(employeeDTO.getPassword())

        );

        employeeRepo.save(employee);

        return employee.getEmployeename();

    }

    @Override
    public LoginResponse loginEmployee(LoginDTO loginDTO) {

        String msg = "";
        Employee employee1 = employeeRepo.findByEmail(loginDTO.getEmail());
        if (employee1 != null){
            String password = loginDTO.getPassword();
            String encodeedPassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodeedPassword);
            if(isPwdRight){
                Optional<Employee> employee = employeeRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodeedPassword);
                if(employee.isPresent()){
                    return new LoginResponse("Login Success",true);
                }else {
                    return new LoginResponse("Login Failed",false);
                }
            } else {
                return new LoginResponse("Password Not Match",false);
            }
        } else {
            return new LoginResponse("Email not exists",false);
        }

    }
}
