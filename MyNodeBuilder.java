package myclassproject.mystorygraph;

import java.util.List;
import static myclassproject.mystorygraph.MyStoryEntities.*;

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
		
		//Benjamin Hogg
		var root = get(NodeLabels.root.toString());
		root.clearSequence();
		root.add(new CreateAll(List.of(city, bottle)))
		.add(new.SetTitle("The Dark Table"))
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
		var streetNar = get(NodeLabels.streetNar.toString());
		streetNar.add(new FadeOut()).add(new HideMenu()).add(new FadeIn())
		.add(new HideNarration()).add(new FadeIn()).add(new NarrationSequence("The streets of Camelot are filled with poverty and crime. The Knights of the Round Table and their King, Arthur, have put the city in this sad state. "
				+ "You wake up in a dimly lit alley in a drunken stupor. You are in rough shape, and your breath smells of the half consumed bottle "
				+ "of wine that is now your only possesion. Your rage towards the King and his men grow every day. They've left you destitute. You want to go home but you get the sense someone is watching you."));
	}
	//Benjamin Hogg
	@BuilderMethod
	public void manAppears() {
		var manApp = get(NodeLabels.manApp.toString());
		manApp.add(new HideMenu()).add(new EnableInput()).add(new HideNarration())
		.add(new WalkTo(Recruiter, "Alley2")).add(new Face(Recruiter, player))
		.add(new Take(Recruiter, bottle, player))
		.add(new DialogSequence(Recruiter, player,List.of("Look at you you're pathetic. Give me that."),
				List.of("ATTACK THE MAN","What do you want?"));
	}
	//Benjamin Hogg
	@BuilderMethod
	public void askRecruiter() {
		var ask = get(NodeLabels.ask.toString());
		ask.clearSequence();
		ask.add(new HideDialog()).add(new DialogSequence(Recruiter, player, 
				List.of("I know who you are. I know of your past. I need your help. We can stop the cycle of this kingdom. Will you join me?"), 
				List.of("I'm in.", "No I have no idea what you're talking about. Leave me be.")));
	}
	//Benjamin Hogg
	@BuilderMethod
	public void attackRecruiter() {
		var atkRec = get(NodeLabels.atkRec.toString());
		atkRec.clearSequence();
		atkRec.add(new Attack(player, Recruiter, true)).add(new Attack(Recruiter, player, false))
		.add(new Die(player)).add(new FadeOut());
		//Recruiter brings the player to the Dark Table
	}
	//Benjamin Hogg
	@BuilderMethod
	public void dontGoWithRecruiter() {
		var dontGowR = get(NodeLabels.dontGowR.toString());
		dontGowR.clearSequence();
		dontGowR.add(new Attack(Recruiter, player, false)).add(new Die(player)).add(new FadeOut());
	}
}
	//Joseph Maggio
	@BuilderMethode
	public void Armory(){
	var armoryNode = get(NodeLabels.armory.toString());
    	armoryNode.clearSequence();
    
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
    		var fletcherNode = get(NodeLabels.fletcher.toString());
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
    		var warlordWeaponNode = get(NodeLabels.warlordWeaponSelection.toString());
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
