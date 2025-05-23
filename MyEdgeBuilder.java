package myclassproject.mystorygraph;

import java.util.List;

import com.playerInput.*;
import com.playerInput.PlayerInteraction.Icons;
import com.storygraph.*;
import com.entities.*;
import com.enums.FurnitureTypes;

import static myclassproject.mystorygraph.MyStoryEntities.*;

public class MyEdgeBuilder extends NodeBuilder {
	/**
	 * Initializes the list of story graph nodes.
	 * @param list A list of all story graph nodes.
	 */
	public MyEdgeBuilder(List<Node> list) {
		super(list);
	}
	

	/**
	 * Write a method for each node. 
	 * Use get to get a reference to the node using its label.
	 * The method should add the edges of the node one by one. 
	 * These methods must have a BuilderMethod annotation.
	 */
	//Benjamin Hogg
	@BuilderMethod
	public void rootEdges() {
		var root = get(MyNodeLabels.root.toString());
		var choice = new MenuChoice(MenuChoice.Options.Start);
		var nextNode = get(MyNodeLabels.streetNar.toString());
		root.add(new Edge(choice, nextNode));
	}
	@BuilderMethod
	public void streetNarEdges() {
		var node = get(MyNodeLabels.streetNar.toString());
		var nextNode = get(MyNodeLabels.manApp.toString());
		var choice = new CloseNarrationChoice();
		node.add(new Edge(choice, nextNode));
	}
	@BuilderMethod
	public void manAppEdges() {
		var node = get(MyNodeLabels.manApp.toString());
		var nextNode1 = get(MyNodeLabels.askRecruiter.toString());
		var nextNode2 = get(MyNodeLabels.atkRec.toString());
		var askChoice = new DialogChoice("What do you want?");
		var attackChoice = new DialogChoice("ATTACK THE MAN");
		node.add(new Edge(askChoice, nextNode1));
		node.add(new Edge(attackChoice, nextNode2));
	}
	@BuilderMethod
	public void askRecruiterEdges() {
		var node = get(MyNodeLabels.askRecruiter.toString());
		var joinChoice = new DialogChoice("I'm in.");
		var nextNode2 = get(MyNodeLabels.darkTable.toString());
		node.add(new Edge(joinChoice, nextNode2));
		var dontGoChoice = new DialogChoice("No I have no idea what you're talking about. Leave me be.");
		var nextNode1 = get(MyNodeLabels.dontGowR.toString());
		node.add(new Edge(dontGoChoice, nextNode1));
	}
	@BuilderMethod
	public void attackRecruiterEdges() {
		var node = get(MyNodeLabels.atkRec.toString());
		var nextNode1 = get(MyNodeLabels.darkTable.toString());
		var attackChoice = new CloseNarrationChoice();
		node.add(new Edge(attackChoice, nextNode1));
	}
	
	@BuilderMethod
	public void dontGoEdges() {
		var node = get(MyNodeLabels.dontGowR.toString());
		var nextNode1 = get(MyNodeLabels.darkTable.toString());
		var dontGoChoice = new CloseNarrationChoice();
		node.add(new Edge(dontGoChoice, nextNode1));
	}

	@BuilderMethod
	public void theDarkTableEdges() {
		var node = get(MyNodeLabels.darkTable.toString());
		
		var nextNode1 = get(MyNodeLabels.arthur.toString());
		var arthurChoice = new DialogChoice("Challenge Arthur.");
		node.add(new Edge(arthurChoice, nextNode1));
		
		var nextNode2 = get(MyNodeLabels.lancelot.toString());
		var lancelotChoice = new DialogChoice("Challenge Lancelot.");
		node.add(new Edge(lancelotChoice, nextNode2));
		
		var nextNode3 = get(MyNodeLabels.merlin.toString());
		var merlinChoice = new DialogChoice("Challenge Merlin.");
		node.add(new Edge(merlinChoice, nextNode3));
	
		//Joseph Maggio
		/*var armoryNode = get(MyNodeLabels.armory.toString());
    		var armoryChoice = new DialogChoice("Visit the Armory.");
    		node.add(new Edge(armoryChoice, armoryNode));

    		var fletcherNode = get(MyNodeLabels.fletcher.toString());
    		var fletcherChoice = new DialogChoice("Visit the Fletcher.");
   		node.add(new Edge(fletcherChoice, fletcherNode));

    		var warlordWeaponNode = get(MyNodeLabels.warlordWeapon.toString());
    		var warlordWeaponChoice = new DialogChoice("Select Your Warlord Weapon.");
    		node.add(new Edge(warlordWeaponChoice, warlordWeaponNode));*/
	}
	@BuilderMethod
	public void ArthurEdges() {
		var node = get(MyNodeLabels.arthur.toString());
		var nextNode1 = get(MyNodeLabels.fletcherNar.toString());
		var continueChoice = new DialogChoice("Visit the Fletcher");
		node.add(new Edge(continueChoice, nextNode1));
	}
	
	@BuilderMethod
	public void LancelotEdges() {
		var node = get(MyNodeLabels.lancelot.toString());
		var nextNode1 = get(MyNodeLabels.armory.toString());
		var continueChoice = new DialogChoice("Go to the armory.");
		node.add(new Edge(continueChoice, nextNode1));
	}
	@BuilderMethod
	public void MerlinEdges() {
		var node = get(MyNodeLabels.merlin.toString());
		var nextNode1 = get(MyNodeLabels.potion.toString());
		var nextNode2 = get(MyNodeLabels.darkArts.toString());
		var continueChoice = new DialogChoice("Learn about potions.");
		var darkartsChoice = new DialogChoice("Learn the dark arts.");
		node.add(new Edge(continueChoice, nextNode1));
		node.add(new Edge(darkartsChoice, nextNode2));
	}
	
	@BuilderMethod
	public void ArmoryNar() {
		var node = get(MyNodeLabels.armory.toString());
		var nextNode1 = get(MyNodeLabels.armoryChoices.toString());
		var armChoice = new CloseNarrationChoice();
		node.add(new Edge(armChoice, nextNode1));
	}
	
	@BuilderMethod
	public void ArmoryChoices() {
		var node = get(MyNodeLabels.armoryChoices.toString());
		var nextNode1 = get(MyNodeLabels.tankWeaponNode.toString());
		var nextNode2 = get(MyNodeLabels.assassinWeaponNode.toString());
		var nextNode3 = get(MyNodeLabels.warlordWeapon.toString());
		var tankChoice = new DialogChoice("Tank");
		var assassinChoice = new DialogChoice("Assassin");
		var warlordChoice = new DialogChoice("Warlord");
		node.add(new Edge(tankChoice, nextNode1));
		node.add(new Edge(assassinChoice, nextNode2));
		node.add(new Edge(warlordChoice, nextNode3));
	}
	
	//Benjamin Hogg	
	
	
	@BuilderMethod
	public void WarlordEdges() {
		var node = get(MyNodeLabels.warlordWeapon.toString());
		var nextNode1 = get(MyNodeLabels.blunderbuss.toString());
		var nextNode2 = get(MyNodeLabels.waraxe.toString());
		var nextNode3 = get(MyNodeLabels.chainmace.toString());
		var blunderChoice = new DialogChoice("What even is that?");
		var axeChoice = new DialogChoice("War Axe");
		var maceChoice = new DialogChoice("Chain Mace");
		node.add(new Edge(blunderChoice, nextNode1));
		node.add(new Edge(axeChoice, nextNode2));
		node.add(new Edge(maceChoice, nextNode3));
	}
	
	@BuilderMethod
	public void BlunderbussEdges() {
		var node = get(MyNodeLabels.blunderbuss.toString());
		var nextNode1 = get(MyNodeLabels.ambushPlan.toString());
		var ambushPlanChoice = new PlayerInteraction("Open Door", new Furniture(armory, FurnitureTypes.Backdoor), Icons.door, "Leave");
		node.add(new Edge(ambushPlanChoice, nextNode1));
	}
	@BuilderMethod
	public void AxeEdges() {
		var node = get(MyNodeLabels.waraxe.toString());
		var nextNode1 = get(MyNodeLabels.ambushPlan.toString());
		var ambushPlanChoice = new PlayerInteraction("Open Door", new Furniture(armory, FurnitureTypes.Backdoor), Icons.door, "Leave");
		node.add(new Edge(ambushPlanChoice, nextNode1));
	}
	@BuilderMethod
	public void MaceEdges() {
		var node = get(MyNodeLabels.chainmace.toString());
		var nextNode1 = get(MyNodeLabels.ambushPlan.toString());
		var ambushPlanChoice = new PlayerInteraction("Open Door", new Furniture(armory, FurnitureTypes.Backdoor), Icons.door, "Leave");
		node.add(new Edge(ambushPlanChoice, nextNode1));
	}
	
	@BuilderMethod
	public void AmbushPlanEdges() {
		var node = get(MyNodeLabels.ambushPlan.toString());
		var nextNode1 = get(MyNodeLabels.ambush.toString());
		var ambushChoice = new PlayerInteraction("Open Door", new Furniture(darTable, FurnitureTypes.Door), Icons.door, "Leave");
		node.add(new Edge(ambushChoice, nextNode1));
	}
	
	@BuilderMethod
	public void AmbushEdges() {
		var node = get(MyNodeLabels.ambush.toString());
		var nextNode1 = get(MyNodeLabels.ambush2.toString());
		var ambush2Choice = new PlayerInteraction("Talk to Lancelot", lancelot, Icons.talk, "Confront Lancelot");
		node.add(new Edge(ambush2Choice, nextNode1));
	}
	@BuilderMethod
	public void Ambush2Edges() {
		var node = get(MyNodeLabels.ambush2.toString());
		var nextNode1 = get(MyNodeLabels.returnToTable.toString());
		var returnChoice = new PlayerInteraction(player, "Exit", new Furniture(city, FurnitureTypes.NorthEnd));
		node.add(new Edge(returnChoice, nextNode1));
	}
	
	@BuilderMethod
	public void TankEdges() {
		var node = get(MyNodeLabels.tankWeaponNode.toString());
		var nextNode1 = get(MyNodeLabels.takeHal.toString());
		var takeHalChoice = new PlayerInteraction(player, "Take Halberd", Ally);
		node.add(new Edge(takeHalChoice, nextNode1));
	}
	@BuilderMethod
	public void TakeHalEdges() {
		var node = get(MyNodeLabels.takeHal.toString());
		var nextNode1 = get(MyNodeLabels.leaveArm.toString());
		var expDuelChoice = new DialogChoice("Ok");
		node.add(new Edge(expDuelChoice, nextNode1));
	}
	
	@BuilderMethod
	public void leaveArmEdges() {
		var node = get(MyNodeLabels.leaveArm.toString());
		var nextNode1 = get(MyNodeLabels.expDuel.toString());
		var expDuelChoice = new PlayerInteraction("Open Door", new Furniture(armory, FurnitureTypes.Door), Icons.door, "Leave");
		node.add(new Edge(expDuelChoice, nextNode1));
	}
	
	@BuilderMethod
	public void ExpDuelEdges() {
		var node = get(MyNodeLabels.expDuel.toString());
		var nextNode1 = get(MyNodeLabels.leaveforDuel.toString());
		var inMarketChoice = new DialogChoice("Works for me I guess.");
		node.add(new Edge(inMarketChoice, nextNode1));
	}
	
	@BuilderMethod
	public void leaveforDuelEdges() {
		var node = get(MyNodeLabels.leaveforDuel.toString());
		var nextNode1 = get(MyNodeLabels.inMarket.toString());
		var inMarketChoice = new PlayerInteraction("Open Door", new Furniture(darTable, FurnitureTypes.Door), Icons.door, "Leave");
		node.add(new Edge(inMarketChoice, nextNode1));
	}
	
	@BuilderMethod
	public void InMarketEdges() {
		var node = get(MyNodeLabels.inMarket.toString());
		var nextNode1 = get(MyNodeLabels.duel.toString());
		var theDuelChoice = new PlayerInteraction("Talk to Lancelot", lancelot, Icons.talk, "Confront Lancelot");
		node.add(new Edge(theDuelChoice, nextNode1));
	}
	
	@BuilderMethod
	public void TheDuelEdges() {
		var node = get(MyNodeLabels.duel.toString());
		var nextNode1 = get(MyNodeLabels.returnToTable.toString());
		var duelChoice = new PlayerInteraction(player, "Exit", new Furniture(market, FurnitureTypes.Exit));
		node.add(new Edge(duelChoice, nextNode1));
	}
	
	@BuilderMethod
	public void returnToTableEdges() {
		var node = get(MyNodeLabels.returnToTable.toString());
		var nextNode1 = get(MyNodeLabels.theend.toString());
		var endchoice = new DialogChoice("The End");
		node.add(new Edge(endchoice, nextNode1));
	}
	
	/*@BuilderMethod
	public void theEndEdges() {
		var node = get(MyNodeLabels.theend.toString());
		var nextNode1 = get(MyNodeLabels.streetNar.toString());
		var endchoice = new MenuChoice(MenuChoice.Options.Start);
		node.add(new Edge(endchoice, nextNode1));
	}*/
	
	@BuilderMethod
	public void AssassinEdges() {
		var node = get(MyNodeLabels.assassinWeaponNode.toString()); 
		var nextNode1 = get(MyNodeLabels.givedagger.toString());
		var takeHalChoice = new PlayerInteraction("Take dagger", Ally, Icons.hand, "Take dagger" );
		node.add(new Edge(takeHalChoice, nextNode1));
	}
	@BuilderMethod
	public void takeDaggerEdges() {
		var node = get(MyNodeLabels.givedagger.toString()); 
		var nextNode1 = get(MyNodeLabels.leaveArmDagger.toString());
		var mercenaryChoice = new DialogChoice("Thanks");
		node.add(new Edge(mercenaryChoice, nextNode1));
	}
	@BuilderMethod
	public void leaveArmDaggerEdges() {
		var node = get(MyNodeLabels.leaveArmDagger.toString());
		var nextNode1 = get(MyNodeLabels.mercenary.toString());
		var Choice = new PlayerInteraction("Open Door", new Furniture(armory, FurnitureTypes.Door), Icons.door, "Leave");
		node.add(new Edge(Choice, nextNode1));
	}
	
	@BuilderMethod
	public void MercenaryEdges() {
		var node = get(MyNodeLabels.mercenary.toString());
		var nextNode1 = get(MyNodeLabels.talktomerc.toString());
		var mercTrainingChoice = new PlayerInteraction("Talk to Mercenary", Mercenary, Icons.talk, "Talk");
		node.add(new Edge(mercTrainingChoice, nextNode1));
	}
	@BuilderMethod
	public void talktomercEdges() {
		var node = get(MyNodeLabels.talktomerc.toString());
		var nextNode1 = get(MyNodeLabels.walktotrain.toString());
		var mercTrainingChoice = new DialogChoice("Ok");
		node.add(new Edge(mercTrainingChoice, nextNode1));
	}
	@BuilderMethod
	public void walktotrainEdges() {
		var node = get(MyNodeLabels.walktotrain.toString());
		var nextNode1 = get(MyNodeLabels.mercTraining.toString());
		var mercTrainingChoice = new PlayerInteraction("Talk to Mercenary", Mercenary, Icons.talk, "Talk");
		node.add(new Edge(mercTrainingChoice, nextNode1));
	}
	@BuilderMethod 
	public void MercTrainingEdges() {
		var node = get(MyNodeLabels.mercTraining.toString());
		var nextNode1 = get(MyNodeLabels.merctraining2.toString());
		var toDuelfromMerc = new DialogChoice("Ok, I will.");
		node.add(new Edge(toDuelfromMerc, nextNode1));
	}
	@BuilderMethod 
	public void MercTraining2Edges() {
		var node = get(MyNodeLabels.merctraining2.toString());
		var nextNode1 = get(MyNodeLabels.leavecamp.toString());
		var toDuelfromMerc = new DialogChoice("Thanks");
		node.add(new Edge(toDuelfromMerc, nextNode1));
	}
	@BuilderMethod 
	public void leavecampEdges() {
		var node = get(MyNodeLabels.leavecamp.toString());
		var nextNode1 = get(MyNodeLabels.expDuel.toString());
		var duelChoice = new PlayerInteraction(player, "Exit", new Furniture(mercenaryCamp, FurnitureTypes.Exit));
		node.add(new Edge(duelChoice, nextNode1));
	}
	//Christian Maron
	/*@BuilderMethod
	public void merlinChoiceEdge(){
		var node = get(MyNodeLabels.merlin.toString());
		var nextNode1 = get(MyNodeLabels.potion.toString());
		var nextNode2 = get(MyNodeLabels.darkArts.toString());
		var potionChoice = new DialogChoice("Take on Merlin with a potion.");
		var darkArtsChoice = new DialogChoice("Take on Merlin with dark arts.");
		node.add(new Edge(potionChoice, nextNode1));
		node.add(new Edge(darkArtsChoice, nextNode2));
	}*/
	
	
	//Joseph Maggio
	
	@BuilderMethod
		public void fletcherNarEdges() {
			var node = get(MyNodeLabels.fletcherNar.toString());
			var nextNode = get(MyNodeLabels.fletcher.toString());
			var choice = new CloseNarrationChoice();
			node.add(new Edge(choice, nextNode));
		}
			@BuilderMethod
			public void fletcherEdges() {
		    		var fletcherNode = get(MyNodeLabels.fletcher.toString());
		    		var marksmanshipNode = get(MyNodeLabels.marksmanshipNar.toString());
		    		var marksmanshipChoice = new DialogChoice("Marksmanship");
		    		fletcherNode.add(new Edge(marksmanshipChoice, marksmanshipNode));
		    		//var agilityNode = get(MyNodeLabels.agilityAndStealth.toString());
		    		//var agilityChoice = new DialogChoice("Agility and Stealth");
		    		//fletcherNode.add(new Edge(agilityChoice, agilityNode));
		    		//var craftingNode = get(MyNodeLabels.crafting.toString());
		    		//var craftingChoice = new DialogChoice("Crafting");
		    		//fletcherNode.add(new Edge(craftingChoice, craftingNode));
		    		var arrowMakingNode = get(MyNodeLabels.arrowMakingNar.toString());
		    		var arrowMakingChoice = new DialogChoice("Arrow Making");
		    		fletcherNode.add(new Edge(arrowMakingChoice, arrowMakingNode));
		}
			@BuilderMethod
			public void arrowMakingEdges() {
		    		var arrowMakingNode = get(MyNodeLabels.arrowMaking.toString());
		    		//var craftingNode = get(MyNodeLabels.crafting.toString());
		    		//var craftingChoice = new DialogChoice("Crafting");
		    		//arrowMakingNode.add(new Edge(craftingChoice, craftingNode));
		    		var marksmanshipNode = get(MyNodeLabels.marksmanshipNar.toString());
		    		var marksmanshipChoice = new DialogChoice("Marksmanship");
		    		arrowMakingNode.add(new Edge(marksmanshipChoice, marksmanshipNode));
		   	 	//var agilityNode = get(MyNodeLabels.agilityAndStealth.toString());
		    		//var agilityChoice = new DialogChoice("Agility and Stealth");
		    		//arrowMakingNode.add(new Edge(agilityChoice, agilityNode));
		    		var planNode = get(MyNodeLabels.planNar.toString());
		    		var planChoice = new DialogChoice("Im Ready");
		    		arrowMakingNode.add(new Edge(planChoice, planNode));
		}	
			/*@BuilderMethod
			public void craftingEdges() {
			    var craftingNode = get(MyNodeLabels.crafting.toString());
			    var arrowMakingNode = get(MyNodeLabels.arrowMaking.toString());
			    var marksmanshipNode = get(MyNodeLabels.marksmanship.toString());
			    var agilityNode = get(MyNodeLabels.agilityAndStealth.toString());
			    var planNode = get(MyNodeLabels.thePlan.toString());
			    
			    // Add edge for closing narration
			    var closeNarration = new CloseNarrationChoice();
			    craftingNode.add(new Edge(closeNarration, craftingNode));  // This will allow closing the narration
			    
			    // Add other edges
			    var arrowChoice = new DialogChoice("Arrow Making");
			    var marksmanshipChoice = new DialogChoice("Marksmanship");
			    var agilityChoice = new DialogChoice("Agility and Stealth");
			    var planChoice = new DialogChoice("(Must be done with all four skills) Devise your plan");
			    
			    craftingNode.add(new Edge(arrowChoice, arrowMakingNode));
			    craftingNode.add(new Edge(marksmanshipChoice, marksmanshipNode));
			    craftingNode.add(new Edge(agilityChoice, agilityNode));
			    craftingNode.add(new Edge(planChoice, planNode));
			}

			@BuilderMethod
			public void agilityAndStealthEdges() {
			    var agilityNode = get(MyNodeLabels.agilityAndStealth.toString());
			    var marksmanshipNode = get(MyNodeLabels.marksmanship.toString());
			    var craftingNode = get(MyNodeLabels.crafting.toString());
			    var arrowMakingNode = get(MyNodeLabels.arrowMaking.toString());
			    var planNode = get(MyNodeLabels.thePlan.toString());
			    
			    // Add edge for closing narration
			    var closeNarration = new CloseNarrationChoice();
			    agilityNode.add(new Edge(closeNarration, agilityNode));  // This will allow closing the narration
			    
			    // Add other edges
			    var marksmanshipChoice = new DialogChoice("Marksmanship");
			    var craftingChoice = new DialogChoice("Crafting");
			    var arrowChoice = new DialogChoice("Arrow Making");
			    var planChoice = new DialogChoice("(Must be done with all four skills) Devise your plan");
			    
			    agilityNode.add(new Edge(marksmanshipChoice, marksmanshipNode));
			    agilityNode.add(new Edge(craftingChoice, craftingNode));
			    agilityNode.add(new Edge(arrowChoice, arrowMakingNode));
			    agilityNode.add(new Edge(planChoice, planNode));
			}*/
			
			@BuilderMethod
			public void marksmanshipEdges() {
			    var marksmanshipNode = get(MyNodeLabels.marksmanship.toString());
			    var arrowMakingNode = get(MyNodeLabels.arrowMakingNar.toString());
			    //var agilityNode = get(MyNodeLabels.agilityAndStealth.toString());
			    //var craftingNode = get(MyNodeLabels.crafting.toString());
			    var planNode = get(MyNodeLabels.planNar.toString());
			    
			    // Add edge for closing narration
			    var closeNarration = new CloseNarrationChoice();
			    marksmanshipNode.add(new Edge(closeNarration, marksmanshipNode));
			    
			    // Add edges for dialog choices
			    var arrowChoice = new DialogChoice("Arrow Making");
			    //var agilityChoice = new DialogChoice("Agility and Stealth");
			    //var craftingChoice = new DialogChoice("Crafting");
			    var planChoice = new DialogChoice("Im Ready");
			    
			    marksmanshipNode.add(new Edge(arrowChoice, arrowMakingNode));
			    //marksmanshipNode.add(new Edge(agilityChoice, agilityNode));
			    //marksmanshipNode.add(new Edge(craftingChoice, craftingNode));
			    marksmanshipNode.add(new Edge(planChoice, planNode));
			}
			@BuilderMethod
			public void marksmanshipNarEdges() {
			    var node = get(MyNodeLabels.marksmanshipNar.toString());
			    var nextNode = get(MyNodeLabels.marksmanship.toString());
			    var choice = new CloseNarrationChoice();
			    node.add(new Edge(choice, nextNode));
			}

			@BuilderMethod
			public void arrowMakingNarEdges() {
			    var node = get(MyNodeLabels.arrowMakingNar.toString());
			    var nextNode = get(MyNodeLabels.arrowMaking.toString());
			    var choice = new CloseNarrationChoice();
			    node.add(new Edge(choice, nextNode));
			}
			
			@BuilderMethod
			public void leaveForPlanEdges() {
				var node = get(MyNodeLabels.leaveForPlan.toString());
				var nextNode1 = get(MyNodeLabels.insideTheCastleHalls.toString());
				var inMarketChoice = new PlayerInteraction("Open Door", new Furniture(darTable, FurnitureTypes.Door), Icons.door, "Leave");
				node.add(new Edge(inMarketChoice, nextNode1));
			}
			
			@BuilderMethod
			public void planNarEdges() {
				var node = get(MyNodeLabels.planNar.toString());
				var nextNode = get(MyNodeLabels.leaveForPlan.toString());
				var choice = new CloseNarrationChoice();
				node.add(new Edge(choice,nextNode));
				
			}

		@BuilderMethod
		public void thePlanEdges() {
	    		var planNode = get(MyNodeLabels.thePlan.toString());
	    		var climbNode = get(MyNodeLabels.insideTheCastleHalls.toString());
	    		var climbChoice = new DialogChoice("Climb the wall");
	    		planNode.add(new Edge(climbChoice, climbNode));
	    		var attendNode = get(MyNodeLabels.weddingParty.toString());
	    		var attendChoice = new DialogChoice("Attend the party");
	    		planNode.add(new Edge(attendChoice, attendNode));
	}

		@BuilderMethod
		public void insideTheCastleHallsEdges() {
	    		var castleNode = get(MyNodeLabels.insideTheCastleHalls.toString());
	    		var snipe = get(MyNodeLabels.snipe.toString());
	    		var shot = new PlayerInteraction("shot", noble3, Icons.talk, "Psst over here");
	    		castleNode.add(new Edge(shot, snipe));
	}
		@BuilderMethod
		public void snipeEdges() {
			var snipe = get(MyNodeLabels.snipe.toString());
			var nextNode = get(MyNodeLabels.returnToTable.toString());
			var duelChoice = new PlayerInteraction("idk",noble3, Icons.talk,"You got him, lets get out of here");
			snipe.add(new Edge(duelChoice,nextNode));
		}

		@BuilderMethod
		public void fromTheArcherTowerEdges() {
	    		var towerNode = get(MyNodeLabels.fromTheArcherTower.toString());
	    		var returnNode = get(MyNodeLabels.darkTable.toString());
	    		var returnChoice = new DialogChoice("Return to the Dark Table");
	    		towerNode.add(new Edge(returnChoice, returnNode));
	}

		@BuilderMethod
		public void weddingPartyEdges() {
	    		var weddingNode = get(MyNodeLabels.weddingParty.toString());
	    		var archeryGameNode = get(MyNodeLabels.archeryGame.toString());
	   		var gameChoice = new DialogChoice("The archery game");
	    		weddingNode.add(new Edge(gameChoice, archeryGameNode));
	}
		@BuilderMethod
		public void archeryGameEdges() {
	    		var archeryNode = get(MyNodeLabels.archeryGame.toString());
	    		var returnNode = get(MyNodeLabels.darkTable.toString());
	    		var returnChoice = new DialogChoice("Return to the Dark Table");
	    		archeryNode.add(new Edge(returnChoice, returnNode));
	}
			@BuilderMethod
			public void PotionEdge(){
			var node = get(MyNodeLabels.potion.toString());
			var nextNode1 = get(MyNodeLabels.potionApprenticeship.toString());
			var potionApprencticeshipNode = new DialogChoice("Take up apprenticeship");
			node.add(new Edge(potionApprencticeshipNode, nextNode1));
			}
			@BuilderMethod
			public void DarkArtsEdge(){
			var node = get(MyNodeLabels.darkArts.toString());
			var nextNode1 = get(MyNodeLabels.darkArtsApprenticeship.toString());
			var darkArtsApprencticeshipNode = new DialogChoice("Take up apprenticeship");
			node.add(new Edge(darkArtsApprencticeshipNode, nextNode1));
			}
			@BuilderMethod
			public void ArtsApprenticeshipEdge(){
			var node = get(MyNodeLabels.darkArtsApprenticeship.toString());
			var nextNode1 = get(MyNodeLabels.darkArtsBattle.toString());
			var goToDarkArtsBattle = new DialogChoice("Go to the battle.");
			node.add(new Edge(goToDarkArtsBattle, nextNode1));
			}
			@BuilderMethod
			public void PotionApprenticeshipEdge(){
			var node = get(MyNodeLabels.potionApprenticeship.toString());
			var nextNode1 = get(MyNodeLabels.potionBattle.toString());
			var goToPotionBattle = new DialogChoice("Go to the battle.");
			node.add(new Edge(goToPotionBattle, nextNode1));
			}
			@BuilderMethod
			public void PotionBattleEdge(){
			var node = get(MyNodeLabels.potionBattle.toString());
			var nextNode1 = get(MyNodeLabels.merlinDeath.toString());
			var checkMerlin = new DialogChoice("Make sure that he is dead.");
			node.add(new Edge(checkMerlin, nextNode1));
			}
			@BuilderMethod
			public void DarkArtsBattleEdge(){
			var node = get(MyNodeLabels.darkArtsBattle.toString());
			var nextNode1 = get(MyNodeLabels.merlinDeath.toString());
			var checkMerlin = new DialogChoice("Make sure that he is dead.");
			node.add(new Edge(checkMerlin, nextNode1));
			}	

}
