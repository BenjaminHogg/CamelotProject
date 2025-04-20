package myclassproject.mystorygraph;

import java.util.List;

import com.playerInput.*;
import com.playerInput.PlayerInteraction.Icons;
import com.storygraph.*;
import com.entities.*;
import com.enums.FurnitureTypes;

import myclassproject.questexample.NodeLabels;

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
		var nextNode1 = get(MyNodeLabels.ask.toString());
		var nextNode2 = get(MyNodeLabels.atkRec.toString());
		var askChoice = new DialogChoice("What do you want?");
		var attackChoice = new DialogChoice("ATTACK THE MAN");
		node.add(new Edge(askChoice, nextNode1));
		node.add(new Edge(attackChoice, nextNode2));
	}
	@BuilderMethod
	public void askRecruiterEdges() {
		var node = get(MyNodeLabels.askRecruiter.toString());
		var nextNode1 = get(MyNodeLabels.dontGowR.toString());
		var dontGoChoice = new DialogChoice("No I have no idea what you're talking about. Leave me be.");
		node.add(new Edge(dontGoChoice, nextNode1));
		//Other edge goes to Dark Table
		//Christian Maron
		var nextNode2 = get(MyNodeLabels.darkTable.toString());
		var joinChoice = new DialogChoice("I'll join");
		node.add(new Edge(joinChoice, nextNode2));
	}
	@BuilderMethod
	public void attackRecruiterEdges() {
		var node = get(MyNodeLabels.atkRec.toString());
		var nextNode1 = get(MyNodeLabels.darkTable.toString());
		var attackChoice = new DialogChoice("You have been taken by force.");
		node.add(new Edge(attackChoice, nextNode1));
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
		var armoryNode = get(MyNodeLabels.armory.toString());
    		var armoryChoice = new DialogChoice("Visit the Armory.");
    		node.add(new Edge(armoryChoice, armoryNode));

    		var fletcherNode = get(MyNodeLabels.fletcher.toString());
    		var fletcherChoice = new DialogChoice("Visit the Fletcher.");
   		node.add(new Edge(fletcherChoice, fletcherNode));

    		var warlordWeaponNode = get(MyNodeLabels.warlordWeapon.toString());
    		var warlordWeaponChoice = new DialogChoice("Select Your Warlord Weapon.");
    		node.add(new Edge(warlordWeaponChoice, warlordWeaponNode));
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
		var nextNode1 = get(MyNodeLabels.expDuel.toString());
		var expDuelChoice = new PlayerInteraction("Open Door", new Furniture(armory, FurnitureTypes.Backdoor), Icons.door, "Leave");
		node.add(new Edge(expDuelChoice, nextNode1));
	}
	
	@BuilderMethod
	public void ExpDuelEdges() {
		var node = get(MyNodeLabels.expDuel.toString());
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
		var nextNode1 = get(MyNodeLabels.duel.toString());
		var duelChoice = new PlayerInteraction(player, "Exit", new Furniture(ambushStreet, FurnitureTypes.Exit));
		node.add(new Edge(duelChoice, nextNode1));
	}
	
	@BuilderMethod
	public void AssassinEdges() {
		var node = get(MyNodeLabels.assassinWeaponNode.toString()); 
		var nextNode1 = get(MyNodeLabels.mercenary.toString());
		var mercenaryChoice = new PlayerInteraction("Open Door", new Furniture(armory, FurnitureTypes.Backdoor), Icons.door, "Leave");
		node.add(new Edge(mercenaryChoice, nextNode1));
	}
	
	@BuilderMethod
	public void MercenaryEdges() {
		var node = get(MyNodeLabels.mercenary.toString());
		var nextNode1 = get(MyNodeLabels.mercTraining.toString());
		var mercTrainingChoice = new PlayerInteraction("Talk to Mercenary", mercenary, Icons.talk, "Confront Lancelot");
		node.add(new Edge(mercTrainingChoice, nextNode1));
	}
	
	@BuilderMethod public void MercTrainingEdges() {
		var node = get(MyNodeLabels.mercTraining.toString());
		var nextNode1 = get(MyNodeLabels.expDuel.toString());
		var toDuelfromMerc = new PlayerInteraction(player, "Mercenary Camp", new Furniture(mercenaryCamp, FurnitureTypes.Exit));
		node.add(new Edge(toDuelfromMerc, nextNode1));
	}
	//Christian Maron
	@BuilderMethod
	public void merlinChoiceEdge(){
		var node = get(MyNodeLabels.merlin.toString());
		var nextNode1 = get(MyNodeLabels.potion.toString());
		var nextNode2 = get(MyNodeLabels.darkArts.toString());
		var potionChoice = new DialogChoice("Take on Merlin with a potion.");
		var darkArtsChoice = new DialogChoice("Take on Merlin with dark arts.");
		node.add(new Edge(potionChoice, nextNode1));
		node.add(new Edge(darkArtsChoice, nextNode2));
	}
	
	
	@BuilderMethod
	public void PotionEdge(){
		var node = get(MyNodeLabels.potion.toString());
		var nextNode1 = get(MyNodeLabels.potionApprenticeship.toString());
		var potionApprencticeshipNode = new DialogChoice("Go to your apprenticeship");
		node.add(new Edge(potionApprencticeshipNode, nextNode1));
	}
	@BuilderMethod
	public void DarkArtsEdge(){
		var node = get(MyNodeLabels.darkArts.toString());
		var nextNode1 = get(MyNodeLabels.darkArtsApprenticeship.toString());
		var darkArtsApprencticeshipNode = new DialogChoice("Go to your apprenticeship.");
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
	@BuilderMethod
	public void MerlinDeathEdge(){
		var node = get(MyNodeLabels.merlinDeath.toString());
		var nextNode1 = get(MyNodeLabels.returnToTable.toString());
		var returnToDarkTable = new DialogChoice("Return to the Dark Table");
		node.add(new Edge(returnToDarkTable, nextNode1));

		
}
	//Joseph Maggio
	@BuilderMethod
	public void fletcherEdges() {
    		var fletcherNode = get(MyNodeLabels.fletcher.toString());
    		var marksmanshipNode = get(MyNodeLabels.marksmanship.toString());
    		var marksmanshipChoice = new DialogChoice("Marksmanship");
    		fletcherNode.add(new Edge(marksmanshipChoice, marksmanshipNode));
    		var agilityNode = get(MyNodeLabels.agilityAndStealth.toString());
    		var agilityChoice = new DialogChoice("Agility and Stealth");
    		fletcherNode.add(new Edge(agilityChoice, agilityNode));
    		var craftingNode = get(MyNodeLabels.crafting.toString());
    		var craftingChoice = new DialogChoice("Crafting");
    		fletcherNode.add(new Edge(craftingChoice, craftingNode));
    		var arrowMakingNode = get(MyNodeLabels.arrowMaking.toString());
    		var arrowMakingChoice = new DialogChoice("Arrow Making");
    		fletcherNode.add(new Edge(arrowMakingChoice, arrowMakingNode));
}
	public void arrowMakingEdges() {
    		var arrowMakingNode = get(MyNodeLabels.arrowMaking.toString());
    		var craftingNode = get(MyNodeLabels.crafting.toString());
    		var craftingChoice = new DialogChoice("Crafting");
    		arrowMakingNode.add(new Edge(craftingChoice, craftingNode));
    		var marksmanshipNode = get(MyNodeLabels.marksmanship.toString());
    		var marksmanshipChoice = new DialogChoice("Marksmanship");
    		arrowMakingNode.add(new Edge(marksmanshipChoice, marksmanshipNode));
   	 	var agilityNode = get(MyNodeLabels.agilityAndStealth.toString());
    		var agilityChoice = new DialogChoice("Agility and Stealth");
    		arrowMakingNode.add(new Edge(agilityChoice, agilityNode));
    		var planNode = get(MyNodeLabels.thePlan.toString());
    		var planChoice = new DialogChoice("(Must be done with all four skills) Devise your plan");
    		arrowMakingNode.add(new Edge(planChoice, planNode));
}	
	public void craftingEdges() {
    		var craftingNode = get(MyNodeLabels.crafting.toString());
    		var arrowMakingNode = get(MyNodeLabels.arrowMaking.toString());
    		var arrowChoice = new DialogChoice("Arrow Making");
    		craftingNode.add(new Edge(arrowChoice, arrowMakingNode));
    		var marksmanshipNode = get(MyNodeLabels.marksmanship.toString());
    		var marksmanshipChoice = new DialogChoice("Marksmanship");
    		craftingNode.add(new Edge(marksmanshipChoice, marksmanshipNode));
    		var agilityNode = get(MyNodeLabels.agilityAndStealth.toString());
    		var agilityChoice = new DialogChoice("Agility and Stealth");
    		craftingNode.add(new Edge(agilityChoice, agilityNode));
    		var planNode = get(MyNodeLabels.thePlan.toString());
    		var planChoice = new DialogChoice("(Must be done with all four skills) Devise your plan");
    		craftingNode.add(new Edge(planChoice, planNode));
}
	public void agilityAndStealthEdges() {
    		var agilityNode = get(MyNodeLabels.agilityAndStealth.toString());
    		var marksmanshipNode = get(MyNodeLabels.marksmanship.toString());
    		var marksmanshipChoice = new DialogChoice("Marksmanship");
    		agilityNode.add(new Edge(marksmanshipChoice, marksmanshipNode));
    		var craftingNode = get(MyNodeLabels.crafting.toString());
    		var craftingChoice = new DialogChoice("Crafting");
    		agilityNode.add(new Edge(craftingChoice, craftingNode));
    		var arrowMakingNode = get(MyNodeLabels.arrowMaking.toString());
    		var arrowChoice = new DialogChoice("Arrow Making");
    		agilityNode.add(new Edge(arrowChoice, arrowMakingNode));
    		var planNode = get(MyNodeLabels.thePlan.toString());
    		var planChoice = new DialogChoice("(Must be done with all four skills) Devise your plan");
    		agilityNode.add(new Edge(planChoice, planNode));
}
	@BuilderMethod
	public void marksmanshipEdges() {
    		var marksmanshipNode = get(MyNodeLabels.marksmanship.toString());
    		var arrowMakingNode = get(MyNodeLabels.arrowMaking.toString());
    		var arrowChoice = new DialogChoice("Arrow Making");
    		marksmanshipNode.add(new Edge(arrowChoice, arrowMakingNode));
    		var agilityNode = get(MyNodeLabels.agilityAndStealth.toString());
    		var agilityChoice = new DialogChoice("Agility and Stealth");
   		marksmanshipNode.add(new Edge(agilityChoice, agilityNode));
    		var craftingNode = get(MyNodeLabels.crafting.toString());
    		var craftingChoice = new DialogChoice("Crafting");
    		marksmanshipNode.add(new Edge(craftingChoice, craftingNode));
    		var planNode = get(MyNodeLabels.thePlan.toString());
    		var planChoice = new DialogChoice("(Must be done with all four skills) Devise your plan");
    		marksmanshipNode.add(new Edge(planChoice, planNode));
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
    		var towerNode = get(MyNodeLabels.fromTheArcherTower.toString());
    		var towerChoice = new DialogChoice("From the archer tower");
    		castleNode.add(new Edge(towerChoice, towerNode));
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
}}

	


	

			
