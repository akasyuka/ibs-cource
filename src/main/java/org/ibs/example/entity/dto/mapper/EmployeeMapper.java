package org.ibs.example.entity.dto.mapper;

import org.ibs.example.entity.dto.Employee;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {
    Employee toDto(org.ibs.example.entity.Employee employee);
}
