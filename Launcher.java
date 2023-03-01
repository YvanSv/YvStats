import yvstats.Controleur;
import yvstats.utils.Identifiant;
import yvstats.utils.Lecteur;
import yvstats.utils.Polices;
import yvstats.utils.Sauvegarde;

public class Launcher {
    public static void main(String[] args) {
        Lecteur.creerLecteur();
        Identifiant.creerIdentifiant();
        Polices.creerPolices();
        Controleur ctrl = new Controleur();
        Sauvegarde.charger(ctrl);

        System.out.println("\n\n\nBienvenue sur YvStats !\n\n");

        if (args.length < 1) {
            int choix = 0;
            do {
                choix = 2;
                // System.out.print("Entrez [1] pour entrer en mode TUI;\nEntrez [2] pour entrer en mode GUI;\nChoix : ");
                // try { choix = Integer.parseInt(Lecteur.lire()); }
                // catch (Exception e) { choix = 1; }
            } while(choix < 1 || choix > 2);
            ctrl.lancer(choix);
        }
        else {
            ctrl.lancer(Integer.parseInt(args[0]));
        }
        // Artiste yv = new Artiste("Yvan");
        // Album a1 = new Album("Album N°1", yv, null);
        // a1.ajouterMusiques(new Musique("Rap dur"));
        // a1.ajouterMusiques(new Musique("Rap mou"));
        // yv.ajouterAlbum(a1);
        // yv.setClassementOjd(1);

        Lecteur.fermer();
    }
}
