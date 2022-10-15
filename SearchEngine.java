import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;


    /* 
    class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
        ArrayList<String> word = new ArrayList<String>();
        String searched = new String();
        String substrng = "";
        public String handleRequest(URI url) {
            if (url.getPath().equals("/")) {
                return String.format("No string");
            } else if (url.getPath().equals("/search")) {
                String[] parameters1 = url.getQuery().split("=");
                    if (parameters1[0].equals("s")) {
                        substrng = parameters1[1];
                    for (int i = 0; i< word.size(); i++){
                            if (word.get(i).contains(substrng)){
                                searched += (word.get(i) + " ");
                        }
                    }
                    return String.format(searched);
                }
                return "404 Not Found";
            } else {
                System.out.println("Path: " + url.getPath());
                if (url.getPath().contains("/add")) {
                    String[] parameters = url.getQuery().split("=");
                    if (parameters[0].equals("s")) {
                        word.add(parameters[1]);
                        return String.format("String added");
                    }
                }
                return "404 Not Found!";
            }
    }
}
*/

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
        ArrayList<String> enterWord = new ArrayList<String>();
        String Wordsearched = new String();
        String subString = "";
        public String handleRequest(URI url) {
            if (url.getPath().equals("/")) {
                return String.format("String not found");
            } else if (url.getPath().equals("/seek")) {
                String[] parameters1 = url.getQuery().split("=");
                    if (parameters1[0].equals("start")) {
                        subString = parameters1[1];
                    for (int i = 0; i< enterWord.size(); i++){
                            if (enterWord.get(i).contains(subString)){
                                Wordsearched += (enterWord.get(i) + " ");
                        }
                    }
                    return String.format(Wordsearched);
                }
                return "404 Not Found";
            } else {
                System.out.println("Path: " + url.getPath());
                if (url.getPath().contains("/add")) {
                    String[] parameters = url.getQuery().split("=");
                    if (parameters[0].equals("start")) {
                        enterWord.add(parameters[1]);
                        return String.format("String added");
                    }
                }
                return "404 Not Found!";
            }
    }
}

class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
