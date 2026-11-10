//class is meant to check for gaps by listening to surveys
//still need to compare to actual community resources to see if its a 
//like supply chain type problem or lack of resources. probably heavily gonna use listener


class gapIdentifier implements Listener{
    private services communityServices;

    public gapIdentifier(services communityServices){
        this.communityServices = communityServices;
    }

   @Override 
    public void responseAdded(String response){
        System.out.println("Looking for gaps...");
        check(response);
    }

    //All communities are assumed to have these things. If people in the 
    //surveys say they don't, then it is set to false. 
public void check(String response) {
    if (response.contains("housing")) {
        communityServices.setHousing(false);
    }

    if (response.contains("food")) {
        communityServices.setFood(false);
    }

    if (response.contains("electric")) {
       communityServices.setElectric(false);
    }

}


}