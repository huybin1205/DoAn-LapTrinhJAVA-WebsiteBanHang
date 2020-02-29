/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import java.util.regex.Pattern;

/**
 *
 * @author HuyBin
 */
public class Validator {
    private Pattern pattern;
    
    public Validator(String regex){
        pattern = Pattern.compile(regex);
    }
    
    public Validator(){
        
    }
    
    public boolean validate(String validate){
        return pattern.matcher(validate).matches();
    }
    
    public static void main(String[] args){
//        String regex = constants.ValidatorString.USERNAME_PATTERN;
//        Validator validator = new Validator(regex);
//        System.out.println(validator.validate("oxus20"));
    }
}
