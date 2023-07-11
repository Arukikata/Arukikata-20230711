package arukikata;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ArukikataServlet
 */
@WebServlet("/ArukikataServlet")
public class ArukikataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ArukikataServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArukikataDataGetter getter = new ArukikataDataGetter();
		ArrayList<DataBean> beanList = getter.getData();
		
		ObjectMapper mapper = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		response.setContentType("application/json");
		response.setHeader("access-control-allow-origin", "*");
		
		try {
			pw.print("[");
			for(int i = 0; i < beanList.size(); i++) {
				String json = mapper.writeValueAsString(beanList.get(i));
				pw.print(json);
				if(i < beanList.size() - 1) {
					pw.println(",");
				}
			}
			pw.print("]");
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
