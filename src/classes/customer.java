package classes;
 

import java.io.Serializable;
import java.util.ArrayList;

public class customer extends person implements Serializable{
    
    String cusName;
    int cusID;
    final String cusFilePath = "cus.bin";
    public static ArrayList<customer> cus = new ArrayList<customer>();

    public customer(int cusID , String cusName) {
        this.cusID = cusID;
        this.cusName = cusName;
    }

    public customer() {
    }
    
    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public int getCusID() {
        return cusID;
    }

    public void setCusID(int cusNumber) {
        this.cusID = cusNumber;
    }


    public static ArrayList<customer> getCus() {
        return cus;
    }

    public static void setCus(ArrayList<customer> cus) {
        customer.cus = cus;
    }
     public void loadFromFileCus() {
            cus = (ArrayList<customer>) (Object) fmanager.read(cusFilePath);
    }
     public boolean addcustomer(){
        if (this.cusID > 0 && CheckId(cusID) == -1){
        loadFromFileCus();
        cus.add(this);
        return commitToFilecus();
        }
        return false;
    }
     public boolean commitToFilecus(){
        return fmanager.write(cusFilePath, cus);
    }
     public boolean updatecustomer(int oldId, customer newCustomerValues){ 
        loadFromFileCus();
        int index=getCustomerIndex(oldId);
        if (index!=-1) {
            cus.set(index, newCustomerValues);
            return commitToFilecus();
        }
       return false;
    }

    public boolean deleteCustomer(int id) {
        loadFromFileCus();
        int index=getCustomerIndex(id);
        if (index!=-1) {
            cus.remove(index);
            return commitToFilecus();
        }
       return false;
    }
    
    public int CheckId(int id){
      for(int i=0 ; i<cus.size() ; i++)
        {
            if (cus.get(i).cusID == id);
                return 0;
        } 
      return -1;
   }
    
    public int getCustomerIndex(int Id){
        for (int i = 0; i < cus.size(); i++) {
            if (cus.get(i).getCusID()== Id) {
                return i;
            }      
        }
        return  -1;   
    }
    
    public boolean searchCus(int id) {
        loadFromFileCus();
        int index = getCustomerIndex(id);
        if (index != -1) {
            return true;
        } else {
            return false;
        }
    }
}
