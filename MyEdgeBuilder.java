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
		
		
	}
	
}
