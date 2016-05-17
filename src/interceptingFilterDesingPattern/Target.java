package interceptingFilterDesingPattern;

public class Target {
	public void execute(String[] request) {
		System.out.println(
				"Executing request: " + "\n" +
				"The information is being saved at data base." + "\n");
		this.showInfo(request);
	}
	
	private void showInfo(String[] request){
		for(String data: request){
			System.out.println(data);
		}
	}
}
