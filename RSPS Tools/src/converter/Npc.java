package converter;

import com.google.gson.annotations.SerializedName;

public class Npc {

	int npcId;
	String name;
	String examine;
	int size;

	@SerializedName("walk-radius")
	int walk_radius;

	@SerializedName("combat-follow")
	int combat_follow;

	boolean attackable;
	boolean aggressive;
	boolean retreats;
	boolean poisonous;

	int respawn;

	@SerializedName("max-hit")
	int max_hit;

	@SerializedName("attack-speed")
	int attack_speed;

	@SerializedName("attack-anim")
	int attack_anim;

	@SerializedName("defence-anim")
	int defence_anim;

	@SerializedName("death-anim")
	int death_anim;

	int hitpoints;

	@SerializedName("combat-level")
	int combat_level;

	@SerializedName("attack-level")
	int attack_level;

	@SerializedName("strength-level")
	int strength_level;

	@SerializedName("ranged-level")
	int ranged_level;

	@SerializedName("magic-level")
	int magic_level;

	@SerializedName("defence_melee")
	int defence_melee;

	@SerializedName("defence-ranged")
	int defence_ranged;

	@SerializedName("defence-magic")
	int defence_magic;

	@SerializedName("slayer-req")
	int slayer_req;

}
