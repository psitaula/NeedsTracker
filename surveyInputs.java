//now we need the survey 
class surveyInput{
   private ArrayList<String>responses = new ArrayList<>();
    ArrayList<Listener> listen = new ArrayList<>();

void addListener(Listener listener) {
    listen.add(listener);
}

void addResponse(String response) {
    responses.add(response);

    for (Listener listener : listen) {
        listener.responseAdded();
    }
}
    
    ArrayList<String> getResponse(){
        return responses;
    }
}
