package org.ibs.example.entity.dto.mapper;

import javax.annotation.processing.Generated;
import org.ibs.example.entity.Employee;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-30T23:24:29+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.14 (Amazon.com Inc.)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public org.ibs.example.entity.dto.Employee toDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        org.ibs.example.entity.dto.Employee employee1 = new org.ibs.example.entity.dto.Employee();

        employee1.setFirstName( employee.getFirstName() );
        employee1.setLastName( employee.getLastName() );
        employee1.setBirthday( employee.getBirthday() );
        employee1.setMonthSalary( employee.getMonthSalary() );

        return employee1;
    }
}
