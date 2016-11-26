import model.Politician;
import model.Poll;
import model.PollPart;
import model.PollPartOption;

import java.util.LinkedList;

public class ExampleData {

    public static void fillData(IStorage storage){
        Politician polBernd = new Politician("Pol. Bernd");

        Poll poll1 = new Poll(polBernd, "Soll ein neues Schwimmbad gebaut werden?", System.currentTimeMillis() + 86400,
                "Der Bürgermeister will das wirklich bauen ... Beschreibung!");
        LinkedList<PollPart> poll1Parts = new LinkedList<>();

        LinkedList<PollPartOption> poll1Part1options = new LinkedList<>();
        poll1Part1options.add(new PollPartOption(0, "Auf keinen Fall", "1"));
        poll1Part1options.add(new PollPartOption(1, "", "2"));
        poll1Part1options.add(new PollPartOption(2, "Eher nein", "3"));
        poll1Part1options.add(new PollPartOption(3,"Eher ja", "4"));
        poll1Part1options.add(new PollPartOption(4,"", "5"));
        poll1Part1options.add(new PollPartOption(5,"Auf jeden Fall", "6"));

        poll1.addPollPart(new PollPart(poll1Part1options, 0,"Bist du dafür?"));

        SimpleStorage.getINSTANCE().savePoll(poll1);
    }
}
