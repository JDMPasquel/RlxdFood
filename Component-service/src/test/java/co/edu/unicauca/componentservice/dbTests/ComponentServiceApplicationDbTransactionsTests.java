package co.edu.unicauca.componentservice.dbTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import co.edu.unicauca.componentservice.controller.ComponentController;
import co.edu.unicauca.componentservice.domain.entity.Component;
import co.edu.unicauca.componentservice.domain.entity.EnumComponentType;

@SpringBootTest
public class ComponentServiceApplicationDbTransactionsTests {

    @Autowired
    private ComponentController controller;

    @Test
    void create_Delete() throws Exception{
        //Unexisting component
        Component newTmpComponent = new Component("Some component", EnumComponentType.DRINK);
        assertThat(controller).isNotNull();
        assertThat(newTmpComponent).isNotNull();
        assertEquals(HttpStatus.CREATED, controller.create(newTmpComponent).getStatusCode());
        //Existing component
        //The api wont leave to created the component because is existing already.
        Component newTmComponent2 = new Component("Some component", EnumComponentType.DRINK);
        assertEquals(HttpStatus.ALREADY_REPORTED, controller.create(newTmComponent2).getStatusCode());
        //The component created by test must be deleted
        Long id = newTmpComponent.getId();
        controller.delete(id);
    }

    @Test
    void update() throws Exception{
        Component newTmpComponent = new Component("Som compnent", EnumComponentType.DRINK);
        Component updtComponent = new Component("Some component", EnumComponentType.DRINK);
        assertEquals(HttpStatus.CREATED, controller.create(newTmpComponent).getStatusCode());
        assertThat(controller.update(newTmpComponent.getId(), updtComponent).getStatusCode()).isEqualTo(HttpStatus.CREATED);
        //The component created by test must be deleted
        Long id = newTmpComponent.getId();
        controller.delete(id);
    }

    @Test
    void updateUnexistingComponent() throws Exception{
        Component updtComponent = new Component("Some component", EnumComponentType.DRINK);
        controller.create(updtComponent);
        assertEquals(HttpStatus.NOT_FOUND, controller.update(Long.parseLong("980"), updtComponent).getStatusCode());
        //The component created by test must be deleted
        Long id = updtComponent.getId();
        controller.delete(id);
    }

    @Test
    void deleteUnexistingComponent(){
        assertEquals(HttpStatus.NOT_FOUND, controller.delete(Long.parseLong("1000")).getStatusCode());
    }
}
