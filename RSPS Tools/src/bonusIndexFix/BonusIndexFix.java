package bonusIndexFix;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/*
 * Tool used to change prayer index from 11 to 13 in the item json
 */


public class BonusIndexFix {

	public static void main(String[] args) {
		
		JsonParser parser = new JsonParser();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();


		try{
			File oldItems = new File(System.getProperty("user.dir")+"/items.json");
			File newItems = new File(System.getProperty("user.dir")+"/FIXE_ITEMS.json");
			
			BufferedWriter itemWriter = new BufferedWriter(new FileWriter(newItems));
			
			JsonElement jsontree = parser.parse(new FileReader(oldItems));
			
			//Converting it into an array
			JsonArray itemArray = jsontree.getAsJsonArray();
			
			for(JsonElement je : itemArray){
				JsonObject jo = je.getAsJsonObject();
				if(jo.has("bonus")){
					
					//we copy the array of bonuses
					JsonArray  bonuses = jo.get("bonus").getAsJsonArray();
					
					//we delete the element
					jo.remove("bonus");
					
					//TODO recreate the array
					JsonArray remadeBonuses = new JsonArray();
					if(bonuses.size() != 18){
						throw new Exception("array is bigger than 18");
					}
					
					JsonElement index11 = null;
					JsonElement index13 = null;
					
					//stupid design force me to re-copy this thing
					for(int i = 0; i < bonuses.size(); i++){
						if(i == 11){
							index11 = bonuses.get(i);
						}else if(i == 13){
							index13 = bonuses.get(i);
						}
						
						remadeBonuses.add(bonuses.get(i));						
					}
					if(index11 == null || index13 == null)
						throw new Exception("Array fucked up for index 11 or 13");
					remadeBonuses.set(11, index13);
					remadeBonuses.set(13, index11);
					
					
					
					//we add the new element array back into it
					jo.add("bonus", remadeBonuses);
					if(bonuses.size() != 18)
						System.out.println("Arrays size:"+bonuses.size());
				}
					
				//System.out.println(jo.get("name"));
				jo.remove("name");
				jo.addProperty("name", "nothing");
			}
			
			itemWriter.write(gson.toJson(itemArray));

			System.out.println("Array size is:"+itemArray.size());
			
			itemWriter.close();
			
		}catch (JsonIOException e) {
	        e.printStackTrace();
	    }catch (JsonSyntaxException e) {
	        e.printStackTrace();
	    }catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }catch (Exception e) {
	        e.printStackTrace();
	    }
		    
	}

}
