package model;

public enum Tags {
	VIDEO_GAMES("Video Games", "1", new String[]{"PS", "PS1", "PS2", "PS3", "XBOX" , "XBOX360", "XBOXONE", "Nintendo", "3Ds", "2Ds", "PC"}),
	ART("Art", "2", new String[]{"Poster", "Concept art", "Art book", "Picture"}), 
	MERCHANDASING("Merchandasing", "3", new String[]{"Cup", "Mouse pad", "Key ring", "Puppet", "Star Wars", "Game of Thrones", "Pokemon", "Harry Potter", "Super Mario", "Minecraft"}), 
	MANGA("Manga", "4", new String[]{"Naruto", "One Piece", "Nisekoi", "Golden time", ".hack", "Zatch Bell", "Ao no exorcist", "Berserk", "Code Geass", "Death Note", "Hellsing",  "Nanatsu no Taizai", "Saint Seiya" , "Sailor moon", "Shingeky no kyojin"}),
	GADGETS("Gadgets", "5", new String[]{"Screen", "Mouse pad", "Controller", "Laptop", "Keyboard","Microphone"});

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

