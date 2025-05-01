package app;

import services.*;
import views.*;
import models.*;


public class AppMain {

	public static void main(String[] args) {
		var view = new PetView();
		
		
		while(true)
		{
			try {
				Thread.sleep(200);
			}
			catch(Exception e)
			{
				break;
			}
		}
	}

}
