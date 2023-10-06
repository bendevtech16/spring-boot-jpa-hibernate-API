package services;

import dao.UtilisateurRepository;
import entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {
    /**
     * une instance de repository pour utiliser les methode de jpa
     */
    private  final UtilisateurRepository utilisateurRepository;
    private List<Utilisateur> utilisateurs = new ArrayList<>();

    /**
     *
     * @param utilisateurRepository constructeur du service pour l'injection de dependance
     */
    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    /**
     *
     * @param utilisateur on passe un utilisateur a enregistrer
     * @return on retoure l'utilisateur qui a ete enregistre.
     */
    public Utilisateur createUtilisateur(Utilisateur utilisateur){
        return  utilisateurRepository.save(utilisateur);
    }

    /**
     * @param id id de l'utilisateur quon veut recuperer
     * @return l'utilisateur reccuperer
     */

    public Optional<Utilisateur> getUtilisateurById(Long id){
        return Optional.ofNullable(utilisateurRepository.findById(id).orElse(null));
    }

    /**
     *
     * @param utilisateur utilisateur a enregistrer
     * @return l utilisateur qui a ete enregistrer est retourne
     */
    public  Utilisateur updateUtilisateur(Utilisateur utilisateur){
        return utilisateurRepository.save(utilisateur);
    }

    public void deleteUtilisateur(long id){
        utilisateurRepository.deleteById(id);
    }

    public List<Utilisateur> getAllUtilisateur(){
    return utilisateurs = utilisateurRepository.findAll();
    }


}
