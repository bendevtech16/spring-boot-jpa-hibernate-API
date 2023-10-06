package controllers;

import entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.UtilisateurService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("localhost:8080/api/users")
public class UserController {
    private final UtilisateurService utilisateurService;
    @Autowired
    public UserController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }
    @GetMapping
    @RequestMapping("localhost:8080/utilisateurs")
    public List<Utilisateur>  getAllUtilisateur(){
        return utilisateurService.getAllUtilisateur();
    }
    @GetMapping("/{id}")
    public Optional<Utilisateur> getUtilisateurById(@PathVariable Long id){
        return  utilisateurService.getUtilisateurById(id);
    }

    @PostMapping
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur){
        return utilisateurService.createUtilisateur(utilisateur);
    }
    @PostMapping("/{id}")
    public  Utilisateur updateUtilisateur(@PathVariable Long id, @RequestBody Utilisateur utilisateur){
        utilisateur.setId(id);
        return  utilisateurService.updateUtilisateur(utilisateur);
    }
    public void deleteUtilisateur(@PathVariable long id){
        utilisateurService.deleteUtilisateur(id);
    }





}
