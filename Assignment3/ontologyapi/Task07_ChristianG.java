package ontologyapi;

//Christian Guaman Cocha
import java.io.InputStream;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.ontology.OntResource;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;

/**
 * Task 07: Querying ontologies (RDFs)
 * @author elozano
 *
 */
public class Task07
{
	public static String ns = "http://somewhere#";
	
	public static void main(String args[])
	{
		String filename = "example6.rdf";
		
		// Create an empty model
		OntModel model = ModelFactory.createOntologyModel(OntModelSpec.RDFS_MEM);
		
		// Use the FileManager to find the input file
		InputStream in = FileManager.get().open(filename);
	
		if (in == null)
			throw new IllegalArgumentException("File: "+filename+" not found");
	
		// Read the RDF/XML file
		model.read(in, null);
		
		
		// ** TASK 7.1: List all individuals of "Person" **
		System.out.println("******Task 7.1*******");
		
		OntClass person = model.getOntClass(ns+"Person");
		ExtendedIterator< ? extends OntResource> it=person.listInstances();
		while(it.hasNext()){
			
			Individual aux=(Individual)it.next();
			System.out.println("Individuo: "+aux.getLocalName());
		}
		// ** TASK 7.2: List all subclasses of "Person" **
		System.out.println("******Task 7.2*******");
		
		ExtendedIterator< ? extends OntResource> it2= person.listSubClasses();
		while(it2.hasNext()){
			
		OntClass subclass= (OntClass)it2.next();
		System.out.println("Subclass: "+ subclass+" => "+subclass.getLocalName() );
		}
		
		
		// ** TASK 7.3: Make the necessary changes to get as well indirect instances and subclasses. TIP: you need some inference... **
		System.out.println("****Task 7.3********");
		
	
	}
}
