package myclassproject.mystorygraph;

import com.entities.*;
import com.enums.*;

public final class MyStoryEntities {
	//Create an instance of Character, Place, Furniture, and Item classes 
	//for each of the characters, places, furniture, and items in your story
	//Make that instance public static final
	//e.g. public static final Characters player = new Characters("Player", BodyTypes.D, Clothing.Peasant, HairStyle.Short, Colors.Black, 6);
	//You can access these instances in your EdgeBuilder and NodeBuilder classes by importing:
	//import static myclassproject.mystorygraph.MyStoryEntities.*;
	
	//Benjamin Hogg
	public static final Characters player = new Characters("player", BodyTypes.F, Clothing.Beggar, HairStyle.Short_Full, Colors.Brown, 6);
	public static final Characters TownPerson1 = new Characters("TownPerson1", BodyTypes.H, Clothing.Peasant, HairStyle.Short, Colors.Gray, 4);
	public static final Characters TownPerson2 = new Characters("TownPerson2", BodyTypes.G, Clothing.Peasant, HairStyle.Short, Colors.Gray, 4);
	public static final Characters TownPerson3 = new Characters("TownPerson3", BodyTypes.B, Clothing.Peasant, HairStyle.Long, Colors.Black, 6);
	public static final Characters Recruiter = new Characters("Recruiter", BodyTypes.D, Clothing.LightArmour, HairStyle.Mage_Full, Colors.Black, 5);
	public static final Item bottle = new Item("bottle", ItemTypes.Bottle);
	public static final Place city = new Place("city", PlaceTypes.City);

	//Christian Maron
	public static final Characters bandit1 = new Characters("bandit1", BodyTypes.D, Clothing.LightArmour, HairStyle.Long, Colors.Black, 5);
	public static final Characters bandit2 = new Characters("bandit2", BodyTypes.D, Clothing.LightArmour, HairStyle.Long, Colors.Black, 5);
	public static final Characters bandit3 = new Characters("bandit3", BodyTypes.D, Clothing.LightArmour, HairStyle.Long, Colors.Black, 5);
	public static final Place darTable = new Place("DarTable", PlaceTypes.DiningRoom);

}
