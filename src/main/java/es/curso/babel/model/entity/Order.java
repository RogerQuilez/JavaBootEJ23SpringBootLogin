package es.curso.babel.model.entity;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Usuario usuario;
	
	@ManyToMany(cascade = CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Videojuego> videojuegos = new LinkedList<Videojuego>();
	private Date date;
	
	public int getRef() {
		return id;
	}
	
	public void setRef(int id) {
		this.id = id;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Videojuego> getVideojuegos() {
		return videojuegos;
	}
	
	public void setVideojuegos(List<Videojuego> videojuegos) {
		this.videojuegos = videojuegos;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", usuario=" + usuario + ", videojuegos=" + videojuegos + ", date=" + date + "]";
	}	
	
	public double calcularTotal() {
		double total = 0;
		for (Videojuego v: this.videojuegos) {
			total += v.getPrice();
		}
		return total;
	}
	
}
