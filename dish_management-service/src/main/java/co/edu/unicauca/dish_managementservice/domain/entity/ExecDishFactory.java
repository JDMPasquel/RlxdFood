package co.edu.unicauca.dish_managementservice.domain.entity;

public class ExecDishFactory implements IDishFactory{

    @Override
    public Object createDish() {
        return new ExecutiveDish();
    }
    
}
