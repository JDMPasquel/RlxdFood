package co.edu.unicauca.userservice.utilities;

import java.util.Calendar;

public class AgeCalculator {
    public static int calculator(Calendar birthDate){
        Calendar rigthNow = Calendar.getInstance();
        int yearNow = rigthNow.get(Calendar.YEAR);
        int yearBirthDate = birthDate.get(Calendar.YEAR);
        return yearNow - yearBirthDate;
    }
}
