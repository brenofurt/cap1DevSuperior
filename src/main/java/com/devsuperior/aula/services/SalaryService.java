package com.devsuperior.aula.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.aula.entities.Employee;

@Service
public class SalaryService {
	
	@Autowired
	private TaxService taxService;
	
	@Autowired
	private PensionService pensionService;
	
//	public SalaryService(TaxService taxService, PensionService pensionService) {
//		this.taxService = taxService;
//		this.pensionService = pensionService;
//	}
	
	public double netSalary(Employee employee) {
		return (employee.getGrossSalary() - taxService.tax(employee.getGrossSalary()) - pensionService.discount(employee.getGrossSalary()));
	}
	
}
