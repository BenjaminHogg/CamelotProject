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
		//var nextNode2 = get(NodeLabels.)
	}
	
}
