package de.NilssMiner99.BungeeSystem.MySQL;

public class MySQL {
	
//	public static String host;
//	public static Integer port;
//	public static String benutzer;
//	public static String database;
//	public static String password;
//	
//	public static Connection con;
//	
//	public static void load() {
//		File f = new File("plugins/BungeeSystem/MySQL.yml");
//		try {
//			if(!f.exists()) {
//				f.createNewFile();
//				FileWriter fw = new FileWriter(f);
//				fw.write("host=localhost");
//				fw.write("\nport=3306");
//				fw.write("\nbenutzer=benuter");
//				fw.write("\ndatabase=database");
//				fw.write("\npassword=password");
//				fw.close();
//			}
//			Scanner sc = new Scanner(f);
//			try {
//				while(sc.hasNextLine()) {
//					String s = sc.nextLine();
//					if(s.startsWith("host=")) {
//						host = s.split("=")[1];
//					} else if(s.startsWith("port=")) {
//						port = Integer.valueOf(s.split("=")[1]);
//					} else if(s.startsWith("benutzer=")) {
//						benutzer = s.split("=")[1];
//					} else if(s.startsWith("database=")) {
//						database = s.split("=")[1];
//					} else if(s.startsWith("password=")) {
//						password = s.split("=")[1];
//					}
//				}
//			} catch(Exception ex) {
//				
//			}
//			sc.close();
//		} catch(Exception ex) {
//			ex.printStackTrace();
//		}
//	}
//	
//	public static void connect() {
//		if(con == null) {
//			try {
//				con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+database, benutzer, password);
//				ProxyServer.getInstance().getConsole().sendMessage(new TextComponent("§2Connectet"));
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//	
//	public static void disconnect() {
//		if(con != null) {
//			try {
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//	
//	public static void qry(String qry) {
//		try {
//			if(con.isClosed()) {
//				connect();
//			}
//			Statement st = con.createStatement();
//			st.executeUpdate(qry);
//		} catch(Exception ex) {
//			ex.printStackTrace();
//		}
//	}
//	
//	public static ResultSet rs(String qry) {
//		ResultSet rs = null;
//		try {
//			if(con.isClosed()) {
//				connect();
//			}
//			java.sql.PreparedStatement ps = con.prepareStatement(qry);
//			return ps.executeQuery();
//		} catch(Exception ex) {
//			ex.printStackTrace();
//		}
//		return rs;
//	}
//	
//	public static void createTable() {
//		qry("CREATE TABLE IF NOT EXISTS xf_user(user_id int, username varchar(50), email varchar(120), gender varchar(10), custom_title varchar(50), language_id int, style_id int, timezone varchar(50), "
//				+ "visible tinyint, activity_visible tinyint, useress_tags mediumblob, user_group_id int, secondary_group_ids varbinary(255), display_stile_group_id int,"
//				+ "permission_combination_id int, message_count int, conversations_unread smallint, register_date int, last_activity int,"
//				+ "trophy_points int, alerts_unread smallint, avatar_date int, avatar_width smallint, avatar_height smallint, gravatar varchar(120), user_state varchar(100),"
//				+ "is_moderator tinyint, is_admin tinyint, is_banned tinyint, like_count int)");
//	}
//	
//	public static void createUser(int userid, String name, String emailadresse, String uuid) {
//		int user_id = userid;/* */
//		String username = name;/* */
//		String email = emailadresse;/* */
//		String gender = "";
//		String custom_title = "";/* */
//		int language_id = 2;
//		int style_id = 0;
//		String timezone= "Europe/Amsterdam";
//		int visible = 1;
//		int activity_visible = 1;
//		Blob useress_tage;
//		int user_group_id = 2;
//		String secondary_group_ids = "";
//		int display_stile_group_id = 2;
//		int permission_combination_id = 2;
//		int message_count = 0;
//		int conversations_unread = 0;
//		int register_date = (int) new Date().getTime();/* */
//		int last_activity = (int) new Date().getTime();/* */
//		int trophy_points = 0;
//		int alerts_unread = 0;
//		int avatar_date = 0;
//		int avatar_width = 0;
//		int avatar_height = 0;
//		String gravatar = "";
//		String user_state = "valid";
//		int is_moderator = 0;
//		int is_admin = 0;
//		int is_banned = 0;
//		int like_count = 0;
//		qry("INSERT INTO xf_user(user_id, username, email, gender, custom_title, language_id, style_id, timezone,"
//				+ "visible, activity_visible, useress_tags, user_group_id, secondary_group_ids, display_style_group_id,"
//				+ "permission_combination_id, message_count, conversations_unread, register_date, last_activity,"
//				+ "trophy_points, alerts_unread, avatar_date, avatar_width, avatar_height, gravatar, user_state,"
//				+ "is_moderator, is_admin, is_banned, like_count) VALUES("
//				+ "'"+user_id+"','"+username+"','"+email+"','"+gender+"','"+custom_title+"','"+language_id+"','"+style_id+"','"+timezone+"',"
//				+ "'"+visible+"','"+activity_visible+"','"+/*useress_tags*/"[BLOB - 3 B]"/**/+"','"+user_group_id+"','"+secondary_group_ids+"','"+display_stile_group_id+"',"
//				+ "'"+permission_combination_id+"','"+message_count+"','"+conversations_unread+"','"+register_date+"','"+last_activity+"',"
//				+ "'"+trophy_points+"','"+alerts_unread+"','"+avatar_date+"','"+avatar_width+"','"+avatar_height+"','"+gravatar+"','"+user_state+"',"
//				+ "'"+is_moderator+"','"+is_admin+"','"+is_banned+"','"+like_count+"')");
//		qry("UPDATE xf_user_authenticate SET data = ");
//		qry("UPDATE xf_user_authenticate SET data = BINARY CONCAT(CONCAT(CONCAT('a:3:{s:4:hash;s:40:', SHA1(CONCAT(SHA1('NEUES-PASSWORT'), SHA1('salt')))),CONCAT(';s:4:salt;s:40:', SHA1('salt'))),';s:8:hashFunc;s:4:sha1;}' ),scheme_class = 'XenForo_Authentication_Core'WHERE user_id = BENUTZER-ID;);
//	}
}