package myclassproject.mystorygraph;

import java.util.List;
import static myclassproject.mystorygraph.MyStoryEntities.*;

import com.actions.*;
import com.enums.Clothing;
import com.sequences.*;
import com.storygraph.*;

public class MyNodeBuilder extends NodeBuilder {
	public MyNodeBuilder(List<Node> list) {
		super(list);
	}
	// Group Members: Benjamin Hogg, Joseph Maggio, Christian Maron
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
		root.add(new CreateAll(List.of(city, bottle)))
		.add(new SetTitle("The Dark Table"))
		.add(new CreateCharacterSequence(player))
		.add(new SetPosition(player, city, "Alley"))
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
		atkRec.add(new HideDialog())
		.add(new Attack(player, Recruiter, true)).add(new Attack(Recruiter, player, false))
		.add(new Die(player));
	
		
		
		//Recruiter brings the player to the Dark Table
	}
	//Benjamin Hogg
	@BuilderMethod
	public void dontGoWithRecruiter() {
		var dontGowR = get(MyNodeLabels.dontGowR.toString());
		dontGowR.clearSequence();
		dontGowR.add(new HideDialog()).add(new Attack(Recruiter, player, false)).add(new Die(player)).add(new FadeOut());
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
	.add(new SetCameraFocus(player))
	.add(new DialogSequence(bandit1, player,
	List.of("We are tired of how the kingdom is" +
	"We need you to bring the head of one prominent figure."
	+ "The choice is yours."), List.of("Next")));
		
		
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
	"You must obtain a bow from the most famed fletcher, but this task is only the beggining." ), List.of()));
		
	}
	//Christian Maron
	@BuilderMethod
	public void lancelotChoice() {
	var lancelot = get(MyNodeLabels.lancelot.toString());
	lancelot.add(new DialogSequence(bandit2, player,
	List.of("Lancelot is Arthurs right hand man. "
	+ "If you can take him out, Arthur is surely done for. "
	+ "To defeat him, you must become a skilled swordsman. "
	+ "Head to the armory and pick your gear"), List.of("Next")));
	}
	//Christian Maron
	@BuilderMethod
	public void merlinChoice() {
	var merlin = get(MyNodeLabels.merlin.toString());
	merlin.add(new DialogSequence(bandit3, player, 
	List.of("To kill merlin, you must learn the art of wizardry. "
	+ "Merlin will not be slain by a sword, but can be killed by magic. "
	+ "You must devise a plan to do this. "
	+ "How will you take out merlin?"),List.of("Next")));
	}

	
	
	
	
	
	//Joseph Maggio
	@BuilderMethod
	public void Armory(){
	var armoryNode = get(MyNodeLabels.armory.toString());
    	armoryNode.clearSequence();
    	//Benjamin Hogg
    	armoryNode.add(new CreateAll(List.of(armory, halberd, tankArmor, Blunderbussitem, axe, mace, dagger)))
    	.add(new SetPosition(player, armory, "Door")).add(new SetPosition(Ally, armory, "Anvil"));
    
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
	public void fletcher(){
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
    	fletcherNode.add(new DialogSequence(fletcher, player, 
            	List.of("What do you want to learn first?"), 
            	List.of("Marksmanship", "Agility and Stealth", "Crafting", "Arrow Making")));
	}
	//Joseph Maggio
	@BuilderMethod
	public void warlordWeaponSelection() {
    		var warlordWeaponNode = get(MyNodeLabels.warlordWeapon.toString());
    		warlordWeaponNode.clearSequence();
    
   		 // Set the scene
   		 warlordWeaponNode.add(new HideMenu())
                     	.add(new EnableInput())
                     	.add(new FadeIn())
                     	.add(new NarrationSequence("As a warlord, you rely on your intense weaponry. "
                         	+ "The armorer shows you a rack of large weapons—some exotic, some familiar, but all terrifying. "
                         	+ "Pick your weapon:"));

    		// Present weapon choices
    		warlordWeaponNode.add(new DialogSequence(armorer, player, 
           	List.of("Which weapon will you wield?"), 
            	List.of("War Axe", "Chain Mace", "What even is that?")));
	}
	
	//Benjamin Hogg
	@BuilderMethod
	//Begin tank node
	public void tankWeaponSelection() {
		var tankWeaponNode = get(MyNodeLabels.tankWeaponNode.toString());
		tankWeaponNode.clearSequence();
		tankWeaponNode.add(new WalkTo(Ally, armory, "Chest")).add(new Unpocket(Ally, halberd));
	}
	@BuilderMethod
	public void takeHalberd() {
		var takehal = get(MyNodeLabels.takeHal.toString());
		takehal.add(new Give(Ally, halberd, player)).add(new Give(Ally, tankArmor, player)).add(new SetClothing(player, Clothing.HeavyArmour))
		.add(new DialogSequence(armorer, player, List.of("Suits you well. Lets get back to the Dark Table and get ready to move. Meet me out back."), List.of("")));
	}
	
	@BuilderMethod
	public void explainDuel() {
		var expDuel = get(MyNodeLabels.expDuel.toString());
		expDuel.add(new FadeIn()).add(new SetPosition(player, darTable, "Door"))
		.add(new DialogSequence(bandit1, player, List.of("We have recieved word that Lancelot will be in the market tonight. We think this would"
				+ "be a goot time to strike. A duel in the streets would make a statement and accomplish our goal. Get it done."), List.of("Next")));
	}
	
	@BuilderMethod
	public void prepareForDuel() {
		var inMarket = get(MyNodeLabels.inMarket.toString());
		inMarket.add(new CreateAll(List.of(market, lancelot, marketPerson1, marketPerson2, marketPerson3, sword)))
		.add(new SetPosition(player, market, "Gate")).add(new SetPosition(lancelot, market, "Exit")).add(new SetPosition(marketPerson1, market, "Target"))
		.add(new SetPosition(marketPerson2, market, "BigStall")).add(new SetPosition(marketPerson3, market, "SmallStall"));
	}
	
	@BuilderMethod
	public void theDuel() {
		var duel = get(MyNodeLabels.duel.toString());
		duel.add(new Draw(lancelot, sword)).add(new Draw(player, halberd)).add(new SetNight())
		.add(new Attack(player, lancelot, true)).add(new Attack(lancelot, player, false)).add(new Attack(player, lancelot, false))
		.add(new Die(lancelot));
	}
	
	@BuilderMethod
	public void returnToDarkTable() {
		var returnToTable = get(MyNodeLabels.returnToTable.toString());
		returnToTable.add(new SetPosition(player, darTable, "Door")).add(new WalkTo(bandit1, darTable, "Door"))
		.add(new DialogSequence(bandit1, player, List.of("Congrats warrior. You've done a great thing tonight. Join us in a feast to celebrate."), List.of("Next")));;
	}
	//Maybe make a training sequence for the different weapons eventually. 
	@BuilderMethod
	public void Blunderbuss() {
		var blunderbuss = get(MyNodeLabels.blunderbuss.toString());
		blunderbuss.add(new WalkTo(Ally, armory, "Table")).add(new Take(Ally, Blunderbussitem)).add(new Give(Ally, Blunderbussitem, player))
		.add(new DialogSequence(Ally, player,List.of("This my friend is called a blunderbuss. You get close enough and this thing is blowing any target to pieces. When you are ready let's "
				+ "head back and discuss the plan with the group."), List.of("Next")).add(new SetClothing(player, Clothing.LightArmour)));
	}
	
	@BuilderMethod
	public void WarAxe() {
		var waraxe = get(MyNodeLabels.waraxe.toString());
		waraxe.add(new WalkTo(Ally, armory, "Table")).add(new Take(Ally, axe)).add(new Give(Ally, axe, player))
		.add(new DialogSequence(Ally, player, List.of("Great choice my friend. You will be a force to be reckoned with on the battle field with this. When you are ready let's "
				+ "head back and discuss the plan with the group."), List.of("Next")).add(new SetClothing(player, Clothing.LightArmour)));
	}
	
	@BuilderMethod
	public void ChainMace() {
		var chainmace = get(MyNodeLabels.chainmace.toString());
		chainmace.add(new WalkTo(Ally, armory, "Table")).add(new Take(Ally, mace)).add(new Give(Ally, mace, player))
		.add(new DialogSequence(Ally, player, List.of("A wild and mighty weapon. Great choice. You will surely put on a good show with this. When you are ready let's "
				+ "head back and discuss the plan with the group."), List.of("Next")).add(new SetClothing(player, Clothing.LightArmour)));
	}
	
	@BuilderMethod
	public void TheAmbushPlan() {
		var ambushPlan = get(MyNodeLabels.ambushPlan.toString());
		ambushPlan.add(new FadeIn()).add(new SetPosition(player, darTable, "Door"))
		.add(new DialogSequence(bandit1, player, List.of("Today Lancelot will be travelling to another city in order to meet with nobles. "
				+ "As always he likes to make a scene of his departure and will be parading out of the city. We want to make a statement"
				+ "with our rebellion and think you should ambush him in the street. Take him out and get out of there. We know you can"
				+ "do it. Quickly now, exit out front to get out there and get it done."), List.of("Next")));
	}
	//Maybe make multiple ambushes for different weapons eventually. 
	@BuilderMethod
	public void TheAmbush() {
		var ambush = get(MyNodeLabels.ambush.toString());
		ambush.add(new CreateAll(List.of(ambushStreet, lancelot, parader1, parader2, parader3, sword)))
		.add(new SetPosition(player, ambushStreet, "NorthEnd")).add(new SetPosition(lancelot, ambushStreet, "EastEnd"))
		.add(new SetPosition(parader1, ambushStreet, "BrownHouseDoor")).add(new SetPosition(parader2, ambushStreet, "Fountain")).add(new SetPosition(parader3, ambushStreet, "Fountain"));
	}
	@BuilderMethod
	public void TheAmbush2() {
		var ambush2 = get(MyNodeLabels.ambush.toString());
		ambush2.add(new Draw(lancelot, sword)).add(new Attack(player, lancelot, false)).add(new Die(lancelot));
	}
	
	@BuilderMethod
	public void assassinWeaponSelection() {
		var assassinWeaponNode = get(MyNodeLabels.assassinWeaponNode.toString());
		assassinWeaponNode.clearSequence();
		assassinWeaponNode.add(new WalkTo(Ally, armory, "Backdoor")).add(new Give(Ally, dagger, player));
	}
	//Maybe add a node or something where the armorer explains the mercenary eventually
	@BuilderMethod
	public void TheMercenary() {
		var mercenary = get(MyNodeLabels.mercenary.toString());
		mercenary.add(new CreateAll(List.of(mercenaryCamp, Mercenary, blade)))
		.add(new SetPosition(player, mercenaryCamp, "Exit")).add(new SetPosition(Mercenary, mercenaryCamp, "Chest"))
		.add(new DialogSequence(Mercenary, player, List.of("Always a pleasure to meet one of you dark table folks. So you wish to become an assassin? It will"
				+ " be intese training. Meet me over by the barrel and we can begin."), List.of("Next"))).add(new WalkTo(Mercenary, mercenaryCamp, "Barrel"));
	}
	@BuilderMethod
	public void MercenaryTraining() {
		var mercTraining = get(MyNodeLabels.mercTraining.toString());
		mercTraining.add(new Draw(Mercenary, blade)).add(new Attack(player, Mercenary, true))
		.add(new Attack(player, Mercenary, true)).add(new Attack(Mercenary, player, false)).add(new DialogSequence(Mercenary, player, List.of("Focus kid. "
				+ "Look for vunerabilities. Get me when I am at my weakest and strike with precision."), List.of("Next"))
		.add(new Attack(Mercenary, player, true)).add(new Attack(player, Mercenary, false)).add(new Clap(Mercenary))
		.add(new DialogSequence(Mercenary, player, List.of("Well done kid. Here take this. You are ready. Go get to work and make me proud."), List.of("Next"))).add(new SetClothing(player, Clothing.Bandit)));
	}
	//Joseph Maggio
	/*public void fletcher() {
    		var fletcherNode = get(NodeLabels.fletcher.toString());
    		fletcherNode.clearSequence();

    		fletcherNode.add(new HideMenu())
                	.add(new FadeIn())
                	.add(new NarrationSequence("The fletcher explains to you that to become skilled with a bow, you must understand all aspects of archery. "
                    	+ "He wants to teach you the art of marksmanship, personal agility and stealth, bow stringing and crafting, and arrow making and imbuing. "
                    	+ "He allows you to choose what to tackle first."))
                	.add(new DialogSequence(Fletcher, player,
                    	List.of("What would you like to learn first?"),
                    	List.of("Marksmanship", "Agility and Stealth", "Crafting", "Arrow Making")));
}*/		
	@BuilderMethod
	public void arrowMaking() {
    		var arrowMakingNode = get(MyNodeLabels.arrowMaking.toString());
   		arrowMakingNode.clearSequence();

    		arrowMakingNode.add(new HideMenu())
                .add(new FadeIn())
        	.add(new NarrationSequence("The fletcher teaches you the process of shaping your arrowhead, fletching your arrow, and imbuing it with potions and poisons. "
        	+ "The process is long and tedious, but you eventually become a master."))
                .add(new DialogSequence(fletcher, player, List.of("What skill should you master next?"), List.of("Crafting", "Marksmanship", "Agility and Stealth", "(Must be done with all four skills) Devise your plan")));
}
	@BuilderMethod
	public void crafting() {
    		var craftingNode = get(MyNodeLabels.crafting.toString());
    		craftingNode.clearSequence();

    		craftingNode.add(new HideMenu())
                	.add(new FadeIn())
                	.add(new NarrationSequence("The fletcher teaches you the art of carving your bow and stringing it. "
                    	+ "There is an intense and in-depth process that comes with creating your bow. "
                    	+ "Eventually, you create a beautiful weapon that suits you well. You give it a name."))
                	.add(new DialogSequence(fletcher, player,
                    	List.of("What skill should you master next?"),
                    	List.of("Arrow Making", "Marksmanship", "Agility and Stealth", "(Must be done with all four skills) Devise your plan")));
}
	@BuilderMethod
	public void agilityAndStealth() {
    		var agilityNode = get(MyNodeLabels.agilityAndStealth.toString());
    		agilityNode.clearSequence();
    		agilityNode.add(new HideMenu())
               		.add(new FadeIn())
               		.add(new NarrationSequence("After weeks of grueling physical training to meet the conditioning expectations of the fletcher, "
                   	+ "he brings you hunting to teach you the art of stealth. After many failed hunts, you master the skill and can catch even a rabbit with your bare hands."))
               		.add(new DialogSequence(fletcher, player,
                   	List.of("What skill do you master next?"),
                   	List.of("Marksmanship", "Crafting", "Arrow Making", "(Must be done with all four skills) Devise your plan")));
}

	@BuilderMethod
	public void marksmanship() {
    		var marksmanshipNode = get(MyNodeLabels.marksmanship.toString());
    		marksmanshipNode.clearSequence();
    		marksmanshipNode.add(new HideMenu())
                    .add(new FadeIn())
                    .add(new NarrationSequence("Here, the fletcher puts you through trials upon trials of target shooting. "
                        + "He even comes up with more and more convoluted ways of testing your accuracy. "
                        + "Eventually, you're able to outshoot even him in the trials. You have mastered the art."))
                    .add(new DialogSequence(fletcher, player,
                        List.of("What do you master next?"),
                        List.of("Arrow Making", "Agility and Stealth", "Crafting", "(Must be done with all four skills) Devise your plan")));
}
	@BuilderMethod
	public void thePlan() {
   		var planNode = get(MyNodeLabels.thePlan.toString());
    		planNode.clearSequence();

    		planNode.add(new HideMenu())
            		.add(new FadeIn())
            		.add(new NarrationSequence("You, the fletcher, and the rest of the Round Table devise your plan. "
                		+ "You will sneak into a royal wedding party at the castle. There, you will take the king out from afar and get out with haste. "
                		+ "To begin, you have to determine how to get into the party. Should you climb an outer wall and sneak into the party room, or attend the party with an inside man?"))
            		.add(new DialogSequence(player, fletcher,
                	List.of("What is your approach?"),
                	List.of("Climb the wall", "Attend the party")));
}

	
	
	public void insideTheCastleHalls() {
    		var castleNode = get(MyNodeLabels.insideTheCastleHalls.toString());
    		castleNode.clearSequence();
		castleNode.add(new HideMenu())
             		.add(new FadeIn())
              		.add(new NarrationSequence("After climbing the wall, you search for a location from which you can take your lethal shot. "
			+ "However, not long after your arrival, an arrow grazes your head. You look for its origin and find an occupied archer tower. "
                  	+ "You swiftly draw your bow and strike the archer in the head before he can even get his second shot off. "
                  	+ "It is from the archer tower that you will take your shot for glory."))
              		.add(new DialogSequence(player, player,
                  	List.of("You're in position. Are you ready?"),
                  	List.of("From the archer tower")));
}
	@BuilderMethod
	public void fromTheArcherTower() {
    	var towerNode = get(MyNodeLabels.fromTheArcherTower.toString());
    		towerNode.clearSequence();
		towerNode.add(new HideMenu())
             	.add(new FadeIn())
             	.add(new NarrationSequence("From the archer tower, you are easily able to locate the party in the courtyard. "
                 + "You pull your bow back, take a deep breath, and fire. You strike the king in the head, and chaos erupts. "
                 + "You easily escape the castle."))
             	.add(new DialogSequence(player, player,
                 List.of("You return victorious."),
                 List.of("Return to the Dark Table")));
}
	@BuilderMethod
	public void weddingParty() {
    		var weddingNode = get(MyNodeLabels.weddingParty.toString());
    		weddingNode.clearSequence();

    		weddingNode.add(new HideMenu())
               .add(new FadeIn())
               .add(new NarrationSequence("Upon arriving to the wedding party, the environment is rather overstimulating. "
        	+ "Uproarious applause follows each and every speech, festive music fills the air, and most important of all — alcohol. "
        	+ "Before you act, you find it best to wait until the liquid courage has been heavily consumed. "
                + "From there, you will propose a game in which you shoot an apple off of one's head."))
               .add(new DialogSequence(player, player,
                List.of("It’s time to make your move."),
                List.of("The archery game")));
}
	@BuilderMethod
	public void archeryGame() {
    		var archeryNode = get(MyNodeLabels.archeryGame.toString());
    		archeryNode.clearSequence();
    		archeryNode.add(new HideMenu())
               .add(new FadeIn())
               .add(new NarrationSequence("After convincing many drunks to participate in your game, you have adequately displayed your skills as an archer. "
		+ "Finally, you ask the king to give it a try. In his drunken state, he is more than happy to demonstrate his bravery. "
                + "You pull back your bow, take a deep breath, and shoot the king square in the head. Chaos breaks out, and you barely escape the castle."))
               .add(new DialogSequence(player, player,
                List.of("You escape through the madness."),
                List.of("Return to the Dark Table")));
}
	
		

	//Christian Maron
	@BuilderMethod 
	public void Potion(){
		var potion = get(MyNodeLabels.potion.toString());
		potion.add(new DialogSequence(bandit3, player, List.of("You chose the potion as your means of killing Merlin. Ideally you hope to concoct a potion that deals devastating damage in the least amount of time possible. In order to master the art of brewing you should take up an apprenticeship with the local warlock"),List.of("")));
	}
		@BuilderMethod 		
	public void DarkArts(){
		var darkArts = get(MyNodeLabels.darkArts.toString());
		darkArts.add(new DialogSequence(bandit3, player, List.of("You chose the dark arts as your means of killing Merlin. In order to develop such skills in a timely manner, you must take an appremticeship with the local warlock."),List.of("Next")));
			}
		
	@BuilderMethod 	
    public void PotionApprenticeship(){
		var potionApprenticeship = get(MyNodeLabels.potionApprenticeship.toString());
		potionApprenticeship.add(new CreateCharacterSequence(potionWarlock))
		.add(new CreateAll(List.of(potion,potionRoom)))
		.add(new SetPosition(player, potionRoom, "Bar"))
		.add(new SetPosition(potionWarlock, potionRoom, "Backdoor"))
		.add(new Give(potionWarlock, potion, player))
		.add(new DialogSequence(potionWarlock,player, List.of("You are ready"),List.of("Next")));
	}
	
	@BuilderMethod 		
	public void DarkArtsApprenticeship() {
		var darkArtsApprenticeship = get(MyNodeLabels.darkArtsApprenticeship.toString());
		darkArtsApprenticeship.add(new CreateCharacterSequence(darkArtsWarlock))
		.add(new CreateAll(List.of(wand,darkArtsRoom)))
		.add(new SetPosition(player, darkArtsRoom, "Bar"))
		.add(new SetPosition(darkArtsWarlock, darkArtsRoom, "Backdoor"))
		.add(new Give(darkArtsWarlock, wand, player))
		.add(new DialogSequence(darkArtsWarlock, player, List.of("You are ready"),List.of("Next")));
		}
	@BuilderMethod 
	public void PotionBattle(){
		var potionBattle = get(MyNodeLabels.potionBattle.toString());
		potionBattle.add(new CreateAll(List.of(potionBattleArea)))
		.add(new CreateCharacterSequence(merlin))
		.add(new SetPosition(merlin, potionBattleArea, "Well"))
		.add(new SetPosition(player, potionBattleArea, "DirtPile"))
		.add(new Attack(player, merlin, false))
		//.add(new Effect(merlin, potionEffect))
		.add(new Die(merlin));
			}
	@BuilderMethod 
	public void DarkArtsBattle(){
		var darkArtsBattle = get(MyNodeLabels.darkArtsBattle.toString());
		darkArtsBattle.add(new CreateAll(List.of(darkArtsBattleArea)))
		.add(new CreateCharacterSequence(merlin))
		.add(new SetPosition(merlin, darkArtsBattleArea, "Well"))
		.add(new SetPosition(player, darkArtsBattleArea, "DirtPile"))
		.add(new CreateAll(List.of(wand)))
		.add(new Draw(merlin, wand))
		.add(new Attack(merlin, player, true))
		.add(new Cast(player, merlin))
		//.add(new Effects(merlin, wandEffect))
		.add(new Die(merlin));
		
			}
	@BuilderMethod 
	public void MerlinDeath(){
		var merlinDeath = get(MyNodeLabels.merlinDeath.toString());
		merlinDeath.add(new Attack(player, merlin, false))
		.add(new DialogSequence(player, merlin, List.of("It has been done"),List.of("Next")));
	}
}
		
			
	
