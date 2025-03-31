package myclassproject.mystorygraph;

import java.util.List;

import com.playerInput.*;
import com.storygraph.*;

import myclassproject.mystorygraph.MyNodeLabels;

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

    		var warlordWeaponNode = get(MyNodeLabels.warlordWeaponSelection.toString());
    		var warlordWeaponChoice = new DialogChoice("Select Your Warlord Weapon.");
    		node.add(new Edge(warlordWeaponChoice, warlordWeaponNode));
	}
	//Benjamin Hogg	
	@BuilderMethod
	public void WarlordEdges() {
		var node = get(MyNodeLabels.warlordWeaponNode.toString());
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
		var ambushPlanChoice = new PlayerInteraction(openDoor, Furniture(armory, "BackDoor"), Icons.door, "Leave");
		node.add(new Edge(ambushPlanChoice, nextNode1));
	}
	@BuilderMethod
	public void AxeEdges() {
		var node = get(MyNodeLabels.waraxe.toString());
		var nextNode1 = get(MyNodeLabels.ambushPlan.toString());
		var ambushPlanChoice = new PlayerInteraction(openDoor, Furniture(armory, "BackDoor"), Icons.door, "Leave");
		node.add(new Edge(ambushPlanChoice, nextNode1));
	}
	@BuilderMethod
	public void MaceEdges() {
		var node = get(MyNodeLabels.chainmace.toString());
		var nextNode1 = get(MyNodeLabels.ambushPlan.toString());
		var ambushPlanChoice = new PlayerInteraction(openDoor, Furniture(armory, "BackDoor"), Icons.door, "Leave");
		node.add(new Edge(ambushPlanChoice, nextNode1));
	}
	
	@BuilderMethod
	public void AmbushPlanEdges() {
		var node = get(MyNodeLabels.ambushPlan.toString());
		var nextNode1 = get(MyNodeLabels.ambush.toString());
		var ambushChoice = new PlayerInteraction(openDoor, Furniture(darTable, "Door"), Icons.door, "Leave");
		node.add(new Edge(ambushChoice, nextNode1));
	}
	
	@BuilderMethod
	public void AmbushEdges() {
		var node = get(MyNodeLabels.ambush.toString());
		var nextNode1 = get(MyNodeLabels.ambush2.toString());
		var ambush2Choice = new PlayerInteraction(talkToLancelot, lancelot, Icons.talk, "Confront Lancelot");
		node.add(new Edge(ambush2Choice, nextNode1));
	}
	@BuilderMethod
	public void Ambush2Edges() {
		var node = get(MyNodeLabels.ambush2.toString());
		var nextNode1 = get(MyNodeLabels.returnToTable.toString());
		var returnChoice = new PlayerInteraction(player, approachExit, Furniture(city, "NorthEnd"));
		node.add(new Edge(returnChoice, nextNode1));
	}
	
	@BuilerMethod
	public void TankEdges() {
		var node = get(MyNodeLabels.tankWeaponNode.toString());
		var nextNode1 = get(MyNodeLabels.takeHal.toString());
		var takeHalChoice = new PlayerInteraction(player, takeHalberd, Ally);
		node.add(new Edge(takeHalChoice, nextNode1));
	}
	@BuilderMethod
	public void TakeHalEdges() {
		var node = get(MyNodeLabels.takeHal.toString());
		var nextNode1 = get(MyNodeLabels.expDuel.toString());
		var expDuelChoice = new PlayerInteraction(openDoor, Furniture(armory, "BackDoor"), Icons.door, "Leave");
		node.add(new Edge(expDuelChoice, nextNode1));
	}
	
	@BuilderMethod
	public void ExpDuelEdges() {
		var node = get(MyNodeLabels.expDuel.toString());
		var nextNode1 = get(MyNodeLabels.inMarket.toString());
		var inMarketChoice = new PlayerInteraction(openDoor, Furniture(darTable, "Door"), Icons.door, "Leave");
		node.add(new Edge(inMarketChoice, nextNode1));
	}
	@BuilderMethod
	public void InMarketEdges() {
		var node = get(MyNodeLabels.inMarket.toString());
		var nextNode1 = get(MyNodeLabels.theDuel.toString());
		var theDuelChoice = new PlayerInteraction(talkToLancelot, lancelot, Icons.talk, "Confront Lancelot");
		node.add(new Edge(theDuelChoice, nextNode1));
	}
	
	@BuilderMethod
	public void TheDuelEdges() {
		var node = get(MyNodeLabels.theDuel.toString());
		var nextNode1 = get(MyNodeLabels.duel.toString());
		var duelChoice = new PlayerInteraction(player, approachExit, Furniture(ambushStreet, "Exit"));
		node.add(new Edge(duelChoice, nextNode1));
	}
	
	@BuilderMethod
	public void AssassinEdges() {
		var node = get(MyNodeLabels.assassinWeaponNode.toString());
		var nextNode1 = get(MyNodeLabels.mercenary.toString());
		var mercenaryChoice = new PlayerInteraction(openDoor, Furniture(armory, "BackDoor"), Icons.door, "Leave");
		node.add(new Edge(mercenaryChoice, nextNode1));
	}
	
	@BuilderMethod
	public void MercenaryEdges() {
		var node = get(MyNodeLabels.mercenary.toString());
		var nextNode1 = get(MyNodeLabels.mercTraining.toString());
		var mercTrainingChoice = new PlayerInteraction(talkToMercenary, mercenary, Icons.talk, "Confront Lancelot");
		node.add(new Edge(mercTrainingChoice, nextNode1));
	}
	
	@BuilderMethod public void MercTrainingEdges() {
		var node = get(MyNodeLabels.mercTraining.toString());
		var nextNode1 = get(MyNodeLabels.expDuel.toString());
		var toDuelfromMerc = new PlayerInteraction(player, mercenaryCamp, "Exit");
		node.add(new Edge(toDuelfromMerc, nextNode1));
	}
	//Christian Maron
	@BuilderMethod
	public void PotionEdge(){
		var node = get(MyNodeLabels.potion.toString());
		var nextNode1 = get(MyNodeLabels.potionApprenticeship.toString());
		
	}
	@BuilderMethod
	public void DarkArtsEdge(){
		var node = get(MyNodeLabels.darkArts.toString());
		var nextNode1 = get(MyNodeLabels.darkArtsApprenticeship.toString());
	}
	@BuilderMethod
	public void ArtsApprenticeshipEdge(){
		var node = get(MyNodeLabels.darkArtsApprenticeship.toString());
		var nextNode1 = get(MyNodeLabels.darkArtsBattle.toString());
	}
	@BuilderMethod
	public void PotionApprenticeshipEdge(){
		var node = get(MyNodeLabels.potionApprenticeship.toString());
		var nextNode1 = get(MyNodeLabels.potionBattle.toString());
	}
	@BuilderMethod
	public void MerlinDeathEdge(){
		var node = get(MyNodeLabels.merlinDeath.toString());
		var nextNode = get(MyNodeLabels.returnToTable.toString());
		
		
}
