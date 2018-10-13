package converter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/* This is somewhat a messy class
 * but its goal what to get all the data
 * form the .txt and convert it into the new
 * JSON format
 */

public class NpcTxtToJson {
	public static void main(String args[]){
		//Gson gson = new Gson();
		Gson gson2 = new GsonBuilder().setPrettyPrinting().create();

		try{
			File file = new File(System.getProperty("user.dir")+"/npcs.txt");
			File fileSpawns = new File(System.getProperty("user.dir")+"/spawn.json");
			File fileNpc = new File(System.getProperty("user.dir")+"/npc.json");
			System.out.println(file.toString());
			BufferedReader reader = new BufferedReader(new FileReader(file));
			//BufferedWriter spawnWriter = new BufferedWriter(new FileWriter(fileSpawns));
			BufferedWriter npcWriter = new BufferedWriter(new FileWriter(fileNpc));
			String line;
			Npc npc = new Npc();
			//Spawn spawn = new Spawn();
			
			int id = -1;
			while ((line = reader.readLine()) != null) {	
				if(line.contains("//")){
					continue;
				}
				else if (line.contains("finish")) {		
					//if we don't have a name then it was just a spawn loc
					//so we don't need to make a new def for it
					if(npc.name != null){
						String npcJson = gson2.toJson(npc)+",\n";
						npcWriter.write(npcJson);
						
						System.out.println("NPC Def created for:"+npc.npcId);
					}
					
					//reseting the classes
					npc = new Npc();
					//spawn = new Spawn();
				}
				else if (line.contains("npc:")){
					String[] tokens = line.split(":");
					npc.npcId = Integer.parseInt(tokens[1].replaceAll("\\s+",""));
					//spawn.npcId = Integer.parseInt(tokens[1].replaceAll("\\s+",""));
				}
				else if (line.contains("name:")){
					String[] tokens = line.split(":");
					npc.name = tokens[1].trim();
				}
				else if (line.contains("examine:")){
					String[] tokens = line.split(":");
					npc.examine = tokens[1].trim();
				}
				else if (line.contains("size:")){
					String[] tokens = line.split(":");
					npc.size = Integer.parseInt(tokens[1].replaceAll("\\s+",""));
				}
				else if (line.contains("walk-radius:")){
					String[] tokens = line.split(":");
					npc.walk_radius = Integer.parseInt(tokens[1].replaceAll("\\s+",""));
				}
				else if (line.contains("combat-follow:")){
					String[] tokens = line.split(":");
					npc.combat_follow = Integer.parseInt(tokens[1].replaceAll("\\s+",""));
				}
				else if (line.contains("attackable:")){
					String[] tokens = line.split(":");
					npc.attackable = Boolean.parseBoolean(tokens[1].replaceAll("\\s+",""));	
				}
				else if (line.contains("aggressive:")){
					String[] tokens = line.split(":");
					npc.aggressive = Boolean.parseBoolean(tokens[1].replaceAll("\\s+",""));	
				}
				else if (line.contains("retreats:")){
					String[] tokens = line.split(":");
					npc.retreats = Boolean.parseBoolean(tokens[1].replaceAll("\\s+",""));	
				}
				else if (line.contains("poisonous:")){
					String[] tokens = line.split(":");
					npc.poisonous = Boolean.parseBoolean(tokens[1].replaceAll("\\s+",""));	
				}
				else if (line.contains("respawn:")){
					String[] tokens = line.split(":");
					npc.respawn = Integer.parseInt(tokens[1].replaceAll("\\s+",""));	
				}
				else if (line.contains("maxhit:")){
					String[] tokens = line.split(":");
					npc.max_hit = Integer.parseInt(tokens[1].replaceAll("\\s+",""));	
				}
				else if (line.contains("attackspeed:")){
					String[] tokens = line.split(":");
					npc.attack_speed = Integer.parseInt(tokens[1].replaceAll("\\s+",""));	
				}
				else if (line.contains("attackanim:")){
					String[] tokens = line.split(":");
					npc.attack_anim = Integer.parseInt(tokens[1].replaceAll("\\s+",""));	
				}
				else if (line.contains("defenceanim:")){
					String[] tokens = line.split(":");
					npc.defence_anim = Integer.parseInt(tokens[1].replaceAll("\\s+",""));	
				}
				else if (line.contains("deathanim:")){
					String[] tokens = line.split(":");
					npc.death_anim = Integer.parseInt(tokens[1].replaceAll("\\s+",""));	
				}
				else if (line.contains("hitpoints:")){
					String[] tokens = line.split(":");
					npc.hitpoints = Integer.parseInt(tokens[1].replaceAll("\\s+",""));	
				}
				else if (line.contains("combatlevel:")){
					String[] tokens = line.split(":");
					npc.combat_level = Integer.parseInt(tokens[1].replaceAll("\\s+",""));	
				}
				else if (line.contains("attacklevel:")){
					String[] tokens = line.split(":");
					npc.attack_level = Integer.parseInt(tokens[1].replaceAll("\\s+",""));	
				}
				else if (line.contains("strengthlevel:")){
					String[] tokens = line.split(":");
					npc.strength_level = Integer.parseInt(tokens[1].replaceAll("\\s+",""));	
				}
				else if (line.contains("rangedlevel:")){
					String[] tokens = line.split(":");
					npc.ranged_level = Integer.parseInt(tokens[1].replaceAll("\\s+",""));	
				}
				else if (line.contains("magiclevel:")){
					String[] tokens = line.split(":");
					npc.magic_level = Integer.parseInt(tokens[1].replaceAll("\\s+",""));	
				}
				else if (line.contains("defencemelee:")){
					String[] tokens = line.split(":");
					npc.defence_melee = Integer.parseInt(tokens[1].replaceAll("\\s+",""));	
				}
				else if (line.contains("defencerange:")){
					String[] tokens = line.split(":");
					npc.defence_ranged = Integer.parseInt(tokens[1].replaceAll("\\s+",""));	
				}
				else if (line.contains("defencemage:")){
					String[] tokens = line.split(":");
					npc.defence_magic = Integer.parseInt(tokens[1].replaceAll("\\s+",""));	
				}
				else if (line.contains("slayer-req:")){
					String[] tokens = line.split(":");
					npc.slayer_req = Integer.parseInt(tokens[1].replaceAll("\\s+",""));	
				}
				else if (line.contains("aggressive-distance")){
					String[] tokens = line.split(":");
					npc.aggresive_distance = Integer.parseInt(tokens[1].replaceAll("\\s+",""));	
				}
				/**
				else if (line.contains("spawn-position:")) {
					String[] tokens = line.split(":");					
					spawn.x = Integer.parseInt(tokens[1].replaceAll("\\s+",""));
					spawn.y = Integer.parseInt(tokens[2].replaceAll("\\s+",""));
					
					String spawnJson = gson.toJson(spawn)+",\n";
					spawnWriter.write(spawnJson);
					
					System.out.println("NPC Spawn created for:"+spawn.npcId);
	
				}
				*/else{
					if (line.contains("spawn-position:")){
						continue;
					}
					if (line.isEmpty()){
						continue;
					}
					
					System.out.println("Could not find match for line:"+line);
					
				}
				
			}
			npcWriter.close();
			//spawnWriter.close();
			reader.close();
		}catch (IOException e) {
			e.printStackTrace();
		}		
	} 
}
