package org.ibs.example.dto.mapper;

import org.ibs.example.dto.Employee;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {
    Employee toDto(org.ibs.example.domain.Employee employee);
}
