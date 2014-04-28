package fr.treeptik;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.treeptik.model.Animal;
import fr.treeptik.model.Personne;
import fr.treeptik.service.PersonneService;
import fr.treeptik.service.ServiceException;

public class Runtime {

	public static void main(String[] args) throws ServiceException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonneService personneService = context.getBean(PersonneService.class);
		
//		Personne personne = new Personne();
//		personne.setNom("Toto");
//		personne.setPrenom("tutu");
//		personne.setDateNaissance(new Date());
//		
//		Animal animal = new Animal();
//		animal.setNom("Rex");
//		personne.setAnimal(animal);	
//		
//		personneService.save(personne);
		
//		Personne personne = personneService.findById(4);
//		System.out.println(personne);
//		personneService.remove(personne);
		
//		Personne personne = new Personne();
//		personne.setNom("Haddock");
//		personne.setPrenom("Captain");
//		List<Animal> lesAnimaux = new ArrayList<>();
//		
//		Animal a =new Animal();
////		a.setNom("Perroquet");
//		Animal b =new Animal();
////		a.setNom("Crabe");
//		
//		lesAnimaux.add(a);
//		lesAnimaux.add(b);
//		personne.setLesAnimaux(lesAnimaux);
//		
//		personneService.save(personne);
		
		Personne personne = personneService.findById(9);
		Animal animal = new Animal();
		animal.setNom("Choupette");
		List<Animal> lesAnimaux = new ArrayList<>();
		lesAnimaux.add(animal);
		personne.setLesAnimaux(lesAnimaux);
		
		personneService.update(personne);
		
		
		
		context.close();
		
	}

}
