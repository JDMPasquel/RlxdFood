/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.rlxdfood.client.domain.entity;

/**
 *
 * @author ASUS
 */
public class Component {
    private Long id;
    
    private String name;
    
    private EnumComponentType type;

    public Component() {}

    public Component(String name, EnumComponentType type) {
        this.name = name;
        this.type = type;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnumComponentType getType() {
        return type;
    }

    public void setType(EnumComponentType type) {
        this.type = type;
    }
}
