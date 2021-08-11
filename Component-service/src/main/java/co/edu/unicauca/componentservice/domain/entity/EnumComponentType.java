/**
 * The value of the components's type could be changed along the time, that's the reason to use
 * an enumeration.According with the first requirements version, a component could START,
 * MAIN_COURSE, PROTEIN OR DRINK.
 */
package co.edu.unicauca.componentservice.domain.entity;

/**
 * @author Juan David Muñoz Pasquel - <jdamupasquel@unicauca.edu.co>
 */
public enum EnumComponentType {
	START, MAIN_COURSE, PROTEIN, DRINK
}
