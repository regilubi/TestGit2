/**
 * 
 */
package projetwebone.objet.metier;

import java.util.ArrayList;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



/**
 * @author 8510502w
 *
 */
public class Personne {

	private int _id;
	private String _nom;
	private String _prenom;
	private String _datenaissance;
	
	private ArrayList<Personne> listpersonne = new ArrayList<Personne>();	
	
	
	public Personne(){
		super();	
		RecuperationinfoXML();
		/*
		listpersonne.add(new Personne("nom1","prenom1", "01/05/12"));
		listpersonne.add(new Personne("nom2","prenom2", "01/05/12"));
		listpersonne.add(new Personne("nom3","prenom3", "01/05/12"));
		listpersonne.add(new Personne("nom4","prenom4", "01/05/12"));	*/
		//this.listpersonne.add(new Personne("nom5","prenom5", "01/05/12"));			
		
	}

	/**
	 * @param _nom
	 * @param _prenom
	 * @param _datenaissance
	 */
	public Personne(String _nom, String _prenom, String _datenaissance) {
		super();
		this._nom = _nom;
		this._prenom = _prenom;
		this._datenaissance = _datenaissance;
	}

	/**
	 * @return the _id
	 */
	public int get_id() {
		return _id;
	}

	/**
	 * @param _id the _id to set
	 */
	public void set_id(int _id) {
		this._id = _id;
	}

	/**
	 * @return the _nom
	 */
	public String get_nom() {
		return _nom;
	}

	/**
	 * @param _nom the _nom to set
	 */
	public void set_nom(String _nom) {
		this._nom = _nom;
	}

	/**
	 * @return the _prenom
	 */
	public String get_prenom() {
		return _prenom;
	}

	/**
	 * @param _prenom the _prenom to set
	 */
	public void set_prenom(String _prenom) {
		this._prenom = _prenom;
	}

	/**
	 * @return the _datenaissance
	 */
	public String get_datenaissance() {
		return _datenaissance;
	}

	/**
	 * @param _datenaissance the _datenaissance to set
	 */
	public void set_datenaissance(String _datenaissance) {
		this._datenaissance = _datenaissance;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Personne [_id=" + _id + ", _nom=" + _nom + ", _prenom="
				+ _prenom + ", _datenaissance=" + _datenaissance + "]";
	}

	/**
	 * @return the listpersonne
	 */
	public ArrayList<Personne> getListpersonne() {
		return listpersonne;
	}

	/**
	 * @param listpersonne the listpersonne to set
	 */
	public void setListpersonne(ArrayList<Personne> listpersonne) {
		this.listpersonne = listpersonne;
	}
	
	public void RecuperationinfoXML(){
		/*
		 * Etape 1: récupération d'une instance de la classe "DocumentBuilderFactory"
		 */
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try{
			/*
			 * Etape 2: création d'un parseur
			 */
			final DocumentBuilder builder = factory.newDocumentBuilder();
			
			/*
			 * Etape 3: création d'un document
			 */
			final Document document = builder.parse(new File("C:\\Documents and Settings\\8510502w\\Bureau\\My_Workspace_SNCF\\WorkSpace_eclipse_KEPLER\\ProjetWebOne\\personne.xml"));
			//Affiche du prologue 
			/*
	        System.out.println("*************PROLOGUE************");
	        System.out.println("version : " + document.getXmlVersion());
	        System.out.println("encodage : " + document.getXmlEncoding());      
	        System.out.println("standalone : " + document.getXmlStandalone());*/
	                    
	        /*
	         * Etape 4 : récupération de l'Element racine
	         */
	        final Element racine = document.getDocumentElement();
	        
	        //Affichage de l'élément racine
	        /*
	        System.out.println("\n*************RACINE************");
	        System.out.println(racine.getNodeName());
	        */
	        
	        /*
	         * Etape 5 : récupération des personnes
	         */
	        final NodeList racineNoeuds = racine.getChildNodes();
	        final int nbRacineNoeuds = racineNoeuds.getLength();
	            
	        for (int i = 0; i<nbRacineNoeuds; i++) {
	            if(racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
	                final Element personne = (Element) racineNoeuds.item(i);
	                
	            //Affichage d'une personne
	            //System.out.println("\n*************PERSONNE************");
	            //System.out.println("sexe : " + personne.getAttribute("sexe"));
	            
	                /*
	             * Etape 6 : récupération du nom et du prénom
	             */
	            final Element nom = (Element) personne.getElementsByTagName("nom").item(0);
	            final Element prenom = (Element) personne.getElementsByTagName("prenom").item(0);
	            final Element date = (Element) personne.getElementsByTagName("date").item(0);
	                    
	            //Affichage du nom et du prénom
	            /*
	            System.out.println("nom : " + nom.getTextContent());
	            System.out.println("prénom : " + prenom.getTextContent());
	            System.out.println("date : " + date.getTextContent());
	            */
	                    
	           this.getListpersonne().add(new Personne(nom.getTextContent(), prenom.getTextContent(), date.getTextContent()));
	            }               
	        }           
	        }
	        catch (final ParserConfigurationException e) {
	            e.printStackTrace();
	        }
	        catch (final SAXException e) {
	            e.printStackTrace();
	        }
	        catch (final IOException e) {
	            e.printStackTrace();
	        }  	
		
	}
	
	
}//fin de la classe
