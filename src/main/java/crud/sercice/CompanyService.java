package crud.sercice;

import crud.entity.Company;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();

    void addCompany(Company company);

    Company getCompanyById(Long id);

    void ubdateCompany(Company company);

    void deleteCompany(Company companyById);
}
