package interceptingFilterDesingPattern.targets;

public interface Target {
	public void execute(String[] request);
	
	public void showInfo(String[] request);
}
