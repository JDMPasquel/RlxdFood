/**
 * According the first requeriments version, there are two lunch dishes options-> The executive
 * dish and the Dish of the Menu. An executive lunch could have one or more components and the
 * components could be: START, MAIN_COURSE, PROTEIN, DRINK. This class describe the component of
 * an executive lunch.
 */
package co.edu.unicauca.componentservice.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Juan David Muñoz Pasquel - <jdamupasquel@unicauca.edu.co>
 */

@Entity
@Table(name = "components")
public class Component implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * The id is unique for each component, is the primary identifier and the Data Base will be
	 * assign it,with the not repetition problem avoid, for that the
	 * IDENTITY strategy is used.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100, nullable = false)
	private String name;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private EnumComponentType type;

	/**
	 * The constructors are created to test package.
	 */
	public Component() {}

	public Component(String name, EnumComponentType type) {
		this.name = name;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Component [id=" + id + ", name=" + name + ", type=" + type + "]";
	}

	/**
	 * A specific way to do compare components
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Component other = (Component) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 * @see EnumComponentType
	 */
	public EnumComponentType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 * @see EnumComponentType
	 */
	public void setType(EnumComponentType type) {
		this.type = type;
	}
}
