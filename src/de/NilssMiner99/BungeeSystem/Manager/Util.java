package de.NilssMiner99.BungeeSystem.Manager;

public enum Util {
	
	SEKUNDEN("Sekunde(n)", 1),
	MINUTEN("Minute(n)", 60),
	STUNDEN("Stunde(n)", 60*60),
	TAGE("Tag(e)", 60*60*24),
	WOCHEN("Woche(n)", 60*60*24*7),
	MONATE("Monat(e)", 60*60*24*7*4),
	JAHRE("Jahr(e)", 60*60*24*360);
	
	public String name;
	public long toSeconds;
	
	private Util(String name, long toSeconds) {
		this.name = name;
		this.toSeconds = toSeconds;
	}
	
	public String getName() {
		return this.name;
	}
	
	public long getToSeconds() {
		return this.toSeconds;
	}
	
	public static String getValuesAsString() {
		return values().toString();
	}
	
	public static Boolean isValue(String name) {
		for(Util s : Util.values()) {
			if(s.toString().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
}