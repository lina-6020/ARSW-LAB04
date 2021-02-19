package edu.eci.arsw.aplicacion;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;

public class Main {

	public static void main(String[] args) throws BlueprintPersistenceException, BlueprintNotFoundException {

		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		BlueprintsServices serv = ac.getBean(BlueprintsServices.class);
		//ejemplo1
		//- Agregar
		Point[] pts0 = new Point[] { new Point(400, 400), new Point(15, 15) , new Point(15, 15) , new Point(15, 15) };
		Blueprint bp0 = new Blueprint("mack", "mypaint", pts0);
		serv.addNewBlueprint(bp0);
		System.out.println(serv.addBlueprintWithFiltreR(bp0).getPoints());
		
		//- Traer Plano
		System.out.println(serv.getBlueprint("mack", "mypaint"));
		//Traer Plano por Autor
		Point[] pts1 = new Point[] { new Point(12, 30), new Point(15, 15) };
		Blueprint bp1 = new Blueprint("mack", "plano2", pts1);
		serv.addNewBlueprint(bp1);
		System.out.println(serv.getBlueprintsByAuthor("mack"));
	}

}
