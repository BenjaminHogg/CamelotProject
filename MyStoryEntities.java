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
	public static final Characters player = new Characters("Jimbo", BodyTypes.F, Clothing.Beggar, HairStyle.Short_Full, Colors.Brown, 6);
	public static final Characters TownPerson1 = new Characters("TownPerson1", BodyTypes.H, Clothing.Peasant, HairStyle.Short, Colors.Gray, 4);
	public static final Characters TownPerson2 = new Characters("TownPerson2", BodyTypes.G, Clothing.Peasant, HairStyle.Short, Colors.Gray, 4);
	public static final Characters TownPerson3 = new Characters("TownPerson3", BodyTypes.B, Clothing.Peasant, HairStyle.Long, Colors.Black, 6);
	public static final Characters Recruiter = new Characters("Recruiter", BodyTypes.D, Clothing.LightArmour, HairStyle.Mage_Full, Colors.Black, 5);
	public static final Item bottle = new Item("bottle", ItemTypes.Bottle);
	public static final Place city = new Place("city", PlaceTypes.City);
	public static final Place armory = new Place("armory", PlaceTypes.Blacksmith);
	public static final Characters lancelot = new Characters("Lancelot", BodyTypes.D, Clothing.King, HairStyle.Musketeer, Colors.Black, 5);
	public static final Characters Ally = new Characters("Glorbis", BodyTypes.D, Clothing.LightArmour, HairStyle.Short, Colors.Brown, 5);
	public static final Characters Mercenary = new Characters("Chad", BodyTypes.D, Clothing.Bandit, HairStyle.Bald, Colors.Black, 5);
	public static final Place mercenaryCamp = new Place("mercenaryCamp", PlaceTypes.Camp);
	public static final Place ambushStreet = new Place("ambushStreet", PlaceTypes.Courtyard);
	public static final Item halberd = new Item("halberd", ItemTypes.Bread);
	public static final Item tankArmor = new Item("tankArmor", ItemTypes.Helmet);
	public static final Item Blunderbussitem = new Item("Blunderbussitem", ItemTypes.ChickenLeg);
	public static final Item axe = new Item("axe", ItemTypes.Hammer);
	public static final Item mace = new Item("mace", ItemTypes.Torch);
	public static final Item dagger = new Item("dagger", ItemTypes.Bread);
	public static final Place market = new Place("market", PlaceTypes.Courtyard);
	public static final Characters marketPerson1 = new Characters("marketPerson1", BodyTypes.D, Clothing.Peasant, HairStyle.Short, Colors.Gray, 4);
	public static final Characters marketPerson2 = new Characters("marketPerson2", BodyTypes.G, Clothing.Peasant, HairStyle.Short, Colors.Gray, 3);
	public static final Characters marketPerson3 = new Characters("marketPerson3", BodyTypes.B, Clothing.Peasant, HairStyle.Long, Colors.Black, 5);
	public static final Characters parader1 = new Characters("parader1", BodyTypes.D, Clothing.Merchant, HairStyle.Short, Colors.Gray, 4);
	public static final Characters parader2 = new Characters("parader2", BodyTypes.F, Clothing.Merchant, HairStyle.Short, Colors.Gray, 3);
	public static final Characters parader3 = new Characters("parader3", BodyTypes.H, Clothing.Merchant, HairStyle.Long, Colors.Black, 5);
	public static final Item blade = new Item("blade", ItemTypes.Sword);
	
	//Christian Maron
	public static final Characters bandit1 = new Characters("Greg", BodyTypes.D, Clothing.LightArmour, HairStyle.Long, Colors.Black, 5);
	public static final Characters bandit2 = new Characters("Mort", BodyTypes.D, Clothing.LightArmour, HairStyle.Long, Colors.Black, 5);
	public static final Characters bandit3 = new Characters("Bob", BodyTypes.D, Clothing.LightArmour, HairStyle.Long, Colors.Black, 5);
	public static final Place darTable = new Place("DarTable", PlaceTypes.DiningRoom);


	//Joseph Maggio
	public static final Characters fletcher = new Characters("fletcher", BodyTypes.H, Clothing.LightArmour,HairStyle.Short, Colors.Brown,5);
	public static final Characters arthur = new Characters("arthur",BodyTypes.F, Clothing.King, HairStyle.Spiky, Colors.Blonde,1);
	public static final Characters merlin = new Characters("merlin", BodyTypes.H, Clothing.Priest, HairStyle.Mage_Full,Colors.Gray,2);
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
	public static final Item wand1 = new Item("wand1", ItemTypes.Apple);
	public static final Item wand = new Item("wand1", ItemTypes.Apple);
	public static final Place darkArtsRoom = new Place("dark arts room",PlaceTypes.AlchemyShop);
	public static final Place potionBattleArea = new Place("potion battle area", PlaceTypes.ForestPath);
	public static final Place darkArtsBattleArea = new Place("dark arts battle area", PlaceTypes.ForestPath);
	public static final Item sword = new Item("sword",ItemTypes.Sword);
}
