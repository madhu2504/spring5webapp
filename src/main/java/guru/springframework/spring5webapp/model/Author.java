package guru.springframework.spring5webapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String firstname;
	private String lastname;
	
	@ManyToMany(mappedBy = "authors")
	private Set<Book> books = new HashSet<Book>();

	public Author() {
		
	}
	
	public Author(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", books=" + books + "]";
	}
	
	
	
}
