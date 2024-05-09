package org.devweb.onlineeditor.forms;

import jakarta.servlet.http.HttpServletRequest;
import org.devweb.onlineeditor.models.user.Utilisateur;

import java.util.HashMap;
import java.util.Map;

public class ConnexionForm {
    private static final String CHAMP_EMAIL  = "email";
    private static final String CHAMP_PASS   = "motdepasse";

    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Utilisateur connecterUtilisateur(HttpServletRequest request ) {
        /* Récupération des champs du formulaire */
        String email = getValeurChamp(request, CHAMP_EMAIL);
        String motDePasse = getValeurChamp(request, CHAMP_PASS);

        Utilisateur utilisateur = new Utilisateur();

        /* Validation du champ email. */
        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            setErreur(CHAMP_EMAIL, "Merci de saisir une adresse mail valide." );
        }else {
            utilisateur.setMail(email);
        }

        /* Validation du champ mot de passe. */
        if ( motDePasse != null ) {
            if ( motDePasse.length() < 3 ) {
                setErreur(CHAMP_PASS, "Le mot de passe doit contenir au moins 3 caractères." );
            }else {
                utilisateur.setPwd(motDePasse);
            }
        } else {
            setErreur(CHAMP_PASS, "Merci de saisir votre mot de passe." );
        }

        /* Initialisation du résultat global de la validation. */
        if (erreurs.isEmpty()) {
            resultat = "Succès de la connexion.";
        } else {
            resultat = "Échec de la connexion.";
        }

        return utilisateur;
    }

    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }

private void setErreur( String champ, String message ) {
    erreurs.put( champ, message );
}
}
