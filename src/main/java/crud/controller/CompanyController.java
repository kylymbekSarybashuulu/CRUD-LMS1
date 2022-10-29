package crud.controller;

import crud.entity.Company;
import crud.sercice.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
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
    public String getCompanies(Model model){
        System.out.println("Java");
        //List<Company> companies = companyService.getAllCompanies();
        System.out.println("Java");
        //model.addAttribute("company",companies);
        return "company/companies";
    }

    @GetMapping("/addCompany")
    public String addCompany(Model model){
        model.addAttribute("company",new Company());
        return "company/addCompany";
    }

    @PostMapping("/saveCompany")
    public String saveCompany(@ModelAttribute("company") Company company){
        companyService.addCompany(company);
        return "redirect:/companies";
    }

    @GetMapping("/updateCompany")
    public String ubdateCompany(@RequestParam("companyId") Long Id, Model model){
        Company company =companyService.getCompanyById(Id);
        model.addAttribute("company",company);
        return "company/updateCompany";
    }
    @PostMapping
            ("saveUpdateCompany")
    public String saveUbdateCompany(@ModelAttribute("company")Company company){
        companyService.ubdateCompany(company);
        return "redirect: /getAllCompanies";
    }
    @DeleteMapping("/deleteCompany")
    public String deleteCompany(@RequestParam("companyId") Long Id){
        companyService.deleteCompany(companyService.getCompanyById(Id));
        return "redirect:/getAllCompanies";

    }
}



