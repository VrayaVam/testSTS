package mx.com.vrayax.rh.mvc.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Vacancy {

	private Integer vacancyId;
	private String title;
	private String description;
	private LocalDateTime publicationDate;
	private Double salary;
	private Integer highlight;
	private String image = "no-image.jpg";

	public Vacancy() {
		// TODO Auto-generated constructor stub
	}


	public Vacancy(Integer vacancyId, String title, String description, LocalDateTime publicationDate, Double salary,
			Integer highlight, String image) {
		this.vacancyId = vacancyId;
		this.title = title;
		this.description = description;
		this.publicationDate = publicationDate;
		this.salary = salary;
		this.highlight = highlight;
		this.image = image;
	}


	public Integer getVacancyId() {
		return vacancyId;
	}

	public void setVacancyId(Integer vacancyId) {
		this.vacancyId = vacancyId;
	}

	public String getTitle() {
		return title;
	}

	public void seTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(LocalDateTime publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Integer getHighlight() {
		return highlight;
	}

	public void setHighlight(Integer highlight) {
		this.highlight = highlight;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Vacancy [vacancyId=" + vacancyId + ", title=" + title + ", description=" + description
				+ ", publicationDate=" + publicationDate + ", salary=" + salary + ", highlight=" + highlight
				+ ", image=" + image + "]";
	}

	
}
