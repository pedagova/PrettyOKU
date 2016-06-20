package view.Panels;

public enum Tags {
	VIDEO_GAMES("Video Games", "1", new String[]{"PS", "PS1", "PS2", "PS3", "XBOX" , "XBOX360", "XBOXONE", "Nintendo", "3Ds", "2Ds"}),
	ART("Art", "2", new String[]{""}), 
	MERCHANDASING("Merchandasing", "3", new String[]{""}), 
	MANGA("Manga", "4", new String[]{"Naruto", "One Piece", "Nisekoi", "Golden time", ".hack"}),
	GADGETS("ELECTR. GADGETS", "5", new String[]{""});

	private String name;
	private String id;
	private String[] chain;

	Tags(String name, String id, String[] chain) {
		this.name = name;
		this.id=id;
		this.chain = chain;
	}

	public String getName() {
		return this.name;
	}

	public String getId() {
		return id;
	}

	public String[] getChain() {
		return chain;
	}

}

