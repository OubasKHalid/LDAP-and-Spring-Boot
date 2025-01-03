package com.projet.appcnss.web;

import com.projet.appcnss.entities.App;
import com.projet.appcnss.repositories.AppRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class AppController {
    private AppRepository appRepo;
    @GetMapping( "index")
    public String apps(Model model,
                       @RequestParam(name = "page" ,defaultValue="0")int page,
                       @RequestParam(name="size",defaultValue="5")int size,
                       @RequestParam(name="keyword",defaultValue="")String keyword){
        Page<App> pageApplications=appRepo.findByTitleContains(keyword,PageRequest.of(page,size));
        model.addAttribute("listApp",pageApplications.getContent());
        model.addAttribute("pages",new int[pageApplications.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "apps";
    }

    @GetMapping( "/")
    public String home(){
        return "redirect:/index";
    }
    //delet ID
    @GetMapping( "/delete")
    public String delete(Long id, String keyword,int page){
      appRepo.deleteById(id);
      return"redirect:/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/formApps")
    public String formAApps(Model model){
        model.addAttribute("app",new App());
        return "formApps";
    }
    @PostMapping("/save")
    public String saveApp(@Valid App apps){
        appRepo.save(apps);
        return "redirect:/index";
    }
    @GetMapping("/editeApp")
    public String editeApp(@RequestParam(name = "id") Long id, Model model){
        App apps=appRepo.findById(id).get();
        model.addAttribute("app",apps);
        return "editApp";
    }

}
