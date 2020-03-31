package base;

public class Parts_serv {
//Parts  information lsit
    //From SQL DB able name new_parts 
    private String parts_OEMNum; // SQL name :parts_OEM_Num
    private String parts_OriginC;  // SQL name :parts_Origin_c
    private String parts_FMake;//SQL name : parts_For_Make//
    private String parts_FModel;// SQL name :parts_For_Model             
    private String parts_PartMake;// SQL name :parts_Part_Make
    private String parts_Supp; //SQL name : parts_Supplier
    private String parts_Cst;//SQL name :parts_Cost
    private String parts_Cnt; //SQL name :parts_Count
    private String parts_Weight;//SQL name :parts_For_Weight
    private String parts_ForSys;//SQL name : parts_For_System
    private String parts_Desc;//SQL name :parts_Description
    private byte[] parts_Pic;//SQL name :parts_Picture
    private String parts_VAT_T;// SQL name :parts_VAT
    private String parts_DateTimeSt;//SQL name :parts_DateTime

   
    public Parts_serv(String OEMNum, String OriginC, String FMake, String FModel, String PartMake, String Supp, String Cst, String Cnt, String Weight, String ForSys, String Desc ,byte [] photo  , String VAT_T, String DateTimeSt) {

        this.parts_OEMNum = OEMNum;//Part OEM number 
        this.parts_OriginC = OriginC;//Part origin
        this.parts_FMake = FMake;//Part for make
        this.parts_FModel = FModel;//Part for model 
        this.parts_PartMake = PartMake;//Part make
        this.parts_Supp = Supp;//Part supplier
        this.parts_Cst = Cst;//Part cost
        this.parts_Cnt = Cnt;//Part count
        this.parts_Weight = Weight;//Part Weight
        this.parts_ForSys = ForSys;//Part For system
        this.parts_Desc = Desc;//Part Description
        this.parts_Pic=photo;//Part Photo
        this.parts_VAT_T = VAT_T;//Part TAX
        this.parts_DateTimeSt = DateTimeSt;//Part entry Timestamp crated
    }

   //Getter methods for part details
    
    public String getOEMNum() {//Part OEM number
        return parts_OEMNum;
    }

    public String getOriginC() {//Part origin
        return parts_OriginC;
    }

    public String getFMake() {//Part for make
        return parts_FMake;
    }

    public String getFModel() {//Part for model
        return parts_FModel;
    }

    public String getPartMake() {//Part make
        return parts_PartMake;
    }

    public String getSupp() {//Part supplier
        return parts_Supp;
    }

    public String getCst() {//Part cost
        return parts_Cst;
    }

    public String getGCnt() {//Part count
        return parts_Cnt;
    }

    public String getWeight() {//Part weight
        return parts_Weight;
    }

    public String getForSys() {//Part for system
        return parts_ForSys;
    }

    public String getDesc() {//Part Description
        return parts_Desc;
    }


    public byte[] getPartImage() {//Gets bytes for Part image
        return parts_Pic;
    }

    
    public String getVAT_T() {//Part TAX
        return parts_VAT_T;
    }

    public String getDateTimeSt() {//Part Timestamp created
        return parts_DateTimeSt;
    }
    
    //Setter methods
    public void setPhoto(byte[] photo) {//Sets Part image bytes
        this.parts_Pic = photo;
    } 
}
