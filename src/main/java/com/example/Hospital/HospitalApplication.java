package com.example.Hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

	public class TestBCrypt {
		public static void main(String[] args) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			System.out.println(encoder.encode("parola_ta")); // schimbă "parola_ta" cu parola dorită
		}
	}
}




















		// proiectul de spring se imparte in 4 :
		// Entity - 1:1 cu baza de date;
		// Repository -modul de a te conecta la baza de date;
		// Service - logica de bussiness;
		// Controller - end-point-urile( toate url-urile )
		//In controller avem 6 verbe http(GET-ia date, PUT-modifica, POST-insert, DELETE, PATCH)
		//avem nevoie si de postman//(se testeaza end-pointurile)

		// medic, pacient, asistente, tratament, sectie, reteta;
		//@Entity,@Table(defaultName = "medic"),fiecare clasa sa aiba cate o cheie primara(long),@ColumnName("nume_culoana)
		//@Data -> folsoesti lombok pentru a genera getter,setter,equals(),haschode()
		//repository -> interfete MedicRepository,AssitenteRepository fiecare interfata va extinde JpaRepository<Medic,Long>
		//fiecare interfata de repository sa aiba anotarea @Repository

		//service fiecare clasa java de serviciu trebuie sa aiba anotarea @Service:clasele vor fi numite:MedicServiceImpl
		// aici o sa injectam un repository pentru a avea acces la baza de date
		//a injecta inseamna a crea o instanta dar nu o mai crem noi cu operatorul new o creaza containerul spring pt noi folosind anotarea @Autowired
		// sunt 3 tipuri de a injecta o dependinta: prin field,prin constructor,prin setter
		//cea mai buna este prin constructor!!!
		//in serviciu se va face toata logica a aplicatiei


		//controller -> aici creem enpointurile de unde vor fi accesate prin URL
		//in controller injectam un serviciu pe care l-am facut pentru a avea acces la logica aplicatiei
		//controllerul trebuie pastrat cat mai curat ,toata logica trebuie sa existe in serviciu, nu in controller
		//numesti clasele de controller MedicController,AsistentaController
		//fiecare clasa de controller de mai sus va avea anotarea @RestController
		//dupa accesarea controllerului se va intoarce cate un json in functie de verbul folosit de http(get,post,delete,put)





