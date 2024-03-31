package me.apella.jobs.service;

import me.apella.jobs.model.Company;

import java.util.List;
import java.util.UUID;

public interface CompanyService {
    List<Company> findAll();

    void createCompany(Company company);

    Company getCompanyById(UUID id);

    boolean deleteCompanyById(UUID id);

    boolean updateCompanyById(UUID id, Company updatedCompany);
}
