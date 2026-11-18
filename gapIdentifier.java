//class is meant to check for gaps by listening to surveys
//still need to compare to actual community resources to see if its a 
//like supply chain type problem or lack of resources. probably heavily gonna use listener



public class gapIdentifier implements Listener {
    private services communityServices;

    public gapIdentifier(services communityServices) {
        this.communityServices = communityServices;
    }

    @Override
    public void responseAdded(String response) {
        check(response);
    }

    public void check(String response) {
        response = response.toLowerCase();

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

    public void updateGaps(surveyInput survey) {
        communityServices.setHousing(true);
        communityServices.setFood(true);
        communityServices.setElectric(true);

        for (String response : survey.getResponse()) {
            check(response);
        }
    }
}
