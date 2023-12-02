package br.com.clocktimeapi.clocktimeapi.modules.employee.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clocktimeapi.clocktimeapi.exceptions.UserNotFoundException;
import br.com.clocktimeapi.clocktimeapi.modules.employee.repositories.EmployeeRepository;

@Service
public class EmployeeDeleteService {

    @Autowired
    private EmployeeRepository userRepository;
    
    public void delete(String uid) {
        var user = this.userRepository.findByUid(uid)
            .orElseThrow(() -> new UserNotFoundException(uid));

        this.userRepository.delete(user);
    }

}