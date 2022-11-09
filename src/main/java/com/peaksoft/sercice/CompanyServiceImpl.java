package com.peaksoft.sercice;

import com.peaksoft.dao.CompanyDao;
import com.peaksoft.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyDao companyDao;

    @Autowired
    public CompanyServiceImpl(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @Override
    public List<Company> getAllCompanies() {
        System.out.println("service");
        return companyDao.getAllCompanies();
    }

    @Override
    public void addCompany(Company company) {
        companyDao.addCompany(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyDao.getCompanyById(id);
    }

    @Override
    public void ubdateCompany(Company company) {
        companyDao.updateCompany(company);
    }

    @Override
    public void deleteCompany(Company companyById) {
        companyDao.deleteCompany(companyById);
    }
}
