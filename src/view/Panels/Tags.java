package view.Panels;

public enum Tags {
	VIDEO_GAMES("Video Games", "1"), ART("Art", "2"), MISCELANIUS("Miscelanius", "3"), MANGA("Manga",
			"4"), GADGETS("ELECTR. GADGETS", "5");

	private String name;
	private String id;

	Tags(String name, String id) {
		this.name = name;
		this.id=id;
	}

	public String getName(int id) {
		return this.name;
	}

	public String getId() {
		return id;
	}

	public String[] getChain() {
		String[] chain = new String[5];
		chain[0] = "3ds";
		chain[1] = "ps vita";
		chain[2] = "WII U";
		chain[3] = "XBOX ONE";
		chain[4] = "PS3";
		return chain;
	}

}

