package converter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

public class NpcTxtToJson {
	public static void main(String args[]){
		Gson gson = new Gson();
		try{
			File file = new File(System.getProperty("user.dir")+"/npcs.txt");
			File fileSpawns = new File(System.getProperty("user.dir")+"/spawn.json");
			System.out.println(file.toString());
			BufferedReader reader = new BufferedReader(new FileReader(file));
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileSpawns));
			String line;
			
			int id = -1;
			int lineNumber = 0;
			while ((line = reader.readLine()) != null) {
				lineNumber++;
				
				if (line.contains("Finish") || line.contains("//")) {
					id = -1;
					System.out.println("Skipping line:" + lineNumber);
					continue;
				}
				if (line.contains("npc:")){
					String[] tokens = line.split(":");
					id = Integer.parseInt(tokens[1].replaceAll("\\s+",""));
				}
				if (line.contains("spawn-position:")) {
					System.out.println("Coordinate line:" + lineNumber);
					String[] tokens = line.split(":");
					int x, y;
					x = Integer.parseInt(tokens[1].replaceAll("\\s+",""));
					y = Integer.parseInt(tokens[2].replaceAll("\\s+",""));
		
					Spawn n = new Spawn(id, x, y);
			
					String json = gson.toJson(n)+",\n";
		
					writer.write(json);
					continue;
				}
			}
			writer.close();
			reader.close();
		}catch (IOException e) {
			e.printStackTrace();
		}		
	} 
}
