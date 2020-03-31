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
public class CarNumberVerifi {
    
    public static boolean getCarNumberVer(String number) {
    //Checks all Bulgarian Vehicle registration numbers with  regular expressions
      //Registration numbers formats : MAX LENGTH 8 CHARACTERS WITH OR WITHOUT SPACES IN LATIN OR CYRILLIC
        //"СА 1111 РН" , "СА1111РН", "SA 1111 PH" ,"SA1111PH" - Standart vehicle registration numbers in Bulgaria
        //"CC 777777","SS 777777",-Custom vehicle registration numbers
        //„Х АСК0В0",„H АSK0V0" -Custom vehicle registration numbers
        //"NNN T NNN" - Transit vehicle registration numbers
        //"NNN H NNN" - Non-registered vehicle registration numbers
        //"NNN M NNN" -Temporary vehicle registration numbers
        //"BA NNNNNN" - Army vehicle registration numbers
        //"CP NN NNN" - Civil Protection vehicle registration numbers
        //"XX NNNN" - Foreign vehicle registration numbers
        //"С NNNN" - Diplomatic vehicle registration numbers
        
      //RegExr string for matching
        String numberRegex = "[A-Za-z0-9]{0,4}s{0,1}[A-Za-z0-9]{0,4}s{0,1}[A-Za-z0-9]{0,4}[А-Яа-я0-9]{1,4}s{0,1}[А-Яа-я0-9]{1,4}s{0,1}[А-Яа-я0-9]{1,4}";
        Pattern numberPat = Pattern.compile(numberRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = numberPat.matcher(number);
        return matcher.find();
    }
    
}
