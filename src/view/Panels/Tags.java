package view.Panels;

public enum Tags {
	VIDEO_GAMES("VIDEO GAMES", 1), ART("ART", 2), MISCELANIUS("MISCELANIUS", 3), MANGA("MANGA",
			4), GADGETS("ELECTR. GADGETS", 5);

	private String name;
	private int id;

	Tags(String name, int id) {
		this.name = name;
		this.id=id;
	}

	public String getName(int id) {
		return this.name;
	}

	public int getId() {
		return id;
	}

}

