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
	public static final Place armory = new Place("armory", PlaceTypes.Blacksmith);
	public static final Characters lancelot = new Characters("lancelot", BodyTypes.D, Clothing.King, HairStyle.Musketeer, Colors.Black, 5);
	public static final Characters Ally = new Characters("Ally", BodyTypes.D, Clothing.LightArmour, HairStyle.Short, Colors.Brown, 5);
	public static final Characters mercenary = new Characters("mercenary", BodyTypes.D, Clothing.Bandit, HairStyle.Bald, Colors.Black, 5);
	public static final Place mercenaryCamp = new Place("mercenaryCamp", PlaceTypes.Camp);
	public static final Place ambushStreet = new Place("ambushStreet", PlaceTypes.Courtyard);
	public static final Item halberd = new Item("halberd", ItemTypes.Bread);
	public static final Item tankArmor = new Item("tankArmor", ItemTypes.Helmet);
	public static final Item blunderbuss = new Item("blunderbuss", ItemTypes.ChickenLeg);
	public static final Item axe = new Item("axe", ItemTypes.Hammer);
	public static final Item mace = new Item("mace", ItemTypes.Torch);
	public static final Item dagger = new Item("dagger", ItemTypes.Sword);

	//Christian Maron
	public static final Characters bandit1 = new Characters("bandit1", BodyTypes.D, Clothing.LightArmour, HairStyle.Long, Colors.Black, 5);
	public static final Characters bandit2 = new Characters("bandit2", BodyTypes.D, Clothing.LightArmour, HairStyle.Long, Colors.Black, 5);
	public static final Characters bandit3 = new Characters("bandit3", BodyTypes.D, Clothing.LightArmour, HairStyle.Long, Colors.Black, 5);
	public static final Place darTable = new Place("DarTable", PlaceTypes.DiningRoom);


	//Joseph Maggio
	public static final Characters fletcher = new Characters("fletcher", BodyTypes.H, Clothing.LightArmour,HairStyle.Short, Colors.Brown,5);
	public static final Characters arthur = new Characters("arthur",BodyTypes.F, Clothing.King, HairStyle.Spiky, Colors.Blonde,1);
	public static final Characters merlin = new Characters("merlin", BodyTypes.A, Clothing.Priest, HairStyle.Mage,Colors.Gray,2);
	public static final Item bow = new Item("bow", ItemTypes.InkandQuill);
	public static final Place darkTable = new Place("dark table", PlaceTypes.Dungeon);
	public static final Place castleHall = new Place("castle hall", PlaceTypes.GreatHall);
	public static final Place forest = new Place("forest", PlaceTypes.ForestPath);
	public static final Characters noble1 = new Characters("noble1",BodyTypes.F, Clothing.Noble,HairStyle.Short, Colors.Gray, 2);
	public static final Characters noble2 = new Characters("noble2",BodyTypes.C, Clothing.Noble,HairStyle.Short, Colors.Gray, 2);
	public static final Characters noble3 = new Characters("noble3",BodyTypes.F, Clothing.Noble,HairStyle.Short, Colors.Blonde, 2);
	public static final Characters armorer = new Characters("armorer",BodyTypes.F,Clothing.Merchant,HairStyle.Short,Colors.Brown,2);
	public static final Characters potionWarlock = new Characters("potionWarlock",BodyTypes.F,Clothing.Warlock,HairStyle.Short,Colors.Red,2);
	public static final Item potion = new Item("potion", ItemTypes.Bottle);
	public static final Place potionRoom = new Place("Potion room", PlaceTypes.AlchemyShop);
	public static final Characters darkArtsWarlock = new Characters("Dark arts Warlock",BodyTypes.F,Clothing.Warlock,HairStyle.Short,Colors.Red,2);
	public static final Item wand = new Item("wand", ItemTypes.Apple);
	public static final Place darkArtsRoom = new Place("dark arts room",PlaceTypes.Library);
	public static final Place potionBattleArea = new Place("potion battle area", PlaceTypes.Ruins);
	public static final Place darkArtsBattleArea = new Place("dark arts battle area", PlaceTypes.Ruins);
	public static final Item sword = new Item("sword",ItemTypes.Sword);
}
