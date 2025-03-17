package myclassproject.mystorygraph;

import java.util.List;

import com.storygraph.BuilderMethod;
import com.storygraph.Node;
import com.storygraph.NodeBuilder;
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
		var root = get(NodeLabels.root.toString());
		var choice = new MenuChoice(MenuChoice.Options.Start);
		var nextNode = get(NodeLabels.streetNar.toString());
		root.add(new Edge(choice, nextNode));
	}
	@BuilderMethod
	public void streetNarEdges() {
		var node = get(NodeLabels.streetNar.toString());
		var nextNode = get(NodeLabels.manApp.toString());
		var choice = new CloseNarrationChoice();
		node.add(new Edge(choice, nextNode));
	}
	@BuilderMethod
	public void manAppEdges() {
		var node = get(NodeLabels.manApp.toString());
		var nextNode1 = get(NodeLabels.ask.toString());
		var nextNode2 = get(NodeLabels.atkRec.toString());
		var askChoice = new DialogChoice("What do you want?");
		var attackChoice = new DialogChoice("ATTACK THE MAN");
		node.add(new Edge(askChoice, nextNode1));
		node.add(new Edge(attackChoice, nextNode2));
	}
	@BuilderMethod
	public void askRecruiterEdges() {
		var node = get(NodeLabels.askRecruiter.toString());
		var nextNode1 = get(NodeLabels.dontGowR.toString());
		var dontGoChoice = new DialogChoice("No I have no idea what you're talking about. Leave me be.");
		node.add(new Edge(dontGoChoice, nextNode1));
		//Other edge goes to Dark Table
		//Christian Maron
		var nextNode2 = get(NodeLabels.darkTable.toString());
		var joinChoice = new DialogChoice("I'll join");
		node.add(new Edge(joinChoice, nextNode2));
	}
	@BuilderMethod
	public void attackRecruiterEdges() {
		var node = get(NodeLabels.atkRec.toString());
		var nextNode1 = get(NodeLabels.darkTable.toString());
		var attackChoice = new DialogChoice("You have been taken by force.");
		node.add(new Edge(attackChoice, nextNode1));
	}

	@BuilderMethod
	public void theDarkTableEdges() {
		var node = get(NodeLabels.darkTable.toString());
		
		var nextNode1 = get(NodeLabels.arthur.toString());
		var arthurChoice = new DialogChoice("Challenge Arthur.");
		node.add(new Edge(arthurChoice, nextNode1));
		
		var nextNode2 = get(NodeLabels.lancelot.toString());
		var lancelotChoice = new DialogChoice("Challenge Lancelot.");
		node.add(new Edge(lancelotChoice, nextNode2));
		
		var nextNode3 = get(NodeLabels.merlin.toString());
		var merlinChoice = new DialogChoice("Challenge Merlin.");
		node.add(new Edge(merlinChoice, nextNode3));
		
		//Joseph Maggio
		var armoryNode = get(NodeLabels.armory.toString());
    		var armoryChoice = new DialogChoice("Visit the Armory.");
    		node.add(new Edge(armoryChoice, armoryNode));

    		var fletcherNode = get(NodeLabels.fletcher.toString());
    		var fletcherChoice = new DialogChoice("Visit the Fletcher.");
   		node.add(new Edge(fletcherChoice, fletcherNode));

    		var warlordWeaponNode = get(NodeLabels.warlordWeaponSelection.toString());
    		var warlordWeaponChoice = new DialogChoice("Select Your Warlord Weapon.");
    		node.add(new Edge(warlordWeaponChoice, warlordWeaponNode));
	}	
		
		
	}
	
}
