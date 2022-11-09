package com.peaksoft.sercice;

import com.peaksoft.entity.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();

    void addCompany(Company company);

    Company getCompanyById(Long id);

    void ubdateCompany(Company company);

    void deleteCompany(Company companyById);
}
