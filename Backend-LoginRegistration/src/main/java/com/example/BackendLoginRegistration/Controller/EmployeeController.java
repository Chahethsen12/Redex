package com.example.BackendLoginRegistration.Controller;

import com.example.BackendLoginRegistration.Dto.EmployeeDTO;
import com.example.BackendLoginRegistration.Dto.LoginDTO;
import com.example.BackendLoginRegistration.Response.LoginResponse;
import com.example.BackendLoginRegistration.Service.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeServices;

    @PostMapping(path = "/save")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        String id = employeeServices.addEmplyee(employeeDTO);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO){
        LoginResponse loginResponse = employeeServices.loginEmployee(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

}


