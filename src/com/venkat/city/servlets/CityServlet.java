package com.venkat.city.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchURL")
public class CityServlet extends HttpServlet {

	private List<String> cityNamesList;

	@Override
	public void init(ServletConfig config) throws ServletException {

		cityNamesList = new ArrayList<String>();

		cityNamesList.add("Kansas City");
		cityNamesList.add("Overland Park");
		cityNamesList.add("Dallas");
		cityNamesList.add("San Jose");
		cityNamesList.add("New Jersey");
		cityNamesList.add("Warrensburg");
		cityNamesList.add("London");
		cityNamesList.add("Delhi");
		cityNamesList.add("Guntur");
		cityNamesList.add("Dehradun");
		cityNamesList.add("Guntakal");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String cityName = request.getParameter("cityName");
		
		if(!cityName.isEmpty()){
			
			int cityNameLength = cityName.length();
			
			PrintWriter out = response.getWriter();//for using out.println()
			
			//ArrayList<String> displayCity = new ArrayList<String>();
			try{
				for (String cityDataName : cityNamesList) {
					if(cityDataName.length() >= cityNameLength){
						if(cityName.equalsIgnoreCase(cityDataName.substring(0, cityNameLength))){
							//displayCity.add(cityDataName);
							out.println(cityDataName);
						}
					}
				}
			}catch(StringIndexOutOfBoundsException exception){
				out.println("<br>System Error");
			}
		}
		
	}

}
