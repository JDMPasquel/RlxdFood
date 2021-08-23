package co.edu.unicauca.userservice.utilities;

import java.util.Calendar;

public class AgeValidator {
    public static boolean greaterThanAge(Calendar birthDate, int legalAgeAdult){
        return AgeCalculator.calculator(birthDate) > legalAgeAdult;
    }
}
