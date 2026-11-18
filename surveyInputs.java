//meant to read inputs of surveys. Probably will change the logic
//that allows this to be like this but its okay for now

//now we need the survey 
import java.util.ArrayList;

public class surveyInput {
    private ArrayList<String> responses = new ArrayList<>();
    private ArrayList<Listener> listen = new ArrayList<>();

    public void addListener(Listener listener) {
        listen.add(listener);
    }

    public void addResponse(String response) {
        if (response == null || response.trim().isEmpty()) {
            throw new IllegalArgumentException("Enter a response.");
        }

        responses.add(response);

        for (Listener listener : listen) {
            listener.responseAdded(response);
        }
    }

    public void removeResponse(int index) {
        if (index < 0 || index >= responses.size()) {
            throw new IllegalArgumentException("Select a response.");
        }

        responses.remove(index);
    }

    public void clearResponses() {
        responses.clear();
    }

    public ArrayList<String> getResponse() {
        return new ArrayList<>(responses);
    }
}