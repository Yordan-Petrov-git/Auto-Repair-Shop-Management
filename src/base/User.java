package base;

public class User {
//List for User information
    private int id;  // clId 0
    private String firstName; // customer name 1
    private String lastName;// customer name f 2
    private String age;//phNum                    3
    private String clPhNumAlt;               // num ph 2  4
    private String clMail;            // mail  5
    private String clMailAlt;           // mail 2 6
    private String dateT;           //date time 7
    private String modCntr; //last mod count 8
    private String dateTLMod;   // mod count  9 

    public User(int ID, String FirstName, String LastName, String Age, String PhNumAlt, String EmailCl, String EmailClAlt, String dateTimeCl, String clModCntr, String clModDateTLast) {
        this.id = ID; // clId 0
        this.firstName = FirstName;// customer name 1
        this.lastName = LastName;// customer name f 2
        this.age = Age;//phNum    3
        this.clPhNumAlt = PhNumAlt;              // num ph 2  4
        this.clMail = EmailCl;                // mail  5
        this.clMailAlt = EmailClAlt;                  // mail 2 6
        this.dateT = dateTimeCl;               //date time 7
        this.modCntr = clModCntr; //Modification counter !! not used !! 8
        this.dateTLMod = clModDateTLast;//Last mod date time 9
    }
    
 //Getter methods for user details
    
    public int getId() {//clId 0
        return id;
    }

    public String getFirstName() {//customer name 1
        return firstName;
    }

    public String getLastNAme() {//customer name f 2
        return lastName;
    }

    public String getAge() {//phNummber primary
        return age;
    }

    public String getPhNumAlt() {//phone secondary
        return clPhNumAlt;
    }

    public String getMail() {//mail primary
        return clMail;
    }

    public String getMailAlt() {//mail secondary
        return clMailAlt;
    }

    public String getDateTime() {//timestamp created
        return dateT;
    }

    public String getModCount() {//modifications counter
        return modCntr;
    }

    public String getDateTimeLastMod() {//timestamp last modified
        return dateTLMod;
    }
}
