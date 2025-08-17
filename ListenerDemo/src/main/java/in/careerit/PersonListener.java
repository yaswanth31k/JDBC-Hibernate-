package in.careerit;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class PersonListener implements ServletContextListener {


	public void contextInitialized(ServletContextEvent sce) {
		//read context parameter from web.xml
		//Ask ServletContext to get a refernce of ServletContext

		ServletContext contxet = sce.getServletContext() ;

		int id = Integer.parseInt(contxet.getInitParameter("id"));
		String  name =contxet.getInitParameter("name");
		int age = Integer.parseInt(contxet.getInitParameter("age"));

		Persn person = new Persn();
		person.setId(id);
		person.setName(name);
		person.setAge(age);

		contxet.setAttribute("person",person);
	}

	public void contextDestoryed(ServletContextEvent sce) {

	}

    public PersonListener() {
        // TODO Auto-generated constructor stub
    }

}
