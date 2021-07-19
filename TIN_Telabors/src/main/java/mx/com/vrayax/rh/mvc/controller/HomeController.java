package mx.com.vrayax.rh.mvc.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import mx.com.vrayax.rh.mvc.model.Vacancy;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String showHome(Model model){
		model.addAttribute("mensaje","Bienvenidos a Telebors Mex App");
		/*List<String> myList= new ArrayList<>();
		myList.add("CDMX");
		myList.add("GDL");
		myList.add("MTY");
		model.addAllAttributes(myList);
		model.addAttribute("fecha", new Date());*/
		
		String title="Auxiliar de contabilidad";
		//LocalDateTime pubDate= new Date();
		double salary= 9000.0;
		boolean beInForce=true;
		int positionNumber=2;
		model.addAttribute("home_currentDate", new Date());
		model.addAttribute("home_title", title);
		model.addAttribute("home_pubDate", LocalDateTime.of(2021, Month.MAY, 22, 12, 30));
		model.addAttribute("home_salary", salary);
		model.addAttribute("home_beInForce", beInForce);
		model.addAttribute("home_posNumber", positionNumber);
		return "v_home";//home.html
	}
	
	@GetMapping("/detail")
	public String showDetailVacancy(Model model){
		String str="2021-06-01 12:50";
		DateTimeFormatter formatter1= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime1=LocalDateTime.parse(str,formatter1);
		//DateTimeFormatter d=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		//LocalDateTime t=LocalDateTime.parse("20/05/2021",d);
		//System.out.println(t);
		System.out.println("--------------");
		
		// Parse a String in a custom date format to LocalDate using DateTimeFormatter
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date2 = LocalDate.parse("28/02/2020", dateFormatter);
        System.out.println(date2);
        
       // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dateTime = LocalDateTime.of(2021, Month.MAY, 8, 12, 30);
        String formattedDateTime = dateTime.format(formatter);
        System.out.println(dateTime.toString());
        System.out.println(formattedDateTime);
        		
       // String f=LocalDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        
		Vacancy vacancy= new Vacancy();
		vacancy.seTitle("Ingeniero de comunicaciones");
		vacancy.setDescription("Estamos solicitando ingeniero para dar soporte a intranet");
		vacancy.setPublicationDate(dateTime);
		vacancy.setSalary(9700.0);
		model.addAttribute("detail_vacancy",vacancy);
		model.addAttribute("detail_localDateTimeFormat", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		return "v_detail";
	}
	@GetMapping("/vacancies")
	public String showList(Model model){
		List<String> vacancies= new LinkedList<String>();
		vacancies.add("Ingeniero de Sistemas");
		vacancies.add("Auxiliar de contabilidad");
		vacancies.add("Vendedor");
		vacancies.add("Arquitecto");
		model.addAttribute("vList_vacancies", vacancies);
		return "v_vacancyList";
	}
	
	@GetMapping("/table")
	public String showTable(Model model){
		List<Vacancy> vacancies=getVacancies();
		model.addAttribute("table_vacancies",vacancies);
		return "v_table";
	}
	/**
	 * Método regresando una lista de objetos de tipo vacante
	 */
	private List<Vacancy> getVacancies(){
		List<Vacancy> vacancies= new LinkedList<Vacancy>();
		try{
			//Creamos la oferta de trabajo 1
			Vacancy vacancy1= new Vacancy();
			vacancy1.setVacancyId(1);
			vacancy1.seTitle("Ingeniero cívil");
			vacancy1.setDescription("Estamos solicitando Ing.Civil para diseñar puente peatonal");
			vacancy1.setPublicationDate(LocalDateTime.of(2021, 05, 12, 8, 20));
			vacancy1.setSalary(97000.0);
			vacancy1.setHighlight(1);
			vacancy1.setImage("enterprise1.jpg");
			
			//Creamos la oferta de trabajo 2
			Vacancy vacancy2= new Vacancy();
			vacancy2.setVacancyId(2);
			vacancy2.seTitle("Contador público");
			vacancy2.setDescription("Emprea importante esta solicitando contador con 5 años de experiencia y titulado.");
			vacancy2.setPublicationDate(LocalDateTime.of(2021, 05, 29, 8, 20));
			vacancy2.setSalary(9700.0);
			vacancy2.setHighlight(0);
			vacancy2.setImage("enterprise2.jpg");
			
			
			//Creamos la oferta de trabajo 3
			Vacancy vacancy3= new Vacancy();
			vacancy3.setVacancyId(3);
			vacancy3.seTitle("Ingeniero electronico");
			vacancy3.setDescription("Empresa internacional esta solicitando ingeniero mecanico para mantenimiento de la instalación electrica");
			vacancy3.setPublicationDate(LocalDateTime.of(2021, 06, 02, 8, 20));
			vacancy3.setSalary(9700.0);
			vacancy3.setHighlight(0);
			
			
			
			//Creamos la oferta de trabajo 4
			Vacancy vacancy4= new Vacancy();
			vacancy4.setVacancyId(4);
			vacancy4.seTitle("Diseñador grafico");
			vacancy4.setDescription("Estamos solicitando diseñador grafico titulado para diseñar publicidad de la empresa");
			vacancy4.setPublicationDate(LocalDateTime.of(2021, 05, 20, 8, 20));
			vacancy4.setSalary(15700.0);
			vacancy4.setHighlight(1);
			vacancy4.setImage("enterprise3.jpg");
			
			vacancies.add(vacancy1);
			vacancies.add(vacancy2);
			vacancies.add(vacancy3);
			vacancies.add(vacancy4);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return vacancies;
	}
	
	@GetMapping("/testing")
	public String test() {
		return "Test dentro del controller";
	}

}
