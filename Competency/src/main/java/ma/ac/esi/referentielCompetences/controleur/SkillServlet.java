package ma.ac.esi.referentielCompetences.controleur;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.ac.esi.referentielCompetences.model.Skill;
import ma.ac.esi.referentielCompetences.model.SkillDAO;

/**
 * Servlet implementation class SkillServlet
 */
public class SkillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SkillServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	//}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String name = request.getParameter("name");
		 String description = request.getParameter("description");
		 String domain = request.getParameter("domain");
		 String level = request.getParameter("level");


		 Skill skill = new Skill(name, description, domain, level);


		 SkillDAO skillDAO = new SkillDAO();
		 skillDAO.addSkill(skill);
		 boolean succes = skillDAO.addSkill(skill);

		 if (succes) {
		  request.setAttribute("message", "La compétence a été ajoutée avec succès.");
		  }
		  else {
		 request.setAttribute("erreur", "Erreur lors de l'ajout de la compétence.");
		  }
		// Après avoir ajouté une nouvelle compétence
		  List<Skill> skills = skillDAO.getAllSkills();
		  request.setAttribute("skills", skills);
		  RequestDispatcher dispatcher = request.getRequestDispatcher("/SkillCrud.jsp");
		  dispatcher.forward(request, response);



		 //response.sendRedirect("addSkill.html");
		//doGet(request, response);
	}

}
