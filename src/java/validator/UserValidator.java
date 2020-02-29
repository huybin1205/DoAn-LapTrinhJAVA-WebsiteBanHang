/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import model.Users;

/**
 *
 * @author HuyBin
 */
public class UserValidator {

    private String regexUseraccount = constants.ValidatorString.ACCOUNT_PATTERN;
    private String regexPassword = constants.ValidatorString.PASSWORD_PATTERN;
    private String regexEmail = constants.ValidatorString.EMAIL_PATTERN;
    private String regexAddress = constants.ValidatorString.ADDRESS_PATTERN;
    private String regexPhonenumber = constants.ValidatorString.PHONENUMBER_PATTERN;
    private String regexUsername = constants.ValidatorString.FULL_NAME_PATTERN;

    // Library vadidate
    Validator validator = new Validator();

    public UserValidator() {
    }

    public boolean usernameValidate(String username) {
        validator = new Validator(regexUsername);
        return validator.validate(username);
    }

    public boolean accountValidate(String account) {
        validator = new Validator(regexUseraccount);
        return validator.validate(account);
    }

    public boolean passwordValidate(String password) {
        validator = new Validator(regexPassword);
        return validator.validate(password);
    }

    public boolean emailValidate(String email) {
        validator = new Validator(regexEmail);
        return validator.validate(email);
    }

    public boolean addressValidate(String address) {
        validator = new Validator(regexAddress);
        return validator.validate(address);
    }

    public boolean phonenumberValidate(String phonenumber) {
        validator = new Validator(regexPhonenumber);
        return validator.validate(phonenumber);
    }

    public String checkUserValidate(Users u) {
        String result = constants.Constants.NOTIFICATION_ERROR_VALIDATOR_USER;
        boolean account = this.accountValidate(u.getUserAccount());
        result += account ? "" : "Account\n";
        boolean username = this.usernameValidate(u.getUserName());
        result += username ? "" : "Fullname\n";
        boolean password = this.passwordValidate(u.getUserPassword());
        result += password ? "" : "Password\n";;
        boolean address = this.addressValidate(u.getUserAddress());
        result += address ? "" : "Address\n";
        boolean email = this.emailValidate(u.getUserEmail());
        result += email ? "" : "Email\n";
        boolean phonenumber = this.phonenumberValidate(u.getUserPhonenumber());
        result += phonenumber ? "" : "Phonenumber\n";
        
        if(result.compareTo(constants.Constants.NOTIFICATION_ERROR_VALIDATOR_USER)==0){
            result = constants.Constants.SUCCESS;
        }
        
        return result;
    }

    public static void main(String[] args) {
        UserValidator userValidator = new UserValidator();
        System.out.println(userValidator.usernameValidate("huy "));
    }
}
