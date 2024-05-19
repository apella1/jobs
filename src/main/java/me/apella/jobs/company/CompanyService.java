package me.apella.jobs.company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();

    void createCompany(Company company);

    Company getCompanyById(Integer id);

    boolean deleteCompanyById(Integer id);

    boolean updateCompanyById(Integer id, Company updatedCompany);
}
