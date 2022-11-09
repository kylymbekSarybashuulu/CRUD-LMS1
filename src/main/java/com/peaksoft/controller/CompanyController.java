package com.peaksoft.controller;

import com.peaksoft.sercice.CompanyService;
import com.peaksoft.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping()
    public String getCompanies(Model model) {
        List<Company> companies = companyService.getAllCompanies();
        model.addAttribute("companies", companies);
        return "company/companies";
    }

    @GetMapping("/addCompany")
    public String addCompany(Model model) {
        model.addAttribute("company", new Company());
        return "company/addCompany";
    }

    @PostMapping("/saveCompany")
    public String saveCompany(@ModelAttribute("company") Company company) {
        System.out.println("COMPANY: " + company.toString());
        companyService.addCompany(company);
        return "redirect:/company";
    }

    @GetMapping("/updateCompany/{id}")
    public String updateCompany(@PathVariable Long id, Model model) {
        Company company = companyService.getCompanyById(id);
        model.addAttribute("company", company);
        return "company/updateCompany";
    }

    @PatchMapping("/saveUpdateCompany")
    public String saveUpdateCompany(@ModelAttribute("company") Company company) {
        companyService.ubdateCompany(company);
        return "redirect:/company";
    }

    @DeleteMapping("/deleteCompany/{id}")
    public String deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(companyService.getCompanyById(id));
        return "redirect:/company";

    }
}



