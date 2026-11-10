class gapIdentifier implements Listener{
    private services communityServices;

    public gapIdentifier(services communityServices){
        this.communityServices = communityServices;
    }
   
    public void responseAdded(){
        System.out.println("Looking for gaps...")
    }

    //All communities are assumed to have these things. If people in the 
    //surveys say they don't, then it is set to false. 
public void check(String response) {
    if (response.contains("housing")) {
        setHousing(false);
    }

    if (response.contains("food")) {
        setFood(false);
    }

    if (response.contains("electric")) {
       setElectric(false);
    }

}


}