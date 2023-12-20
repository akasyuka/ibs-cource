package org.ibs.example.controller.v2;

import org.ibs.example.repository.EmployeeRepository;
import org.ibs.example.service.BigSalaryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BigSalaryService bigsalaryService;

    @MockBean
    private EmployeeRepository employeeRepository;


    @Test
    void getSubordinatesMaxSalary() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v2/employees/bigsalary"))
                .andDo(print()).andExpect(status().isOk());
    }
}