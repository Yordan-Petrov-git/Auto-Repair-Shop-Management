package base;

public class Cars_Db_clients {
    //From SQL DB :clients_cars_record;
    private String car_regNum; // SQL name : Car_Reg_Num_cl  //Vehicle registration number
    private String car_VIN;  //SQL name : Car_Vin_Num_cl //Vehicle Vin number
    private String car_Make;// SQL name :Car_Make_cl // Vehicle make
    private String car_Model;//   SQL name :    Car_Model_cl  //  Vehicle  model       
    private String car_Mileage;  //SQL name : Car_Mileage_cl//Vehicle mileage   
    private String car_Type;      // SQL name :Car_VehicleType_cl//Vehicle type
    private String car_Fueling;       //SQL name :Car_FuelSys_cl//Vehicle fueling 
    private String car_Gearbox;   //SQL name :Car_Gearbox_cl//Vehicle gearbox
    private String car_ManDt; //SQL name :Car_ManufactureDate_cl//Vehicle manufacture date
    private String car_Drivtrn;   // SQL name :Car_Drivetrain_cl//Vehicle drivetrain
    private String car_CC;           //SQL name :Car_EngineDisplacementl_cl//Vehicle engine displacement
    private String car_KW; //SQL name :Car_Power_cl//Vehicle power output
    private String car_DateTimeCre;   // SQL name :Car_DateTime_Created_cl//Vehicle entry tiemstamp 

    public Cars_Db_clients(String regNum,String VIN,  String Make, String Model, String Mileage, String Type, String Fueling, String Gearbox, String ManDt, String Drivtrn, String CC, String KW, String DateTimeCre) {
       
        this.car_regNum = regNum;// SQL name :Car_Reg_Num_cl//Vehicle registration number
        this.car_VIN = VIN; //SQL name :Car_Vin_Num_cl//Vehicle VIN number
        this.car_Make = Make;//SQL name : Car_Make_cl//Vehicle make
        this.car_Model = Model;//SQL name :Car_Model_cl//Vehicle model
        this.car_Mileage = Mileage;     //SQL name : Car_Mileage_cl//Vehicle mileage
        this.car_Type = Type;      //SQL name :Car_VehicleType_cl//Vehicle type
        this.car_Fueling = Fueling;      // SQL name :Car_FuelSys_cl//Vehicle fueling
        this.car_Gearbox = Gearbox;  //SQL name :Car_Gearbox_cl//Vehicle gearbox
        this.car_ManDt = ManDt;   //SQL name :Car_ManufactureDate_cl//Vehicle manufacture date
        this.car_Drivtrn = Drivtrn;  //SQL name :Car_Drivetrain_cl//Vehicle drivetrain
        this.car_CC = CC;      //SQL name :Car_EngineDisplacementl_cl//Vehicle engine dispalcement
        this.car_KW = KW;    //SQL name :Car_Power_cl//Vehicle power output
        this.car_DateTimeCre = DateTimeCre;  //SQL name :Car_DateTime_Created_cl//Vehicle timestamp
    }

   
 //Getter methods for Client detail
    
    public String getregNum() {//SQL name :Car_Reg_Num_cl //Vehicle Registration number
        return car_regNum;
    }
    public String getVIN() {//SQL name :Car_Vin_Num_cl//Vehicle VIN number
        return car_VIN;
    }

    public String getMake() {//SQL name :Car_Make_cl// Vehicle make
        return car_Make;
    }

    public String getModel() {//SQL name :Car_Model_cl//Vehicle model
        return car_Model;
    }

    public String getMileage() {//SQL name :Car_Mileage_cl//Vehicle mileage
        return car_Mileage;
    }

    public String getType() {//SQL name :Car_VehicleType_cl//Vehicle type
        return car_Type;
    }

    public String getFueling() {//SQL name :Car_FuelSys_cl//Vehicle fueling
        return car_Fueling;
    }

    public String getGearbox() {//SQL name :Car_Gearbox_cl//Vehicle gearbox
        return car_Gearbox;
    }

    public String getManDt() {//SQL name :Car_ManufactureDate_cl//Vehicle manufacture date
        return car_ManDt;
    }

    public String getDrivtrn() {//SQL name :Car_Drivetrain_cl//Vehicle drivetrain
        return car_Drivtrn;
    }

    public String getCC() {//SQL name :Car_EngineDisplacementl_cl//Vehicle engine displacement
        return car_CC;
    }

    public String getKW() {//SQL name :Car_Power_cl//Vehicle power output
        return car_KW;
    }

    public String getDateTimeCre() {//SQL name :Car_DateTime_Created_cl//Vehicle entry timestamp 
        return car_DateTimeCre;
    }
}
