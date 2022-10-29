package crud.dao;

import crud.entity.Company;

import java.util.List;

public interface CompanyDao {

    List<Company> getAllCompanies();
    void addCompany(Company company);
    Company getCompanyById(Long id);
    void ubdateCompany(Company company);
    void deleteCompany(Company company);

}
