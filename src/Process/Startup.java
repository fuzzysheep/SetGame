package Process;

import Presentation.ApplicatieForm;

public class Startup extends Task
{
	
	@SuppressWarnings("unused")
	protected void execute()
	{
		
		ApplicatieForm applicatieForm = new ApplicatieForm();

	}
	
	public static void main(String[] args)
	{
		new Startup().run();
	}

}
