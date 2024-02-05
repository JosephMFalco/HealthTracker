public class Health {

    private String bloodPressure;
    private double weight;
    private String date;
    private int ID;
    private int userID;

    public Health () {

    }
    public Health (String bloodPressure, Double weight, int ID, int userID, String date) {

        this.bloodPressure = bloodPressure;
        this.weight = weight;
        this.ID = ID;
        this.userID = userID;
        this.date = date;


        populateWeight();
        populateBP();
        populateID();
        populateDate();
        populateUserID();

    }

    public void populateID() {



    }

    public void populateUserID() {



    }

    public void populateDate() {



    }
    //adds blood pressure to db
    public void populateBP() {



    }

    //adds weight to db
    public void populateWeight() {



    }

}
