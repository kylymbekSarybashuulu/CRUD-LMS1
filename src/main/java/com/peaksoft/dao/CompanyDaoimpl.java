package com.peaksoft.dao;

import com.peaksoft.entity.Company;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;

@Repository
@Transactional
public class CompanyDaoimpl implements CompanyDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Company> getAllCompanies() {
        List<Company> companies = entityManager.createQuery("from Company", Company.class).getResultList();
        Comparator<Company> comparator = ((o1, o2) -> (int) (o1.getId() - o2.getId()));
        companies.sort(comparator);
        return companies;
    }

    @Override
    public void addCompany(Company company) {
        entityManager.persist(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return entityManager.find(Company.class, id);
    }

    @Override
    public void updateCompany(Company company) {

//        Company company1 = getCompanyById(company.getId());
//        company1.setCompanyName(company.getCompanyName());
//        company1.setLocateCountry(company.getLocateCountry());

        entityManager.merge(company);
    }
    @Override
    public void deleteCompany(Company company) {
        entityManager.remove(entityManager.contains(company) ? company : entityManager.merge(company));

    }
}
