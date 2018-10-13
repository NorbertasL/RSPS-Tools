package converter;

import com.google.gson.annotations.SerializedName;

//Abusing Integer and Boolean classes to avoid writing exclusions :)

public class Npc {

	int npcId;
	String name;
	String examine;
	Integer size;

	@SerializedName("walk-radius")
	Integer walk_radius;

	@SerializedName("combat-follow")
	Integer combat_follow;

	Boolean  attackable;
	Boolean  aggressive;
	Boolean  retreats;
	Boolean  poisonous;

	Integer respawn;

	@SerializedName("max-hit")
	Integer max_hit;

	@SerializedName("attack-speed")
	Integer attack_speed;

	@SerializedName("attack-anim")
	Integer attack_anim;

	@SerializedName("defence-anim")
	Integer defence_anim;

	@SerializedName("death-anim")
	Integer death_anim;

	Integer hitpoints;

	@SerializedName("combat-level")
	Integer combat_level;

	@SerializedName("attack-level")
	Integer attack_level;

	@SerializedName("strength-level")
	Integer strength_level;

	@SerializedName("ranged-level")
	Integer ranged_level;

	@SerializedName("magic-level")
	Integer magic_level;

	@SerializedName("defence-melee")
	Integer defence_melee;

	@SerializedName("defence-ranged")
	Integer defence_ranged;

	@SerializedName("defence-magic")
	Integer defence_magic;

	@SerializedName("slayer-req")
	Integer slayer_req;
	
	@SerializedName("aggressive-distance")
	Integer aggresive_distance;

}
