//meant to read inputs of surveys. Probably will change the logic
//that allows this to be like this but its okay for now

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
        listener.responseAdded(response);
    }
}
    
    ArrayList<String> getResponse(){
        return responses;
    }
}
