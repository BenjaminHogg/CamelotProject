package myclassproject.mystorygraph;

import java.util.List;
import static myclassproject.mystorygraph.MyStoryEntities.*;

import com.actions.*;
import com.sequences.*;
import com.storygraph.*;

public class MyNodeBuilder extends NodeBuilder {
	public MyNodeBuilder(List<Node> list) {
		super(list);
	}
	// Group Members: Benjamin Hogg
	/**
	 * Write a method for each node. 
	 * Use get to get a reference to the node using its label.
	 * The method adds Camelot actions that execute in order when visiting that node. 
	 * These methods must have a BuilderMethod annotation.
	 */
	@BuilderMethod
	public void rootActions() {
		//Example:
		//var root = get(NodeLabels.root.toString());
		//root.add(new CreateAll(List.of(cottage, town, sword)));
		
		//Benjamin Hogg Testing New Directory Push
		var root = get(MyNodeLabels.root.toString());
		root.clearSequence();
		root.add(new CreateAll(List.of(city, bottle)))
		.add(new SetTitle("The Dark Table"))
		.add(new CreateCharacterSequence(player))
		.add(new SetPosition(player, city, "Alley1"))
		.add(new Unpocket(player, bottle))
		.add(new Kneel(player))
		
		.add(new CreateCharacterSequence(TownPerson1))
		.add(new SetPosition(TownPerson1, city, "Barrel"))
		.add(new CreateCharacterSequence(TownPerson2))
		.add(new SetPosition(TownPerson2, city, "Horse"))
		.add(new CreateCharacterSequence(TownPerson3))
		.add(new SetPosition(TownPerson3, city, "RedHouseDoor"))
		.add(new Face(TownPerson1, TownPerson2)).add(new Face(TownPerson2, TownPerson1))
		
		.add(new CreateCharacterSequence(Recruiter))
		.add(new SetPosition(Recruiter, city, "Bench"))
		
		.add(new SetCameraFocus(player)).add(new ShowMenu());
	}
	//Benjamin Hogg
	@BuilderMethod
	public void streetStartNarration() {
		var streetNar = get(MyNodeLabels.streetNar.toString());
		streetNar.add(new FadeOut()).add(new HideMenu()).add(new FadeIn())
		.add(new HideNarration()).add(new FadeIn()).add(new NarrationSequence("The streets of Camelot are filled with poverty and crime. The Knights of the Round Table and their King, Arthur, have put the city in this sad state. "
				+ "You wake up in a dimly lit alley in a drunken stupor. You are in rough shape, and your breath smells of the half consumed bottle "
				+ "of wine that is now your only possesion. Your rage towards the King and his men grow every day. They've left you destitute. You want to go home but you get the sense someone is watching you."));
	}
	//Benjamin Hogg
	@BuilderMethod
	public void manAppears() {
		var manApp = get(MyNodeLabels.manApp.toString());
		manApp.add(new HideMenu()).add(new EnableInput()).add(new HideNarration())
		.add(new WalkTo(Recruiter, city, "Alley2")).add(new Face(Recruiter, player))
		.add(new Take(Recruiter, bottle, player))
		.add(new DialogSequence(Recruiter, player,List.of("Look at you you're pathetic. Give me that."),
				List.of("ATTACK THE MAN","What do you want?")));
	}
	//Benjamin Hogg
	@BuilderMethod
	public void askRecruiter() {
		var ask = get(MyNodeLabels.ask.toString());
		ask.clearSequence();
		ask.add(new HideDialog()).add(new DialogSequence(Recruiter, player, 
				List.of("I know who you are. I know of your past. I need your help. We can stop the cycle of this kingdom. Will you join me?"), 
				List.of("I'm in.", "No I have no idea what you're talking about. Leave me be.")));
	}
	//Benjamin Hogg
	@BuilderMethod
	public void attackRecruiter() {
		var atkRec = get(MyNodeLabels.atkRec.toString());
		atkRec.clearSequence();
		atkRec.add(new Attack(player, Recruiter, true)).add(new Attack(Recruiter, player, false))
		.add(new Die(player)).add(new FadeOut());
		//Recruiter brings the player to the Dark Table
	}
	//Benjamin Hogg
	@BuilderMethod
	public void dontGoWithRecruiter() {
		var dontGowR = get(MyNodeLabels.dontGowR.toString());
		dontGowR.clearSequence();
		dontGowR.add(new Attack(Recruiter, player, false)).add(new Die(player)).add(new FadeOut());
	}
		//Christian Maron
	@BuilderMethod
	public void theDarkTable() {
	var darkTable = get(MyNodeLabels.darkTable.toString());
	darkTable.add(new CreateAll(List.of(darTable)))
	.add(new CreateCharacterSequence(bandit1))
	.add(new CreateCharacterSequence(bandit2))
	.add(new CreateCharacterSequence(bandit3))
	.add(new SetPosition(bandit1,darTable, "FrontLeftChair"))
	.add(new SetPosition(bandit2,darTable, "FrontRightChair"))
	.add(new SetPosition(bandit3, darTable, "BackLeftChair"))
	.add(new SetPosition(player, darTable, "LeftChair"))
	.add(new DialogSequence(bandit1, player,
	List.of("We are tired of how the kingdom is" +
	"We need you to bring the head of one prominent figure."
	+ "The choice is yours."), null));
		
		
	}
	//Christian Maron
	@BuilderMethod
	public void arthurChoice() {
	var arthur = get(MyNodeLabels.arthur.toString());
	arthur.add(new DialogSequence(bandit1, player, 
	List.of("Arthur has the famed blade Excalibur." +
	"If you wish to kill him, a swordright is hopeless."  +
	"You must take him down from range." +
	"In order to do this, you must become skilled with a bow." +
	"You must obtain a bow from the most famed fletcher, but this task is only the beggining." ), null));
		
	}
	//Christian Maron
	@BuilderMethod
	public void lancelotChoice() {
	var lancelot = get(MyNodeLabels.lancelot.toString());
	lancelot.add(new DialogSequence(bandit2, player,
	List.of("Lancelot is Arthurs right hand man. "
	+ "If you can take him out, Arthur is surely done for. "
	+ "To defeat him, you must become a skilled swordsman. "
	+ "Head to the armory and pick your gear"), null));
	}
	//Christian Maron
	@BuilderMethod
	public void merlinChoice() {
	var merlin = get(MyNodeLabels.merlin.toString())
	merlin.add(new DialogSequence(bandit3, player, 
	"To kill merlin, you must learn the art of wizardry. "
	+ "Merlin will not be slain by a sword, but can be killed by magic. "
	+ "You must devise a plan to do this. "
	+ "How will you take out merlin?"));
	}

	
	
	
	
	
	//Joseph Maggio
	@BuilderMethod
	public void Armory(){
	var armoryNode = get(MyNodeLabels.armory.toString());
    	armoryNode.clearSequence();
    	//Benjamin Hogg
    	armoryNode.add(new CreateAll(List.of(armory, halberd, tankArmor, blunderbuss, axe, mace, dagger)))
    	add(new SetPosition(player, armory, "Door")).add(new SetPosition(Ally, armory, "Anvil"));
    
    	// Set the scene
    	armoryNode.add(new HideMenu())
              .add(new EnableInput())
              .add(new FadeIn())
              .add(new NarrationSequence("In the armory, your ally explains to you that there are many different ways you can approach a swordfight. "
                + "He says that you can either be a tank, focusing your style on defense, armor, and shields, "
                + "you can be an assassin, focusing on dexterity and agility, "
                + "or you can be what he refers to as a warlord, with a more aggressive fighting style and putting your trust in your violent weaponry."));

    	// Present choices
    	armoryNode.add(new DialogSequence(Ally, player, 
            List.of("Which path will you take?"), 
            List.of("Tank", "Assassin", "Warlord")));
	}

	//Joseph Maggio
	@BuilderMethod
	public void fletcher() {
    		var fletcherNode = get(MyNodeLabels.fletcher.toString());
    		fletcherNode.clearSequence();
    
    		// Set the scene
    		fletcherNode.add(new HideMenu())
                	.add(new EnableInput())
                	.add(new FadeIn())
                	.add(new NarrationSequence("The fletcher explains to you that to become skilled with a bow, you must understand all aspects of archery. "
                    	+ "He wants to teach you the art of marksmanship, personal agility and stealth, bow stringing and crafting, and arrow making and imbuing. "
                    	+ "He allows you to choose what to tackle first."));

    	// Present choices
    	fletcherNode.add(new DialogSequence(Fletcher, player, 
            	List.of("What do you want to learn first?"), 
            	List.of("Marksmanship", "Agility and Stealth", "Crafting", "Arrow Making")));
	}
	//Joseph Maggio
	@BuilderMethod
	public void warlordWeaponSelection() {
    		var warlordWeaponNode = get(MyNodeLabels.warlordWeaponSelection.toString());
    		warlordWeaponNode.clearSequence();
    
   		 // Set the scene
   		 warlordWeaponNode.add(new HideMenu())
                     	.add(new EnableInput())
                     	.add(new FadeIn())
                     	.add(new NarrationSequence("As a warlord, you rely on your intense weaponry. "
                         	+ "The armorer shows you a rack of large weapons—some exotic, some familiar, but all terrifying. "
                         	+ "Pick your weapon:"));

    		// Present weapon choices
    		warlordWeaponNode.add(new DialogSequence(Armorer, player, 
           	List.of("Which weapon will you wield?"), 
            	List.of("War Axe", "Chain Mace", "What even is that?")));
	}
	
	//Benjamin Hogg
	@BuilderMethod
	//Begin tank node
	public void tankWeaponSelection() {
		var tankWeaponNode = get(MyNodeLabels.tankWeaponNode.toString());
		tankWeaponNode.clearsequence();
		tankWeaponNode.add(new WalkTo(Ally, armory, "Chest")).add(new Unpocket(Ally, halberd))
		.add(new PlayerInteraction(takeHalberd, Ally, PlayerInteraction.Icons, "Take your weapon."));
	}
	@BuilderMethod
	public void takeHalberd() {
		var takehal = get(MyNodeLabels.takehal.toString());
		takehal.add(new Give(Ally, halberd, player)).add(new Give(Ally, tankArmor, player)).add(new SetClothing(player, HeavyArmour))
		.add(new DialogSequence(Armorer, Player, List.of("Suits you well. Lets get back to the Dark Table and get ready to move. Meet me out back.", null)))
	}
	
	@BuilderMethod
	public void explainDuel() {
		var expDuel = get(MyNodeLabels.expDuel.toString());
		expDuel.add(new FadeIn()).add(new setPosition(player, darTable, "Door"))
		.add(new DialogSequence(bandit1, player,"We have recieved word that Lancelot will be in the market tonight. We think this would"
				+ "be a goot time to strike. A duel in the streets would make a statement and accomplish our goal. Get it done.", null))
	}
	
	@BuilderMethod
	public void prepareForDuel() {
		var inMarket = get(MyNodeLabels.inMarket.toString());
		inMarket.add(new CreateAll(List.of(market, lancelot, marketPerson1, marketPerson2, marketPerson3, sword)))
		.add(new setPosition(player, market, "Gate")).add(new setPosition(lancelot, market, "Exit")).add(new setPosition(marketPerson1, market, "Target"))
		.add(new setPosition(marketPerson2, market, "BigStall")).add(new setPosition(marketPerson3, market, "SmallStall"))
		.add(new(PlayerInteraction(talkToLancelot, lancelot, PlayerInteraction.Icons, "Confront Lancelot")))
	}
	
	@BuilderMethod
	public void theDuel() {
		var duel = get(MyNodeLabels.expDuel.toString());
		duel.add(new Draw(lancelot, sword)).add(new Draw(player, halberd)).add(new SetNight())
		.add(new Attack(player, lancelot, true)).add(new Attack(lancelot, player, false)).add(new Attack(player, lancelot, false))
		.add(new Die(lancelot));
	}
	
	@BuilderMethod
	public void returnToDarkTable() {
		var returnToTable = get(MyNodeLabels.returnToTable.toString());
		returnToTable.add(new setPosition(player, darTable, "Door")).add(new WalkTo(bandit1, darTable, "Door"))
		.add(new DialogSequence(bandit1, player, "Congrats warrior. You've done a great thing tonight. Join us in a feast to celebrate.", null))
		.add(new FadeOut());
	}
	//Maybe make a training sequence for the different weapons eventually. 
	@BuilderMethod
	public void Blunderbuss() {
		var blunderbuss = get(MyNodeLabels.blunderbuss.toString());
		blunderbuss.add(new WalkTo(Ally, armory, "Table")).add(new Take(Ally, blunderbuss)).add(new Give(Ally, blunderbuss, player))
		.add(new DialogSequence(Ally, player, "This my friend is called a blunderbuss. You get close enough and this thing is blowing any target to pieces. When you are ready let's "
				+ "head back and discuss the plan with the group.")).add(new setClothing(player, LightArmour));
	}
	
	@BuilderMethod
	public void WarAxe() {
		var waraxe = get(MyNodeLabels.waraxe.toString());
		waraxe.add(new WalkTo(Ally, armory, "Table")).add(new Take(Ally, axe)).add(new Give(Ally, axe, player))
		.add(new DialogSequence(Ally, player, "Great choice my friend. You will be a force to be reckoned with on the battle field with this. When you are ready let's "
				+ "head back and discuss the plan with the group.")).add(new setClothing(player, LightArmour));
	}
	
	@BuilderMethod
	public void ChainMace() {
		var chainmace = get(MyNodeLabels.chainmace.toString());
		chainmace.add(new WalkTo(Ally, armory, "Table")).add(new Take(Ally, mace)).add(new Give(Ally, mace, player))
		.add(new DialogSequence(Ally, player, "A wild and mighty weapon. Great choice. You will surely put on a good show with this. When you are ready let's "
				+ "head back and discuss the plan with the group.")).add(new setClothing(player, LightArmour));
	}
	
	@BuilderMethod
	public void TheAmbushPlan() {
		var ambushPlan = get(MyNodeLabels.ambushPlan.toString());
		ambushPlan.add(new FadeIn()).add(new setPosition(player, darTable, "Door"))
		.add(new DialogSequence(bandit1, player,"Today Lancelot will be travelling to another city in order to meet with nobles. "
				+ "As always he likes to make a scene of his departure and will be parading out of the city. We want to make a statement"
				+ "with our rebellion and think you should ambush him in the street. Take him out and get out of there. We know you can"
				+ "do it. Quickly now, exit out front to get out there and get it done.", null));
	}
	//Maybe make multiple ambushes for different weapons eventually. 
	@BuilderMethod
	public void TheAmbush() {
		var ambush = get(MyNodeLabels.ambush.toString());
		ambush.add(new CreateAll(List.of(ambushStreet, lancelot, parader1, parader2, parader 3, sword)))
		.add(new setPosition(player, ambushStreet, "NorthEnd")).add(new setPosition(lancelot, ambushStreet, "EastEnd"))
		.add(new setPosition(parader1, ambushStreet, "BrownHouseDoor")).add(new setPosition(parader2, ambushStreet, "Fountain")).add(parader3, ambushStreet, "Fountain")
		.add(new PlayerInteraction(talkToLancelot, lancelot, PlayerInteraction.Icons, "Attack!"));
	}
	@BuilderMethod
	public void TheAmbush2() {
		var ambush2 = get(MyNodeLabels.ambush,toString());
		ambush2.add(new Draw(lancelot, sword)).add(new Attack(player, lancelot, false)).add(new Die(lancelot));
	}
	
	@BuilderMethod
	public void assassinWeaponSelection() {
		var assassinWeaponNode = get(MyNodeLabels.assassinWeaponNode.toString());
		assassinWeaponNode.clearsequence();
		assassinWeaponNode.add(new WalkTo(Ally, armory, "Backdoor")).add(new Unpocket(Ally, dagger))
		.add(new PlayerInteraction(takeDagger, Ally, PlayerInteraction.Icons, "Talk to armorer"));
	}
	//Maybe add a node or something where the armorer explains the mercenary eventually
	@BuilderMethod
	public void TheMercenary() {
		var mercenary = get(MyNodeLabels.mercenary.toString());
		mercenary.add(new CreateAll(List.of(mercenaryCamp, mercenary, blade)))
		.add(new setPosition(player, mercenaryCamp, "Exit")).add(new setPosition(mercenary, mercenaryCamp, "Chest"))
		.add(DialogSequence(mercenary, player, "Always a pleasure to meet one of you dark table folks. So you wish to become an assassin? It will"
				+ " be intese training. Meet me over by the barrel and we can begin.")).add(new WalkTo(mercenary, mercenaryCamp, "Barrel"))
		.add(new PlayerInteraction(talkToMercenary, mercenary, PlayerInteraction.Icons, "Begin Training"));
	}
	@BuilderMethod
	public void MercenaryTraining() {
		var mercTraining = get(MyNodeLabels.mercTraining.toString());
		mercTraining.add(new Draw(mercenary, blade)).add(new Attack(player, mercenary, true))
		.add(new Attack(player, mercenary, true)).add(new Attack(mercenary, player, false)).add(DialogSequence(mercenary, player, "Focus kid. "
				+ "Look for vunerabilities. Get me when I am at my weakest and strike with precision."))
		.add(new Attack(mercenary, player, true)).add(new Attack(player, mercenary, false)).add(new Clap(mercenary))
		.add(new DialogSequence(mercenary, player, "Well done kid. Here take this. You are ready. Go get to work and make me proud.")).add(new setClothing(player, Bandit));
	}
		
}
