/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.Validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author 0896
 */
public class PhoneNumberVerifif {
    
    public static boolean getPhoneNumberVer(String number) {
        //Checks  Bulgarian phoen numbers to valdiate the correct length with regular expressions
        String numberRegex = "[0-9]{10}";
        Pattern numberPat = Pattern.compile(numberRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = numberPat.matcher(number);
        return matcher.find();
    }
    
}
