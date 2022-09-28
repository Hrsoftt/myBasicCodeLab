package academy.learn;


public class Car {
    private int door;
    private int wheel;
    private String model;
    private String engine;
    private String colour;

    public void setModel(String model){
        String validModel = model.toLowerCase();
        if(validModel.equals("cle")|| validModel.equals("cange")){
            this.model=model;
        }else{
            this.model="Unknown";
        }
    }

    public String getModel(){
        return this.model;
    }
}
