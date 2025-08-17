package in.careerit;

import java.util.ArrayList;
import java.util.List;

public class Game {
	public static List<String> getListOfGames(String gameType){
		List<String> gameList = new ArrayList<String>();
		if(gameType.equals("Indoor")) {
			gameList.add("chess");
			gameList.add("carram");
			gameList.add("badminton");
			gameList.add("cards");
		}else {
			gameList.add("cricket");
			gameList.add("football");
			gameList.add("hockey");
			gameList.add("kabaddi");

		}
		return gameList;
	}
}
