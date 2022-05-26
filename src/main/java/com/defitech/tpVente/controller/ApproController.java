package com.defitech.tpVente.controller;

import com.defitech.tpVente.modele.Appro;
import com.defitech.tpVente.service.ApproService;
import com.defitech.tpVente.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class ApproController {
    @Autowired
    private ApproService approService;
    @Autowired
    private ArticleService articleService;

    @GetMapping("/approShow")
    public String showAllAppro(Model model){
        model.addAttribute("listeAppro",approService.showAllAppro());
        //pas obligé d'avoir le mm nom que le return
        return "design/ListeAppro";
    }
    @GetMapping("/approForm")
    public String ShowFormAppro(Model model){
        model.addAttribute("listeAppro",articleService.showAllArticles());
        return "design/approForm";
    }
    @PostMapping("/appro/save")
    public String saveAppro(Appro appro){
        appro.setQteAppro(appro.getQteAppro());
        appro.setDateAppro(LocalDate.now());
        approService.saveAppro(appro);
        articleService.updateStockArticle(appro.getQteAppro(),appro.getArticleId());
        return "redirect:/approShow";
    }
    @GetMapping("/approEdit{id}")
    public String approEdit(@PathVariable("id") int id, Model model){
        model.addAttribute("Un_approvisionnement",approService.showOneAppro(id));
        model.addAttribute("listeAppro",articleService.showAllArticles());
        return "appro/approEdit";
    }
    @PostMapping("appro/update")
    public  String updateAppro(@ModelAttribute("approvisionnement") Appro appro){
        approService.saveAppro(appro);
        return "redirect:/approShow";

    }
    @GetMapping("/appro/delete/{id}")
    public String deleteAppro(@PathVariable("id") int id){
        approService.deleteAppro(id);
        return "redirect:/approShow";

    }
}
