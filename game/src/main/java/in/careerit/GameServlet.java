package in.careerit;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GameServlet
 */
public class GameServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		// for reading the  form data
		
		//populating a list of games
		
		//generating a loist of games
		
		
		String gameType = request.getParameter("gameType");
		

		/*List<String> gameList = new ArrayList<String>();
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
'
		}
		*/
		//controller is communicating with model to get a listOfGames based on the gamestype
		List<String> gameList = Game.getListOfGames(gameType);
		
		
		/*out.println("<center>");
		out.println("selected game type is :: "+gameType+"<br/>");
		out.println("list of games are :: "+gameList);
		out.println("<center>");
		*/
		
		//redirect to Game.jsp to generete the response for the client
		request.setAttribute("gameList", gameList);
		RequestDispatcher rd =  request.getRequestDispatcher("game.jsp");
		rd.forward(request, response);
		
}

}
