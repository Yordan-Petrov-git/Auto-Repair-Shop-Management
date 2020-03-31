package base;

public class RepairsService {

    private int idSrvc;          //id
    private String wrkrSrvc;    //worker
    private String typeSrvc;     // type
    private String descSrvc;         // description
    private String carIdSrvc;          //car_id            
    private String clientIdSrvc;   // client_id
    private String partOEMSrvc;       // part_oem
    private String timeStmpSrvc;    // timestamp
    private String priveSrvc;        //price
    private String vatSrvc;      //vat
    private String discountSrvc;    // discount
    private String timeSrvc;    //time

        public RepairsService(int ID, String worker, String type, String description, String car_id,
            String client_id, String part_oem, String timestamp,
            String price, String vat, String discount, String time) {
        this.idSrvc = ID;                   // id
        this.wrkrSrvc = worker;             //worker
        this.typeSrvc = type;               //   type
        this.descSrvc = description;       //description
        this.carIdSrvc = car_id;            //car_id  
        this.clientIdSrvc = client_id;       // client_id
        this.partOEMSrvc = part_oem;         // part_oem
        this.timeStmpSrvc = timestamp;       // timestamp
        this.priveSrvc = price;            //price
        this.vatSrvc = vat;               //vat
        this.discountSrvc = discount;    // discount
        this.timeSrvc = time;           //time
    }
        
 //Getter methods for repair services details
        
    public int getIdSrvc() { //id
        return idSrvc;
    }

    public String getWorkerSrvc() {//worker
        return wrkrSrvc;
    }

    public String getTypeSrvc() {//   type
        return typeSrvc;
    }

    public String getdescSrvc() { //description
        return descSrvc;
    }

    public String getCarIdSrvc() { //car_id  
        return carIdSrvc;
    }

    public String getClientIdSrvc() {// client_id
        return clientIdSrvc;
    }

    public String getPartOEMSrvc() {  // part_oem
        return partOEMSrvc;
    }

    public String getTimeStmpSrvc() { // timestamp
        return timeStmpSrvc;
    }

    public String getPriveSrvc() {//price
        return priveSrvc;
    }

    public String getVatSrvc() {//vat
        return vatSrvc;
    }

    public String getDiscountSrvc() {// discount
        return discountSrvc;
    }

    public String gettimeSrvc() { //time
        return timeSrvc;
    }
}
