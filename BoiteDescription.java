import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.InputStream;
import java.io.InputStreamReader;
import MG2D.geometrie.Texture;	
import MG2D.Couleur;
import MG2D.geometrie.Point;
import MG2D.geometrie.Rectangle;
import MG2D.geometrie.Texte;
import java.io.IOException;


/**
 * Gère l'affichage des informations textuelles d'un jeu sélectionné dans le menu.
 * Cela inclut le résumé du jeu, la configuration des contrôles (joystick et boutons),
 * ainsi que l'affichage du top 10 des meilleurs scores.
 */
public class BoiteDescription extends Boite{
    private static final int MAX_DESC_LINES = 10;
    private static final int MAX_DESC_CHARS_PER_LINE = 52;
    private static final int MAX_CONTROL_CHARS = 14;
    private static final int MAX_HIGHSCORE_CHARS = 30;
    private static final String TEXTE_CONTROLE_DEFAUT = "...";

    private Texte[] message;
    private boolean stop;
    private int nombreLigne;
    private Texture joystick;
    private Texture[] bouton;
    private Texte tJoystick;
    private Texte[] tBouton;
    private String[] texteBouton;
    private Texte highscore;
    private Texte[] listeHighScore;
    private final Map<String, List<String>> cacheDescriptions = new HashMap<String, List<String>>();
    private final Map<String, String[]> cacheControles = new HashMap<String, String[]>();
	
	/*HACKED BY BENDAL*/
	private Font font1 = null;
	private Font font2 = null;
	private Font font3 = null;
	private Font font4 = null;
	/****************/
	
	
	
    BoiteDescription(Rectangle rectangle) {
	super(rectangle);
	
	/*HACKED BY BENDAL*/
	try{
	    Font font = null;
		Font fontTexte = null;
		File in = new File("fonts/PrStart.ttf");
		font = Font.createFont(Font.TRUETYPE_FONT, in);
		in = new File("fonts/Volter__28Goldfish_29.ttf");
		fontTexte = Font.createFont(Font.TRUETYPE_FONT, in);
	    font1 = fontTexte.deriveFont(15.0f);
		font2 = fontTexte.deriveFont(20.0f);
		font3 = font.deriveFont(25.0f);
		font4 = font.deriveFont(14.0f);
	}catch (Exception e) {
	    System.err.println(e.getMessage());
	    font1 = new Font("SansSerif", Font.PLAIN, 15);
	    font2 = new Font("SansSerif", Font.PLAIN, 20);
	    font3 = new Font("SansSerif", Font.PLAIN, 25);
	    font4 = new Font("SansSerif", Font.PLAIN, 14);
	}
	/****************/
	
	bouton = new Texture[6];
	tBouton = new Texte[6];
	texteBouton = new String[7];
		
	//declaration des texture bouton + joystick
	this.joystick = new Texture("img/joystick2.png", new Point(740, 100), 40,40);
	for(int i = 0 ; i < 3 ; i++){
	    this.bouton[i] = new Texture("img/ibouton2.png", new Point(890+130*i, 130), 40, 40);
	}
	for(int i = 3 ; i < 6 ; i++){
	    this.bouton[i] = new Texture("img/ibouton2.png", new Point(890+130*(i-3), 50), 40, 40);
	}
	
	//declaration des textes bouton + joystick
	this.tJoystick = new Texte(Couleur .NOIR, "...", font1, new Point(760, 80));
	for(int i = 0 ; i < 3 ; i++){
	    this.tBouton[i] = new Texte(Couleur .NOIR, "...", font1, new Point(910+130*i, 120));
	}
	for(int i = 3 ; i < 6 ; i++){
	    this.tBouton[i] = new Texte(Couleur .NOIR, "...", font1, new Point(910+130*(i-3), 40));
	}
	stop = false;
	message = new Texte[MAX_DESC_LINES];
	for(int i = 0 ; i < message.length ; i++){
	    message[i] = new Texte(Couleur .NOIR, "", font2, new Point(960, 590));
	    message[i].translater(0, -i*30);

	}
	nombreLigne = 0;

	highscore = new Texte(Couleur.NOIR, "HIGHSCORE", font3, new Point(960, 335));
	listeHighScore = new Texte[10];
	for(int i=0;i<5;i++){
	    listeHighScore[i] = new Texte(Couleur.NOIR, "", font4, new Point(820,310));
	    listeHighScore[i].translater(0,-i*25);
	}
	for(int i=5;i<10;i++){
	    listeHighScore[i] = new Texte(Couleur.NOIR, "", font4, new Point(1100,310));
	    listeHighScore[i].translater(0,-(i-5)*25);
	}
	
	
	/*
	//declaration des textes bouton + joystick
	this.tJoystick = new Texte(Couleur .NOIR, "...", new Font("Calibri", Font.TYPE1_FONT, 15), new Point(760, 80));
	for(int i = 0 ; i < 3 ; i++){
	    this.tBouton[i] = new Texte(Couleur .NOIR, "...", new Font("Calibri", Font.TYPE1_FONT, 15), new Point(910+130*i, 120));
	}
	for(int i = 3 ; i < 6 ; i++){
	    this.tBouton[i] = new Texte(Couleur .NOIR, "...", new Font("Calibri", Font.TYPE1_FONT, 15), new Point(910+130*(i-3), 40));
	}
	stop = false;
	message = new Texte[10];
	for(int i = 0 ; i < message.length ; i++){
	    message[i] = new Texte(Couleur .NOIR, "", new Font("Calibri", Font.TYPE1_FONT, 20), new Point(960, 590));
	    message[i].translater(0, -i*30);

	}
	nombreLigne = 0;

	highscore = new Texte(Couleur.NOIR, "HIGHSCORE", new Font("Calibri", Font.TYPE1_FONT, 25), new Point(960, 335));
	listeHighScore = new Texte[10];
	for(int i=0;i<5;i++){
	    listeHighScore[i] = new Texte(Couleur.NOIR, "", new Font("Calibri", Font.TYPE1_FONT, 17), new Point(820,310));
	    listeHighScore[i].translater(0,-i*25);
	}
	for(int i=5;i<10;i++){
	    listeHighScore[i] = new Texte(Couleur.NOIR, "", new Font("Calibri", Font.TYPE1_FONT, 17), new Point(1100,310));
	    listeHighScore[i].translater(0,-(i-5)*25);
	}*/

    }
	/**
     * Lit le fichier de description (description.txt) du jeu spécifié et met à jour l'affichage.
     * Le fichier est lu jusqu'à un maximum de 10 lignes.
     * @param path Le chemin d'accès vers le dossier du jeu.
     */
    public void lireFichier(String path){
	List<String> lignesAffichees = cacheDescriptions.get(path);
	if(lignesAffichees == null){
	    lignesAffichees = new ArrayList<String>();
	    String fichier =path+"/description.txt";
	    try{
		InputStream ips=new FileInputStream(fichier); 
		InputStreamReader ipsr=new InputStreamReader(ips);
		BufferedReader br=new BufferedReader(ipsr);
		String ligne;
		while ((ligne = br.readLine()) != null && lignesAffichees.size() < MAX_DESC_LINES){
		    for(String ligneDecoupee : decouperLigne(ligne, MAX_DESC_CHARS_PER_LINE)){
			lignesAffichees.add(ligneDecoupee);
			if(lignesAffichees.size() >= MAX_DESC_LINES){
			    break;
			}
		    }
		}
		br.close(); 
	    }		
	    catch (Exception e){
		System.err.println(e.toString());
	    }
	    cacheDescriptions.put(path, new ArrayList<String>(lignesAffichees));
	}
	appliquerDescription(lignesAffichees);
    }

	/**
     * Lit le fichier des meilleurs scores (highscore) du jeu spécifié.
     * Si le fichier n'existe pas, affiche des tirets par défaut.
     * @param path Le chemin d'accès vers le dossier du jeu.
     */
    public void lireHighScore(String path){
	
        for(int i=0;i<10;i++){
	    if(i==0)
		listeHighScore[i].setTexte("1er - ");
	    else
		listeHighScore[i].setTexte((i+1)+"eme - ");
	}
	
	String fichier =path+"/highscore";
	
	File f = new File(fichier);
	if(!f.exists()){
	    for(int i=0;i<10;i++)
		listeHighScore[i].setTexte("/");
	}else{
	    ArrayList<LigneHighScore> liste = HighScore.lireFichier(fichier);
	    for(int i=0;i<liste.size();i++){
		if(i==0)
		    listeHighScore[i].setTexte(raccourcirTexte("1er : "+liste.get(i).getNom()+" - "+liste.get(i).getScore(), MAX_HIGHSCORE_CHARS));
		else
		    listeHighScore[i].setTexte(raccourcirTexte((i+1)+"eme : "+liste.get(i).getNom()+" -  "+liste.get(i).getScore(), MAX_HIGHSCORE_CHARS));
	    }
	}
    }

	/**
     * Lit le fichier de configuration des contrôles (bouton.txt) du jeu spécifié.
     * Parse une ligne séparée par des ":" pour assigner les actions aux boutons.
     * @param path Le chemin d'accès vers le dossier du jeu.
     */
    public void lireBouton(String path){
	String[] controles = cacheControles.get(path);
	if(controles != null){
	    appliquerControles(controles);
	    return;
	}

	controles = controlesParDefaut();
	String fichier =path+"/bouton.txt";
	File f = new File(fichier);
	if(f.isFile()){
	    try{
		InputStream ips=new FileInputStream(fichier); 
		InputStreamReader ipsr=new InputStreamReader(ips);
		BufferedReader br=new BufferedReader(ipsr);
		String ligne = br.readLine();
		br.close();
		if(ligne != null){
		    texteBouton = ligne.split(":");
		    if(texteBouton.length >= 7){
			controles = new String[7];
			for(int i = 0 ; i < 7 ; i++){
			    controles[i] = texteBouton[i];
			}
		    }
		}
	    }catch(Exception e){System.err.println(e);};
	}

	cacheControles.put(path, controles);
	appliquerControles(controles);
    }

    private void appliquerDescription(List<String> lignesAffichees){
	for(int i = 0 ; i < MAX_DESC_LINES ; i++){
	    if(i < lignesAffichees.size()){
		setMessage(lignesAffichees.get(i), i);
	    }else{
		setMessage("", i);
	    }
	}
    }

    private String[] controlesParDefaut(){
	String[] defaut = new String[7];
	for(int i = 0 ; i < 7 ; i++){
	    defaut[i] = TEXTE_CONTROLE_DEFAUT;
	}
	return defaut;
    }

    private void appliquerControles(String[] controles){
	if(controles == null || controles.length < 7){
	    controles = controlesParDefaut();
	}
	settJoystick(controles[0]);
	for(int i = 0 ; i < 6 ; i++){
	    settBouton(controles[i+1], i);
	}
    }
	
    public Texte[] getMessage(){
	return message;
    }
	
    public void setMessage(String message, int a) {
	this.message[a].setTexte(message);	
    }
	
    public Texture[] getBouton(){
	return this.bouton;
    }
	
    public Texture getJoystick(){
	return this.joystick;
    }
	
    public Texte[] gettBouton(){
	return this.tBouton;
    }
	
    public Texte gettJoystick(){
	return this.tJoystick;
    }

    public Texte getHighscore(){
	return this.highscore;
    }

    public Texte[] getListeHighScore(){
	return this.listeHighScore;
    }

	
    public void settJoystick(String s){
	this.tJoystick.setTexte(raccourcirTexte(s, MAX_CONTROL_CHARS));		
    }
	
    public void settBouton(String s, int a){
	this.tBouton[a].setTexte(raccourcirTexte(s, MAX_CONTROL_CHARS));		
    }

    private static String raccourcirTexte(String texte, int limite){
	if(texte == null){
	    return "";
	}
	String propre = texte.trim();
	if(propre.length() <= limite){
	    return propre;
	}
	if(limite <= 3){
	    return propre.substring(0, limite);
	}
	return propre.substring(0, limite - 3) + "...";
    }

    private static List<String> decouperLigne(String ligne, int maxChars){
	List<String> lignes = new ArrayList<String>();
	if(ligne == null){
	    lignes.add("");
	    return lignes;
	}
	String contenu = ligne.trim();
	if(contenu.isEmpty()){
	    lignes.add("");
	    return lignes;
	}

	String[] mots = contenu.split("\\s+");
	StringBuilder courant = new StringBuilder();
	for(String mot : mots){
	    if(courant.length() == 0){
		if(mot.length() <= maxChars){
		    courant.append(mot);
		}else{
		    lignes.add(raccourcirTexte(mot, maxChars));
		}
		continue;
	    }

	    if(courant.length() + 1 + mot.length() <= maxChars){
		courant.append(" ").append(mot);
	    }else{
		lignes.add(courant.toString());
		courant = new StringBuilder();
		if(mot.length() <= maxChars){
		    courant.append(mot);
		}else{
		    lignes.add(raccourcirTexte(mot, maxChars));
		}
	    }
	}
	if(courant.length() > 0){
	    lignes.add(courant.toString());
	}
	return lignes;
    }
	
    /*public Texte getMessage() {
      return message;
      }
    */
	

}
