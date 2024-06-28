package com.example.BackendLoginRegistration.Service;

import com.example.BackendLoginRegistration.Dto.EmployeeDTO;
import com.example.BackendLoginRegistration.Dto.LoginDTO;
import com.example.BackendLoginRegistration.Response.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeServices {
    String addEmplyee(EmployeeDTO employeeDTO);

    LoginResponse loginEmployee(LoginDTO loginDTO);
}
